package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Writer;

@Mapper
public interface WriterMapper {
	
	//작가 삭제
	public int deleteWriter(String writerCode);
	
	//작가 수정
	public int modifyWriter(Writer writer);
	
	//작가 리스트 출력
	public List<Writer> writerList();
	
	public String selectWriteCode(String writer);
	
	public int addWriter(Writer writer);
}
