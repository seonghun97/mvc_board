package com.psh.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.psh.board.dao.BDao;
import com.psh.board.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		//model 안에있는 request 객체를 빼기위해 map 형식으로 매핑 후 Map의 키값인 request로 request 객체를뺌
		
		String bid = request.getParameter("bid");
		
		BDao dao = new BDao();
		BDto dto = dao.content_view(bid);
		
		model.addAttribute("content", dto);
		
		
		
	}

}
