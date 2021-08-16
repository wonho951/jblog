<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">

		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		<div id="content" class="clearfix">
			<div id="profilecate_area">
				<div id="profile">
					
					<!-- 기본이미지 -->
					<!-- c:if로 해봤는데 안되네; -->
					<c:choose>
						<c:when test="${blogVo.logoFile == null }">
							<img id="proImg" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
						</c:when>
					
						<c:otherwise>
							<img id="proImg" src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}">
						</c:otherwise>
					</c:choose>
					<div id="nick">${blogVo.userName}(${blogVo.id})님</div>
				</div>
				<div id="cate">
					<div class="text-left">
						<strong>카테고리</strong>
					</div>
					<ul id="cateList" class="text-left">
						<c:forEach items ="${listMap.categoryList }" var = "categoryList">
							<li><a href="${pageContext.request.contextPath}/${blogVo.id}?cateNo=${categoryList.cateNo}">${categoryList.cateName }</a></li>
						</c:forEach>
							
					</ul>
				</div>
			</div>
			<!-- profilecate_area -->
			
			<div id="post_area">
				<c:if test="${listMap.postVo != null }">
						<div id="postBox" class="clearfix">
								<div id="postTitle" class="text-left"><strong>${listMap.postVo.postTitle }</strong></div>
								<div id="postDate" class="text-left"><strong>${listMap.postVo.regDate }</strong></div>
								<div id="postNick">${blogVo.userName }(${blogVo.id })님</div>
						</div>
									
						<!-- //postBox -->
						<div id="post" >
							${listMap.postVo.postContent}
						</div>
						<!-- //post -->
				</c:if>	
						<!-- 글이 없는 경우 -->
				<c:if test="${listMap.postVo == null }">
						<div id="postBox" class="clearfix">
									<div id="postTitle" class="text-left"><strong>등록된 글이 없습니다.</strong></div>
									<div id="postDate" class="text-left"><strong></strong></div>
									<div id="postNick"></div>
						</div>
					    
						<div id="post" >
						</div>
				</c:if>	
				
				<div id="list">
					<div id="listTitle" class="text-left"><strong>카테고리의 글</strong></div>
					<table>
						<colgroup>
							<col style="">
							<col style="width: 20%;">
						</colgroup>
						
						
						<c:forEach items = "${listMap.postList }" var = "postList">
							<tr>
								<td class="text-left"><a href="${pageContext.request.contextPath}/${blogVo.id }/?cateNo=${postList.cateNo}&postNo=${postList.postNo}">${postList.postTitle }</a></td>
								<td class="text-right">${postList.regDate}</td>
							</tr>
						</c:forEach>
						
						<!-- <tr>
							<td class="text-left"><a href="">08.페이징</a></td>
							<td class="text-right">2020/07/23</td>
						</tr>
						<tr>
							<td class="text-left"><a href="">07.첨부파일_MultipartResolver</a></td>
							<td class="text-right">2020/07/23</td>
						</tr>
						<tr>
							<td class="text-left"><a href="">06.jquery_ajax</a></td>
							<td class="text-right">2020/07/23</td>
						</tr>
						<tr>
							<td class="text-left"><a href="">05.javaScript</a></td>
							<td class="text-right">2020/07/23</td>
						</tr>
						<tr>
							<td class="text-left"><a href="">04.spring_어플리케이션_아키텍쳐</a></td>
							<td class="text-right">2020/07/23</td>
						</tr> -->
						
						
					</table>
				</div>
				<!-- //list -->
			</div>
			<!-- //post_area -->
			
			
			
		</div>	
		<!-- //content -->
		<div class=></div>
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		
	
	
	</div>
	<!-- //wrap -->
</body>
</html>