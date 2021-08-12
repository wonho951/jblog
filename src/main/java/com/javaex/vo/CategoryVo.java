package com.javaex.vo;

public class CategoryVo {

	//필드
	private int cateNo;
	private String id;
	private String cateName;
	private String description;
	private String regDate;
	
	private int postCount;
	
	//생성자
	public CategoryVo() {
		super();
	}
	
	
	public CategoryVo(String id, String cateName, String description) {
		super();
		this.id = id;
		this.cateName = cateName;
		this.description = description;
	}

	public CategoryVo(int cateNo, String id, String cateName, String description, String regDate) {
		super();
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}
	
	public CategoryVo(int cateNo, String id, String cateName, String description, String regDate, int postCount) {
		super();
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
		this.postCount = postCount;
	}


	//메소드 g/s
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}



	//메소드 - 일반
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + ", postCount=" + postCount + "]";
	}

	
	
	
	
	
}
