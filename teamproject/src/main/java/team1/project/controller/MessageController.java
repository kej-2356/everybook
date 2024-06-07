package team1.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
	
	@GetMapping("/officeMessageSend")
	public String messageSend() {
		return "message/officeMessageSend";
	}
	
	@GetMapping("/officeMessageText")
	public String messageText() {
		return "message/officeMessageText";
	}
}
