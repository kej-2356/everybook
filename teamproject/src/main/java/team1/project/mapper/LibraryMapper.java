package team1.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Library;

@Mapper
public interface LibraryMapper {
	
	//지역 도서관 출력
	public List<Library> selectLibraryCode(String regionCode);

	public Library getLibraryCodeSearch(String libraryNameSk);

	public List<Library> getLimitLibrarySearch(String sk, String sv, Map<String, Integer> map);
	
	public List<Library> getLimitLibraryList(Map<String, Integer> map);
	
	public int getLibraryCount();
	
	public List<Library> searchLibrary(String sk, String sv);
	
	public int deleteLibrary(Library library);
	
	public int modifyLibrary(Library library);
	
	public Library getSelectLibrary(String libraryCode);
	
	public int addLibrary(Library library);
	
	public List<Library> getLibraryList();
	
}
