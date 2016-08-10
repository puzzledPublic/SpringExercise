package com.company.util;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.company.model.FileVo;
import com.company.model.PagingVo;
import com.company.model.UserVo;
@Component
public class DbgUtil {

	//requestPage : ��û����������
	//numberPerPage : �� �������� �Խñ� ����
	//totalArticleCount : �Խñ� �� ����
	public PagingVo paging(int requestPage, int numberPerPage, int totalArticleCount){
		
		final int PAGING_PAGE = 10;
		int totalPageCount = 0;
		int firstRow = 0;
		int endRow = 0;
		int beginPage = 0;
		int endPage = 0;
		
		if(totalArticleCount != 0 || requestPage < 0){
			//�Խñ� �� ������ �������� �Խñ� ������ ���� �� ������ ������ ����
			totalPageCount = totalArticleCount / numberPerPage;
			//�Ҽ��� �� ��� +1
			if(totalArticleCount > totalPageCount * numberPerPage){
				totalPageCount++;
			}
			//�Խñ� ù��° �� : (��û������ - 1) * ������ �� �Խñ� ���� + 1
			firstRow = (requestPage - 1) * numberPerPage + 1;
			//�Խñ� ������ �� : ù��° �� + ������ �� �Խñ� ���� - 1
			endRow = firstRow + numberPerPage - 1;
			//���� ������ ���� ��ü �Խñ� ���� ���� ũ�� ������ �࿡ �Խñ� ������ �ִ´�
			if(endRow > totalArticleCount){
				endRow = totalArticleCount;
			}
			//ȭ�� ����Ʈ�� ������ ������ ��ȣ
			if(totalPageCount != 0){
				beginPage = (requestPage - 1) / PAGING_PAGE * PAGING_PAGE + 1;
				endPage = beginPage + PAGING_PAGE - 1;
				if(endPage > totalPageCount){
					endPage = totalPageCount;
				}
			}
		}
		else{
			requestPage = 0;
		}
		
		PagingVo pagingVo = new PagingVo(requestPage, totalPageCount, firstRow, endRow, beginPage, endPage);
		return pagingVo;
		
	}
	
	public String getUserId(Authentication auth){
		
		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal != null && principal instanceof UserVo) {
				UserVo userVo = (UserVo) principal;
				
				return userVo.getUserId();
			}
		}
		return "none";
	}
	
	public FileVo parseUploadFileInfo(MultipartFile multipartFile) throws Exception{
		
		String originName;
		String storedName;
		String originExtension;
		FileVo fileVo = new FileVo();
		
		if(!multipartFile.isEmpty() && multipartFile.getContentType().contains("image")){
			originName = multipartFile.getOriginalFilename();
			originExtension = originName.substring(originName.lastIndexOf("."));
			storedName = getRandomString()+originExtension;
			
			fileVo.setOriginFileName(originName);
			fileVo.setStoredFileName(storedName);
			fileVo.setFileSize(multipartFile.getSize());
			
		}
		
		return fileVo;
	}
	
	private String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
