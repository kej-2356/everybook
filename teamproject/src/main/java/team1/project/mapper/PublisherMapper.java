package team1.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team1.project.vo.Publisher;

@Mapper
public interface PublisherMapper {
	
	//출판사 삭제
	public int deletePublisher(String publisherCode);
	
	//출판사 수정
	public int modifyPublisher(Publisher publisher);
	
	//출판사 리스트 출력
	public List<Publisher> publisherList();
	
	public int addPublisher(Publisher publisher);
	
	public String selectPublisherCode(String publisherName);
	
}
