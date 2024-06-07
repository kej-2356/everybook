package team1.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.BookService;
import team1.project.service.RecommendService;
import team1.project.vo.Book;

@Controller
public class RecommendController {
	
	private final static Logger logger = LoggerFactory.getLogger(RecommendController.class);
	@Autowired RecommendService recommendservice;
	@Autowired BookService bookService;
	
	@GetMapping("/vogueBookList")
	public String getVogueBookList() {
		return "recommend/vogueBookList";
	}
	
	@GetMapping("/recommendList")
	public String getRecommendList(HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("SID");
		String libraryCode = (String) session.getAttribute("SLIBRARY");
		List<String> bookIsbn = recommendservice.recommendList(memberId);
		List<Book> book = new ArrayList<Book>();
		for(int i =0 ; i<bookIsbn.size();i++) {
			List<Book> getBook = bookService.isbnSelectBook(bookIsbn.get(i), libraryCode);
			//logger.info("getbook : {}",getBook);
			if(getBook != null) {
				book.addAll(getBook);
			}
		}
		logger.info("book : {}", book);
		model.addAttribute("book", book);
		return "recommend/recommendList";
	}
	

}
