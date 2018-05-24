package org.skye.controller;

import java.util.List;

import org.skye.dto.MessageDto;
import org.skye.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping
	public String initList(Model model) {
		model.addAttribute("list", messageService.getList());
		model.addAttribute("msg", "ahh");
		 List<MessageDto> list =  messageService.getList();
		 MessageDto messageDto = (MessageDto) list.get(0);
		 System.out.println(messageDto.getContent());
		return "/back/list";
	}
	
}
