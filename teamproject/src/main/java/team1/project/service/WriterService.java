package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.WriterMapper;
import team1.project.vo.Writer;

@Service
@Transactional
public class WriterService {
	@Autowired private WriterMapper writerMapper;
	
	//작가 삭제
	public int deleteWriter(String writerCode) {
		return writerMapper.deleteWriter(writerCode);
	};
	
	//작가 수정
	public int modifyWriter(Writer writer) {
		return writerMapper.modifyWriter(writer);
	};
	
	//작가 리스트 출력
	public List<Writer> writerList(){
		return writerMapper.writerList();
	};
	
	public int addWriter(Writer writer) {
		return writerMapper.addWriter(writer);
	}
	
	public String selectWriterCode(String writer) {
		return writerMapper.selectWriteCode(writer);
	}
}
