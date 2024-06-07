package team1.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.BookService;
import team1.project.service.ReviewService;
import team1.project.vo.Book;
import team1.project.vo.Review;

@Controller
public class ReviewController {

	@Autowired private BookService bookService;
	@Autowired private ReviewService reviewService;
	
	//같은 도서관 코드가진 회원의 도서평 내역(직원)
	@GetMapping("/officeReviewList")
	public String officeReviewList(HttpSession session,Model model) {
		String libraryCode = (String)session.getAttribute("SLIBRARY");
		
		model.addAttribute("reviewList", reviewService.officeReviewList(libraryCode));
		return "review/officeReviewList";
	}
	
	//도서평 삭제처리(회원)
	@GetMapping(value="/deleteReview")
	@ResponseBody
	public int deleteReview(@RequestParam("reviewCode") String reviewCode) {
		
		return reviewService.deleteReview(reviewCode);
	}
	
	//도서평 수정처리(회원)
	@PostMapping("/modifyReview")
	public String modifyReview(Review review) {
		String reviewCode = review.getReviewCode();
		String reviewContent = review.getReviewContent();
		
		reviewService.updateReview(reviewCode, reviewContent);
		
		return "redirect:/reviewList";
	}
	
	//도서평 내역(회원)
	@GetMapping("/reviewList")
	public String reviewList(HttpSession session,Model model){
		String memberId = (String)session.getAttribute("SID");
		
		List<Review> review = reviewService.selectReview(memberId);
		model.addAttribute("reviewList", review);
		return "review/reviewList";
	}
	
	//도서평 등록처리(회원)
	@PostMapping("/addReview")
	public String addReview(Review review,HttpSession session) {
		System.out.println("도서평등록화면에서 가져온 값 >>> "+review.toString());
		String memberId =  (String)session.getAttribute("SID");
		review.setMemberId(memberId);
		
		reviewService.addReview(review);
		return "redirect:/myRent";
	}
	
	//도서평 등록화면(회원)
	@GetMapping("/addReview")
	public String addReview(@RequestParam("send_code")String rentCode,Model model) {
		Book bookName = bookService.getBookName(rentCode);
		System.out.println("대여코드로 가져온 도서 이름 >>> "+bookName);
		model.addAttribute("bookName", bookName);
		return "review/addReview";
	}
	
}
