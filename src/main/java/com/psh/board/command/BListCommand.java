package com.psh.board.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.psh.board.dao.BDao;
import com.psh.board.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);
				
	}

}
