package com.javaex.vo;

public class PostVo {

	//필드
	private int number;
	private int cateNo;
	private String postTitle;
	private String postContent;
	private String regDate;
	
	
	//생성자
	public PostVo() {
		super();
	}
	public PostVo(int number, int cateNo, String postTitle, String postContent, String regDate) {
		super();
		this.number = number;
		this.cateNo = cateNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.regDate = regDate;
	}
	
	//메소드 g/s
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	//메소드 - 일반
	@Override
	public String toString() {
		return "PostVo [number=" + number + ", cateNo=" + cateNo + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", regDate=" + regDate + "]";
	}
	
	
	
}
