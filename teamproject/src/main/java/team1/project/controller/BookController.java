package team1.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.service.ReviewService;
import team1.project.vo.Book;
import team1.project.vo.Review;
import team1.project.vo.Unicode;

@Controller
public class BookController {
	private final static Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired private BookService bookService;
	@Autowired private ReviewService reviewService;
	
	@GetMapping("/addBook")
	public String addBook(Book book, HttpSession session){
		logger.info("책등록 시작book",book);
		String officerId = (String) session.getAttribute("SID");
		String libraryCode = (String) session.getAttribute("SLIBRARY");
		book.setOfficerId(officerId);
		book.setLibraryCode(libraryCode);
		//책 추가
		int i =bookService.addBook(book);
		logger.info("책등록 실행경과 : {}",i);
		return "book/officeAddbook";
	}
	
	@GetMapping("/addBookLibraryCode")
	@ResponseBody
	public Book addBookLibraryCode(@RequestParam("writer") String writer, @RequestParam("bookName") String bookName, HttpSession session) {
		List<Map<String, Character>> nameList = bookService.getCharList(writer);
		String secWrite = Unicode.codeNum(nameList);
		String reWriter = nameList.get(0).get("char").toString() + secWrite;
		String libraryCode = (String) session.getAttribute("SLIBRARY");
		logger.info("libraryCode : {}",libraryCode);
		int num = bookService.sameNameCount(libraryCode, bookName, writer);
		Book book = new Book();
		book.setBookLibraryCode(reWriter);
		if(num != 0) {
			book.setReserveCount(num + 1);
		}
		
		return book;
	}
	
	/**
	 * 책등록에서 isbn으로 책 정보 조회하는 api 호출
	 * @param isbn
	 * @return Book isbnSearch
	 */
	@GetMapping("/searchIsbn")
	@ResponseBody
	public Book searchIsbn(@RequestParam("isbn") String isbn) {
		Book isbnSearch = bookService.searchIsbn(isbn);
		return isbnSearch;
	}
	
	@GetMapping("/bookDetail")
	public String bookDetail(Model model, @RequestParam(name="bookCode") String bookCode) {
		logger.info("bookCode : {}",bookCode);
		Book bookDetail = bookService.getBookDetail(bookCode);
		model.addAttribute("bookDetail", bookDetail);
		
		List<Review> reviewList = new ArrayList<Review>();
		reviewList = reviewService.ISBNReveiwList(bookCode);
		model.addAttribute("reviewList", reviewList);
		return "book/bookDetail";
	}
	@GetMapping("/bookList")
	public String bookList() {
		return "book/bookList";
	}
	@GetMapping("/officeAddbook")
	public String officeAddbook() {
		return "book/officeAddbook";
	}
	@GetMapping("/officeBooklist")
	public String officeBookList(Model model) {
		List<Book> list = bookService.officeBookList();
		logger.info("list : {}",list);
		model.addAttribute("officeBookList", list);
		return "book/officeBooklist";
	}
}
