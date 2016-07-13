package com.company.service;

import java.util.List;
import java.util.Map;

import com.company.model.ProductVo;

public interface ProductService {

	//��ǰ �� ����
		public int selectCount();
		//ī�װ� �� ��ǰ ����
		public int selectCountCate(int category);
		//��ǰ �̸� �� ���
		public List<ProductVo> selectListByName(String productName);
		//��ǰ ī�װ� �� ���
		public List<ProductVo> selectListByCate(int category);
		//��ǰ ������
		public ProductVo selectDetail(int number, String productName);
		//��ǰ ���
		public int insert(ProductVo productVo);
		//��ǰ ����
		public int update(ProductVo productVo, int number);
		//��ǰ ����
		public int delete(String productName);
}
