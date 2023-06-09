package com.psh.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psh.board.command.BContentCommand;
import com.psh.board.command.BListCommand;
import com.psh.board.command.BModifyCommand;
import com.psh.board.command.BWriteCommand;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/write_form")
	public String write_form() {
		
		return "writeForm";
	}
	
	@RequestMapping(value="/write")
	public String write(HttpServletRequest request, Model model) {
//		request.getParameter("bname");
		
		model.addAttribute("request", request);
		
		BWriteCommand command = new BWriteCommand();
		command.execute(model);
		
		
		return "redirect:list";
	}
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		BListCommand command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	@RequestMapping(value="/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		BContentCommand command = new BContentCommand();
		command.execute(model);
		
		
		return "contentView";
		
	}
	@RequestMapping(value= "/modify_form")
	public String modify_form(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		BContentCommand command = new BContentCommand();
		command.execute(model);
		
		return "modifyForm";
	}
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		BModifyCommand command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
		
	}
	
}
