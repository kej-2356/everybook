package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrokenController {

	@GetMapping("officeModifyBroken")
	public String officeModifyBroken() {
		return "broken/officeModifyBroken";
	}
	
	@GetMapping("officeBrokenList")
	public String officeBrokenList() {
		return "broken/officeBrokenList";
	}
	
	@GetMapping("officeAddBroken")
	public String officeAddBroken() {
		return "broken/officeAddBroken";
	} 
	
}
