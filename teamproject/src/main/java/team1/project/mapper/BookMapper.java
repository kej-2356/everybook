package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Book;

@Mapper
public interface BookMapper {
	//도서코드로 책 하나 검색
	public Book getBookDetail(String bookCode);
	
	//청구기호로 도서 검색
	public Book bookLibraryCodeSelectBook(String bookLibraryCode);
	
	//isbn과 도서관 코드로 책 검색
	public List<Book> isbnSelectBook(String bookIsbn, String libraryCode);

	//책등록
	public int addBook(Book book);

	//대여코드로 북 이름과 ISBN 출력
	public Book getBookName(String rentCode);

	//같은 이름의 책 몇 권 있는지 조회
	public int sameNameCount(String libraryCode, String bookName, String writer);
	
	//대여중인 도서 예약 권수
	public Book reserveBookCount(String bookLibraryCode, String libraryCode);
	
	//도서관책코드로 하나의 도서관에서 도서정보 검색
	public Book officeBookSerch(String bookLibraryCode, String libraryCode);
	
	//도서 이름으로 검색하여 도서리스트 출력
	public List<Book> officeBookSerchList(String bookName, String libraryCode);
	
	//소장도서리스트
	public List<Book> officeBookList();
}
