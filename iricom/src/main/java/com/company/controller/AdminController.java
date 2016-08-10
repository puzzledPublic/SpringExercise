package com.company.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.model.FileVo;
import com.company.model.ProductVo;
import com.company.service.ProductService;
import com.company.util.DbgUtil;

@Controller
public class AdminController {
	
	@Autowired
	DbgUtil dbgUtil;
	@Autowired
	ProductService productServiceImpl;
	
	@RequestMapping(value="/admin/upload", method=RequestMethod.GET)
	public String productUploadForm(){
		return "/admin/upload";
	}
	//��ǰ ���� ���ε� 
	@RequestMapping(value="/admin/upload", method=RequestMethod.POST)
	public String productUpload(@RequestParam(value="productName", required=true) String productName,
								@RequestParam(value="brandName", required=true) String brandName,
								@RequestParam(value="category", required=true) int category,
								@RequestParam(value="price", required=true) int price,
								@RequestParam(value="material", required=true) String material,
								@RequestParam(value="size") int[] size,
								@RequestParam(value="stock") int[] stock,
								@RequestParam(value="image") MultipartFile uploadFile){
		
		//System.out.println(productName +" "+brandName+" "+category+" "+price+" "+material+" "+size[0]+" "+size[1]+" "+size[2]+" "+stock[0]+" "+stock[1]+" "+stock[2]);
		
		//��ǰ ����
		ProductVo productVo = new ProductVo();
		productVo.setProductName(productName);
		productVo.setBrandName(brandName);
		productVo.setCategory(category);
		productVo.setPrice(price);
		productVo.setMaterial(material);
		
		productServiceImpl.insert(productVo);
		
		//��ǰ �ѹ� �ʿ�
		int productNo = productServiceImpl.selectNumber(productName);
		
		//��ǰ ������ ���
		productServiceImpl.insertSizeAndStock(size, stock, productName, productNo);
		
		//��ǰ �̹���
		String filePath = "C:\\Users\\KHM\\git\\iricom\\iricom\\src\\main\\webapp\\resources\\image\\";
		File file;
		FileVo fileVo;
		
		if(uploadFile.isEmpty() == false){
			try {
				fileVo = dbgUtil.parseUploadFileInfo(uploadFile);
				fileVo.setProductNo(productNo);
				//���� ����
				file = new File(filePath+ fileVo.getStoredFileName());
				//���� ����
				uploadFile.transferTo(file);
				
				//db�� fileInfo ���� productDao,service �����ʿ�
				productServiceImpl.insertImage(fileVo);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/main";
	}
}
