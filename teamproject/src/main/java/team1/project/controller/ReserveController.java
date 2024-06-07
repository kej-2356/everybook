package team1.project.controller;

import java.util.List;

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
import team1.project.service.RtcanReserveService;
import team1.project.vo.Book;
import team1.project.vo.Member;
import team1.project.vo.RtcanReserve;

@Controller

public class ReserveController {
	
	private final static Logger logger = LoggerFactory.getLogger(ReserveController.class);
	
	@Autowired MemberService memberSerive;
	@Autowired BookService bookService;
	@Autowired RtcanReserveService rtcanReserveService;
	
	/*오프라인 예약*/
	
	//직원 화면 : 오프라인 예약을 위한 책 코드 조회
	@GetMapping("/reserve/getSelectBook")
	@ResponseBody
	public Book officeBookSerch(String bookLibraryCode, String libraryCode) {
		logger.info("bookname : {}", bookLibraryCode);
		logger.info("libraryCode : {}", libraryCode);
		Book book = bookService.officeBookSerch(bookLibraryCode, libraryCode);
		logger.info("book : {}",book);
		return book;
	}
	 
	//직원화면 : 오프라인 예약을 위한 책제목 조회
	@GetMapping("/reserve/bookSearch")
	@ResponseBody
	public List<Book> getSelectBook(String bookName, String libraryCode) {
		logger.info("bookname : {}", bookName);
		logger.info("libraryCode : {}", libraryCode);
		List<Book> book = bookService.officeBookSerchList(bookName, libraryCode);
		return book;
	}
	
	//직원 화면 : 오프라인 예약을 위한 회원 조회
	@GetMapping("/reseve/getSelectMember")
	@ResponseBody
	public Member getSelectMember(String memberId) {
		Member member = memberSerive.selectgetMember(memberId);
		return member;
	}
	
	//직원 화면 : 오프라인 예약 등록 화면 
	@GetMapping("/officeRtingReserveAdd")
	public String rtingReserveAdd() {
		return "reserve/officeRtingReserveAdd";
	}
	
	//직원 화면 :  등록 된 오프라인 예약 리스트
	@GetMapping("/officeRtingReserveList")
	public String rtingReserveList() {
		return "reserve/officeRtingReserve";
	}
	
	/* 온라인 예약  */
	/**
	 * 조건에 따른 검색 리스트
	 * @param sk  : 검색 조건
	 * @param sv : 검색어
	 * @param model
	 * @return "reserve/officeRtcanReserveList" 
	 */
	@GetMapping("/getSearchRtcanReserve")
	public String getSearchRtcanReserve(@RequestParam("sk") String sk, @RequestParam("sv") String sv, Model model) {
		logger.info("조건에 따른 검색");
		logger.info("sk : {}",sk);
		logger.info("sv : {}",sv);
		List<RtcanReserve> rtcanReserveList = rtcanReserveService.getSearchRtcanReserve(sk, sv);
		model.addAttribute("rtcanReserveList", rtcanReserveList);
		return "reserve/officeRtcanReserveList";
	}
	/**
	 * 하나의 예약 삭제하기
	 * @param rtcanReserve
	 * @return "redirect:/officeRtcanReserveList"
	 */
	@PostMapping("/deleteReserve")
	public String deleteRtcanReserve(RtcanReserve rtcanReserve) {
		logger.info("예약 삭제 : {}",rtcanReserve);
		int i = rtcanReserveService.deleteRtcanReserve(rtcanReserve);
		logger.info("실행결과 : {}",i);
		return "redirect:/officeRtcanReserveList";
	}
	/**
	 * 예약 코드로 하나의 예약 정보 조회하기 - ajax 호출
	 * @param rtcanCode
	 * @return rtcanReserve
	 * @responsBody rtcanReserve 자기 자신 리턴
	 * 체크 박스를 하나 클릭 후 수정이나 삭제 버튼 클릭시 예약 정보 select
	 */
	@GetMapping("/getSelectReserve")
	@ResponseBody
	public RtcanReserve getSelectReserve(@RequestParam("rtcanCode") String rtcanCode) {
		logger.info("온라인 예약 수정 rtcanCode : {} ", rtcanCode);
		RtcanReserve rtcanReserve = rtcanReserveService.getSelectRtcanReserve(rtcanCode);
		logger.info("하나의 온라인 예약 : {} ", rtcanReserve);
		return rtcanReserve;
	}
	
	/**
	 * 직원 화면 : 등록된 온라인 예약 리스트
	 * @param model
	 * @param session
	 * @return "reserve/officeRtcanReserveList"
	 * 모든 온라인 예약 리스트 화면
	 */
	@GetMapping("/officeRtcanReserveList")
	public String rtcanReserveList(Model model, HttpSession session) {
		logger.info("처리된 온라인 예약 리스트");
		String libraryCode = (String) session. getAttribute("SLIBRARY");
		logger.info("session 값 : {}",libraryCode);
		List<RtcanReserve> rtcanReserveList = rtcanReserveService.getRtcanReserveList(libraryCode);
		model.addAttribute("rtcanReserveList", rtcanReserveList);
		return "reserve/officeRtcanReserveList";
	}
	
	/**
	 * 직원 온라인 예약 등록 화면에서 예약 승인 하기
	 * @param rtcanReserve
	 * @return"reserve/officeRtcanReserveList"
	 * 대기 상태의 도서 예약을 승인 혹은 거절 상태로 업데이트
	 */
	@PostMapping("/officeRtcanReserveModify")
	public String officeRtcanReserveModify(RtcanReserve rtcanReserve) {
		logger.info("온라인 예약 승인하기 : {}",rtcanReserve.toString());
		int i = rtcanReserveService.modifyRtcanReserve(rtcanReserve);
		logger.info("실행결과 : {}",i);
		return "redirect:/officeRtcanReserveList";
	}
	
	/**
	 * 직원 온라인 예약 등록화면 : 회원이 등록한 책 예약 확인 후 직원이 승인하기 위한 화면
	 * @param model
	 * @param session
	 * @return "reserve/officeRtcanReserveAdd"
	 * 직원이 로그인 되어있는 도서관 값으로 현재 회원이 등록한 대기상태의 예약을 확인하여 리스트로 출력
	 * int num은 테이블 상단의 현재 미승인 상태의 예약 건수를 가져오기 위한 변수 
	 */
	@GetMapping("/officeRtcanReserveAdd")
	public String officeRtcanReserveAdd(Model model, HttpSession session) {
		String libraryCode = (String) session. getAttribute("SLIBRARY");
		logger.info("session 값 : {}",libraryCode);
		List<RtcanReserve> rtcanReserveList = rtcanReserveService.addRtcanReserveList(libraryCode);
		int num = rtcanReserveService.getReserveCount();
		model.addAttribute("rtcanReserveList", rtcanReserveList);
		model.addAttribute("num", num);
		return "reserve/officeRtcanReserveAdd";
	}
	
	
	
	/* 회원 예약 */
	/**
	 * 회원화면 : 온라인 예약 등록 insert
	 * @param rtcanReserve
	 * @return"book/bookDetail"
	 * detail : 책 상세페이지에서 예약 버튼 클릭시 현재 시간으로 대기 상태의 예약이 등록됨
	 */
	@PostMapping("/rtcanReserveAdd")
	public String rtcanReserveAdd(RtcanReserve rtcanReserve) {
		logger.info("온라인 예약 insert : {}",rtcanReserve.toString());
		int i = rtcanReserveService.addRtcanReserve(rtcanReserve);
		logger.info("실행경과 : {}", i);
		return "book/bookDetail";
	}
	
	//회원 화면 : 회원 예약 리스트 출력
	@GetMapping("/myReserve")
	public String myReserve() {
		return "reserve/myReserve";
	}
}
