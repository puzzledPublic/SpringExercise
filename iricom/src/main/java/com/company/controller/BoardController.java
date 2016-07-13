package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.model.BoardVo;
import com.company.model.PagingVo;
import com.company.model.UserVo;
import com.company.service.BoardServiceImpl;
import com.company.util.DbgUtil;

@Controller
public class BoardController {

	@Autowired
	BoardServiceImpl boardServiceImpl;
	
	@Autowired
	DbgUtil dbgUtil;
	//�Խ��� ����Ʈ
	@RequestMapping("/list")
	public String boardList(@RequestParam(value="p", required = false, defaultValue="1") Integer requestPage,
							@RequestParam(value="bn", required = false) String boardName, Model model){
		//boardName�� �ִ��� ����
		if(boardName == null || boardName==""){
			return "redirect:/main";
		}
		//requestPage�� ������� ����
		if(requestPage < 0){
			return "redirect:/list?bn="+boardName;
		}
		//boardName �Խ����� �Խù� ����
		int totalArticleCount = 0;
		totalArticleCount = boardServiceImpl.selectCount(boardName);
		//����¡ ���
		PagingVo pagingVo = dbgUtil.paging(requestPage, 10, totalArticleCount);
		model.addAttribute("paging", pagingVo);
		//�Խù� ������ 0�� ��� 
		if(totalArticleCount == 0){
			model.addAttribute("hasItem", false);
			return "board/list";
		}
		List<BoardVo> boardVoList = boardServiceImpl.selectList(boardName, pagingVo.getFirstRow(), pagingVo.getEndRow());
		
		model.addAttribute("boardVoList", boardVoList);
		model.addAttribute("hasItem", true);
	
		return "/board/list";
	}
	//�� �ۼ� Form
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String writeForm(){
		return "/board/writeForm";
	}
	
	//�� �ۼ�
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String boardWrite(@RequestParam(value = "title", required = true) String title,
							 @RequestParam(value = "content", required = true) String content,
							 @RequestParam(value = "bn", required = true) String boardName,
							 Authentication auth){
		
		if(boardName == "" || boardName == null){
			return "redirect:/main";
		}
		
		String userId = dbgUtil.getUserId(auth);
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoardName(boardName);
		boardVo.setTitle(title);
		boardVo.setContent(content);
		boardVo.setUserId(userId);
		
		int result = boardServiceImpl.insert(boardVo);
		
		return "redirect:/list?bn="+boardName;
	}
	
}
