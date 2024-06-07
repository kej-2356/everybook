package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Review;

@Mapper
public interface ReviewMapper {

	//ISBN이 같은 도서의 도서평 내역
	public List<Review> ISBNReveiwList(String bookCode);
	
	//같은 도서관 코드가진 회원의 도서평 내역(직원)
	public List<Review> officeReviewList(String libraryCode);
	
	//도서평 삭제(회원)
	public int deleteReview(String reviewCode);
	
	//도서평 수정(회원)
	public int updateReview(String reviewCode,String reviewContent);
	
	//도서평 내역(회원)
	public List<Review> selectReview(String memberId);
	
	//도서평 등록
	public int addReview(Review review);
}
