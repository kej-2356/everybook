package team1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team1.project.service.RegionService;
import team1.project.vo.Region;

@Controller
public class MainController {
	
	@Autowired	private RegionService regionService;
	
	@GetMapping("/libraryTime")
	public String liberayTime() {
		return "information/libraryTime";
	}

	@GetMapping("/")
	public String login() {
		return "login";

	}
	
	@GetMapping("/office")
	public String office() {
		return "admin/indexAdmin";
	}
	
	@GetMapping("/myLibrary")
	public String myLibrary() {
		return "information/myLibrary";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		List<Region> majorList = regionService.getRegionMajorList();
		List<Region> regionList = regionService.getOfficeRegionList();
		model.addAttribute("majorList", majorList);
		model.addAttribute("regionList", regionList);
		return "index";
	}

}
