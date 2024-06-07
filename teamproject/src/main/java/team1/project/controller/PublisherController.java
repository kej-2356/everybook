package team1.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team1.project.service.PublisherService;
import team1.project.vo.Publisher;


@Controller
public class PublisherController {

	@Autowired PublisherService publisherService;
	
	//출판사 삭제
	@GetMapping(value="/deletePublisher")
	@ResponseBody
	public int deletePublisher(@RequestParam("publisherCode") String publisherCode) {
		
		return publisherService.deletePublisher(publisherCode);
	} 
	
	//출판사 수정
	@PostMapping("/modifyPublisher")
	public String modifyPublisher(Publisher publisher) {
		
		publisherService.modifyPublisher(publisher);
		return "redirect:/officePublisherList";

	}
	
	//출판사 등록
	@PostMapping("/addPublisher")
	public String addPublisher(Publisher publisher) {
		
		publisherService.addPublisher(publisher);
		return "redirect:/officePublisherList";
	}
	
	//출판사 리스트
	@GetMapping("/officePublisherList")
	public String officePublisherList(Model model) {
		List<Publisher> publisherList = new ArrayList<Publisher>();
		publisherList = publisherService.publisherList();
		
		model.addAttribute("publisherList", publisherList);
		return "publisher/officePublisherList";
	}
}
