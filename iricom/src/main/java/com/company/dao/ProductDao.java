package com.company.dao;

import java.util.List;
import java.util.Map;

import com.company.model.ExtProductVo;
import com.company.model.FileVo;
import com.company.model.ProductVo;

public interface ProductDao {

	//��ǰ �� ����
	public int selectCount();
	//ī�װ� �� ��ǰ ����
	public int selectCountCate(int category);
	//��ǰ �̸� �� ���
	public List<ProductVo> selectListByName(String productName);
	//��ǰ ī�װ� �� ���
	public List<ExtProductVo> selectListByCate(int category);
	//��ǰ ������
	public ProductVo selectDetail(int number);
	//��ǰ ���
	public List<Map<Integer, Integer>> selectStock(String productName);
	//��ǰ ������, ��� ���
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
