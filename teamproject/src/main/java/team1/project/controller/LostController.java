package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LostController {

	@GetMapping("officeModifyLost")
	public String officeModifyLost() {
		return "lost/officeModifyLost";
	} 
	
	@GetMapping("officeLostList")
	public String officeLostList() {
		return "lost/officeLostList";
	}
	
	@GetMapping("officeAddLost")
	public String officeAddLost() {
		return "lost/officeAddLost";
	}
	
	
}
