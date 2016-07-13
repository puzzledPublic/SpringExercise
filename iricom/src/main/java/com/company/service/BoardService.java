package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.model.BoardVo;

public interface BoardService {

	//��ü �Խ��� �Խñ� ���� ��ȸ
		public int selectCount();
		//board_name�Խ��� �Խñ� ���� ��ȸ
		public int selectCount(String boardName);
		//��ü �Խ��� ����Ʈ ��ȸ
		public List<BoardVo> selectList(int firstRow, int endRow);
		//board_name�Խ��� ����Ʈ ��ȸ
		public List<BoardVo> selectList(String boardName, int firstRow, int endRow);
		//�Խñ� �ۼ�
		public int insert(BoardVo boardVo);
		//�Խñ� ����
		public int update(BoardVo boardVo);
		//�Խñ� ����
		public int delete(int boardNumber);
		//��ȸ�� ����
		public void increaseReadCount(int boardNumber);
	
}
