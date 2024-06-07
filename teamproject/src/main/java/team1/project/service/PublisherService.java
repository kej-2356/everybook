package team1.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team1.project.mapper.PublisherMapper;
import team1.project.vo.Publisher;

@Service
@Transactional
public class PublisherService {
	
	@Autowired PublisherMapper publisherMapper;
	
	//출판사 삭제
	public int deletePublisher(String publisherCode) {
		return publisherMapper.deletePublisher(publisherCode);
	};
	
	//출판사 수정
	public int modifyPublisher(Publisher publisher) {
		return publisherMapper.modifyPublisher(publisher);
	};
	
	//출판사 리스트 출력
	public List<Publisher> publisherList(){
		return publisherMapper.publisherList();
	};
	
	public int addPublisher(Publisher publisher) {
		return publisherMapper.addPublisher(publisher);
	}
	
	public String selectPublisherCode(String publisherName) {
		return publisherMapper.selectPublisherCode(publisherName);
	}

}
