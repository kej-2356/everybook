package team1.project.controller;

import java.util.List;
import java.util.jar.Attributes.Name;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.service.MemberService;
import team1.project.service.RentService;
import team1.project.vo.Book;
import team1.project.vo.Member;
import team1.project.vo.Rent;

@Controller
public class RentController {
	private final static Logger logger = LoggerFactory.getLogger(RentController.class);
	@Autowired private RentService rentService;
	@Autowired private MemberService memberService;
	@Autowired private BookService bookService;
	
	//대여처리
	@PostMapping("/addBookRent")
	public String addBookRent(Rent rent, HttpSession session) {
		String Sid = (String) session.getAttribute("SID");
		rent.setOfficerId(Sid);
		logger.info("대여처리 --> " + rent);
		rentService.addBookRent(rent);
		return "rent/officeBookRent";
	}
	
	//청구기호로 검색시 도서 정보 검색하여 화면에 출력
	@GetMapping("/rent/getSelectBook")
	@ResponseBody
	public Book getSelectBook(String bookLibraryCode) {
		logger.info("getSelectBook RentController.java");
		Book book = bookService.bookLibraryCodeSelectBook(bookLibraryCode);
		logger.info("book : "+ book);
		return book;
	}
	
	//회원 아이디로 검색시 회원 정보 검색하여 화면에 출력
	@GetMapping("/rent/getSelectMember")
	@ResponseBody
	public Member getSelectMember(String memberId) {
		Member member = memberService.selectgetMember(memberId);
		logger.info("member -> " + member);
		return member;
	}
	
	//대여관리 - 대여리스트 삭제처리
	@PostMapping("/officeRentDelete")
		public String officeRentDelete(Rent rent) {
		int i = rentService.officeRentDelete(rent);
		logger.info("실행결과 --> " + i);
		return "redirect:/officeBookRent";
	}
	
	//대여관리 -대여리스트 삭제(선택한 로우의 대여코드 받아오기)
	@GetMapping(value="/selectRent")
	@ResponseBody
	public Rent getRentCode(@RequestParam("rentCode") String rentCode) {
		logger.info(rentCode + " <-- getRentCode RentController.java");
		logger.info("========= getRentCode RentController.java =======");
		Rent rent = rentService.getRentCode(rentCode);
		logger.info(rent.toString());

		return rent;
	}
	
	//나의 대여 이력 - 검색
	@GetMapping("/myRentHistorySearch")
	public String myRentHistorySearch(Model model,
						HttpSession session,
						@RequestParam(name = "sk") String sk,
						@RequestParam(name = "sv") String sv) {
		
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " +SID);
		
		List<Rent> rentHistory = rentService.myRentHistorySearch(sk, sv, SID);
		model.addAttribute("rentHistory", rentHistory);
		return "rent/myRent";
	}
	
	//나의 대여 이력
	@GetMapping("/myRent")
		public String myRentHistoryList(Model model, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		logger.info("SID --> " +SID);

		List<Rent> rentHistory = rentService.myRentHistoryList(SID);
		logger.info("rentHistory --> " +rentHistory);
		model.addAttribute("rentHistory", rentHistory);
			
		return "rent/myRent";
	}
	
	//대여관리 - 대여리스트 검색
	@GetMapping("/OfficeRentListSerch")
	public String OfficeRentListSerch(Model model,
						@RequestParam(name = "sk") String sk,
						@RequestParam(name = "sv") String sv) {
		logger.info("sk : " + sk + " sv : " + sv);
		List<Rent> officeRentList = rentService.OfficeRentListSerch(sk, sv);
		model.addAttribute("officeRentList", officeRentList);
		
		return "rent/officeBookRent";
	}
	
	//대여관리 - 대여리스트
	@GetMapping("/officeBookRent")
	public String officeRentList(Model model) {
		List<Rent> officeRentList = rentService.officeRentList();
		logger.info("officeRentList --> " +officeRentList);
		model.addAttribute("officeRentList", officeRentList);
		
		return "rent/officeBookRent";
	}
}
