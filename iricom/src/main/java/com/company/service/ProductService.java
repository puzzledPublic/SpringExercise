package com.company.service;

import java.util.List;

import com.company.model.ExtProductVo;
import com.company.model.FileVo;
import com.company.model.ProductVo;

public interface ProductService {

	//��ǰ �� ����
		public int selectCount();
		//ī�װ� �� ��ǰ ����
		public int selectCountCate(int category);
		//��ǰ �̸� �� ���
		public List<ProductVo> selectListByName(String productName);
		//��ǰ ī�װ� �� ���
		public List<ExtProductVo> selectListByCate(int category);
		//��ǰ ������
		public ProductVo selectDetail(int number, String productName);
		//��ǰ ������ �� ��� ���
		public int insertSizeAndStock(int[] size, int[] stock, String productName, int productNo);
		//��ǰ ���
		public int insert(ProductVo productVo);
		//��ǰ ����
		public int update(ProductVo productVo, int number);
		//��ǰ ����
		public int delete(String productName);
		//��ǰ �̹��� ���
		public int insertImage(FileVo fileVo);
		//��ǰ �̹��� ��������
		public FileVo selectImage(int productNo);
		//no ��������
		public int selectNumber(String productName);
}
