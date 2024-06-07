package team1.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.controller.LibraryController;
import team1.project.mapper.LibraryMapper;
import team1.project.vo.Library;

@Service
@Transactional
public class LibraryService {
	
	private final static Logger logger = LoggerFactory.getLogger(LibraryController.class);
	@Autowired private LibraryMapper librarymapper;
	
	//도서관이름으로 코드검색
	public Library getLibraryCodeSearch(String libraryNameSk) {
		return librarymapper.getLibraryCodeSearch(libraryNameSk);
	}
	
	public List<Library> selectLibraryCode(String regionCode){
		return librarymapper.selectLibraryCode(regionCode);
	}
	
	public Map<String, Object> getLimitLibrarySearch(String sk, String sv){
		final int ROW_PER_PAGE = 10;
		int currentPage = 1;
		int startPageNum = 1;
		int lastPageNum = ROW_PER_PAGE;
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage - ((lastPageNum/2)-1);
			lastPageNum += (startPageNum-1);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		
		map.put("currentPage", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		double libraryCount = librarymapper.getLibraryCount();
		logger.info("도서관 전체 갯수 : {}",libraryCount);
		
		
		// view에 보여질 마지막 페이지의 수(전체행의 갯수/보여줄 행의 갯수-> 올림)
		int lastPage = (int)(Math.ceil(libraryCount/ROW_PER_PAGE));
		
		// view에 현재 페이지가 마지막페이지보다 4작을 경우 view쪽의 반복문의 반복횟수를 조정
		if(currentPage >= (lastPage-4)) {
			lastPageNum = lastPage;
		}
		
		// view에 보여질 페이징 처리를 위해 값을 Map에 담아 리턴
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", librarymapper.getLimitLibrarySearch(sk, sv, map));
		returnMap.put("currentPage", currentPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("startPageNum", startPageNum);
		returnMap.put("lastPageNum", lastPageNum);
		logger.info("returnMap : {}",returnMap);
		
		return returnMap;
	}
	
	public int getLibraryCount() {
		return librarymapper.getLibraryCount();
	}
	
	public List<Library> searchLibrary(String sk, String sv){
		return librarymapper.searchLibrary(sk, sv);
	}
	
	public int deleteLibrary(Library library) {
		return librarymapper.deleteLibrary(library);
	}
	
	public int modifyLibrary(Library library) {
		return librarymapper.modifyLibrary(library);
	}
	
	public Library getSelectLibrary(String libraryCode) {
		return librarymapper.getSelectLibrary(libraryCode);
	}
	
	public int addLibrary(Library library) {
		return librarymapper.addLibrary(library);
	}
	
	public List<Library> getLibraryList(){
		return librarymapper.getLibraryList();
	}
	
	public Map<String, Object> getLimitLibraryList(int currentPage){
		final int ROW_PER_PAGE = 10;
		int startPageNum = 1;
		int lastPageNum = ROW_PER_PAGE;
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage - ((lastPageNum/2)-1);
			lastPageNum += (startPageNum-1);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		
		map.put("currentPage", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		double libraryCount = librarymapper.getLibraryCount();
		logger.info("도서관 전체 갯수 : {}",libraryCount);
		
		
		// view에 보여질 마지막 페이지의 수(전체행의 갯수/보여줄 행의 갯수-> 올림)
		int lastPage = (int)(Math.ceil(libraryCount/ROW_PER_PAGE));
		
		// view에 현재 페이지가 마지막페이지보다 4작을 경우 view쪽의 반복문의 반복횟수를 조정
		if(currentPage >= (lastPage-4)) {
			lastPageNum = lastPage;
		}
		
		// view에 보여질 페이징 처리를 위해 값을 Map에 담아 리턴
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", librarymapper.getLimitLibraryList(map));
		returnMap.put("currentPage", currentPage);
		returnMap.put("lastPage", lastPage);
		returnMap.put("startPageNum", startPageNum);
		returnMap.put("lastPageNum", lastPageNum);
		logger.info("returnMap : {}",returnMap);
		
		return returnMap;
	}
}
