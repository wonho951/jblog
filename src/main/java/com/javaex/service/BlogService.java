package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	//블로그 들어갈때 쓸 id 꺼내오기
	public BlogVo selectOne(String id) {
		System.out.println("[BlogService.selectOne(id)]" + id);
		
		return blogDao.selectOne(id);
	}
	
	
	//블로그 기본설정(타이틀, 이미지 바꾸기)
	public void upload(BlogVo blogVo, MultipartFile file) {
		System.out.println("[BlogService.upload(vo,file)]");
		System.out.println("blogVo : " + blogVo);
		
	     
	      //파일 사이즈
	      long fileSize = file.getSize();
	      System.out.println("fileSize : " + fileSize);
	      //System.out.println(file.getOriginalFilename());
	      //System.out.println(file.getSize());
	      
	      if(fileSize>0) {
	    	  
	    	  /*******************파일 업로드 준비 단계****************************/
		      //파일 경로가 바뀔수도 있으니 따로 빼둠
		      String saveDir = "C:\\javaStudy\\upload";
		      
		      //원파일 이름
		      String orgName = file.getOriginalFilename();
		      System.out.println("orgName : " + orgName);
		      
		      //확장자
		      String exName = file.getOriginalFilename().substring(   file.getOriginalFilename().lastIndexOf(".")    );	//kang.jpg (substring은 .기준(원파일 이름)으로 앞부분 날리고 뒷부분(확장자)구해라 
		      System.out.println("exName : " + exName);	//.jpg(확장자 나옴)
		      
		      
		      
		      //저장파일 이름(관리때문에 겹치지 않는 새이름 부여)
		      //이름 절대 안겹쳐야함.
		      //이 조합으로 함 (시간 기준 + 랜덤 아이디 + 확장자)로 조합해서 안겹치게 만든다.(생각해낸 사람 대단하네)
		      String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;	//얘는 tostring 까지 써야함. -> 이름 안겹치게 랜덤으로 만들어줌(근데 재수나쁘면 같은애 나올 수도 있음. 이론적으로는 로또당첨보다 힘들긴함;)
		      System.out.println("saveName : " + saveName);
		      
		      //vo에 파일 경로 담기
		      blogVo.setLogoFile(saveName);
		      
		      System.out.println("경로 담겼나?" + blogVo);
		      //파일패스(경로) -> 파일을 저장할 위치 + 파일명.(파일 위치는 따로 빠질수도 있기 때문에 위에 따로 빼둠)
		      String filePath = saveDir + "\\" + saveName;
		      System.out.println("filePath : " + filePath);
		      
		     
		      
		      /***************파일 업로드********************/
		      //1. 파일을 서버 하드디스크에 저장
		      try {
				byte[] fileData = file.getBytes();
				
				//빨대작업
				OutputStream out = new FileOutputStream(filePath);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				
				bout.write(fileData);
				bout.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		    System.out.println("다오보내기전:"+blogVo.toString());  
		    // System.out.println("다오갔다온거:"+blogVo.toString());  
		    blogDao.upload(blogVo);
	   } else {
		   blogDao.uploadTitle(blogVo);
	   }
	    
	}
	
	
	
	
}
