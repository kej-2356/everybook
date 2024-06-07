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

import team1.project.service.WriterService;
import team1.project.vo.Writer;


@Controller
public class WriterController {

	@Autowired private WriterService writerService;
	
	//작가 삭제
	@GetMapping(value="/deleteWriter")
	@ResponseBody
	public int deleteWriter(@RequestParam("writerCode") String writerCode) {
		return writerService.deleteWriter(writerCode);
	}
	
	//작가 수정
	@PostMapping("/modifyWriter")
	public String modifyWriter(Writer writer) {
		
		writerService.modifyWriter(writer);
		return "redirect:/officeWriterList";
	}
	
	//작가 등록
	@PostMapping("/addWriter")
	public String addWriter(Writer writer) {
		
		writerService.addWriter(writer);
		return "redirect:/officeWriterList";
	}
	
	//작가리스트
	@GetMapping("/officeWriterList")
	public String officeWriterList(Model model) {
		List<Writer> writerList = new ArrayList<Writer>();
		writerList = writerService.writerList();	
		
		model.addAttribute("writerList", writerList);
		return "writer/officeWriterList";
	}
	
}
