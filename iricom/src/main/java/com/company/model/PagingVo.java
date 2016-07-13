package com.company.model;

public class PagingVo {

	private int requestPage; //��û ������
	private int totalPageCount; //�� ������ ����
	private int firstRow; //��û�������� �ش��ϴ� �Խñ��� ù Row
	private int endRow; //��û�������� �ش��ϴ� �Խñ��� ������ Row
	private int beginPage; //ȭ�鿡 ��� �� ���� page ��ȣ
	private int endPage; //ȭ�鿡 ��� �� ������ page ��ȣ
	
	public PagingVo(int requestPage, int totalPageCount, int firstRow, int endRow, int beginPage, int endPage) {
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.firstRow = firstRow;
		this.endRow = endRow;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}

	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
	
	
}
