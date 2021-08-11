<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		<!-- 개인블로그 해더 -->


		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn selected"><a href="">기본설정</a></li>
				<li class="tabbtn"><a href="">카테고리</a></li>
				<li class="tabbtn"><a href="">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
				<form action="${pageContext.request.contextPath}/${id}/admin/basic/upload" method="post" enctype="multipart/form-data">
	 		      	<table id="admin-basic">
	 		      		<colgroup>
							<col style="width: 100px;">
							<col style="">
						</colgroup>
			      		<tr>
			      			<td><label for="textTitle">블로그 제목</label></td>
			      			<td><input id="textTitle" type="text" name="blogTitle" value="${blogVo.blogTitle }"></td>
			      		</tr>
			      		<tr>
			      			<td><label>로고이미지</label></td>
			      			
								 <%-- <c:choose>
									<c:when test="${blogVo.logoFile == null }">
										<td class="text-left"><img id="proImg" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg"></td>
									</c:when>
									<c:otherwise>
										<td class="text-left"><img id="proImg" src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}"></td>
									 </c:otherwise>
								</c:choose>  --%>
			      			   
			      			   <c:if test="${blogVo.logoFile == null}">
			      			   		<td class="text-left"><img id="proImg" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg"></td>
			      			   </c:if>
			      			   
			      			   <c:if test="${blogVo.logoFile != null}">
			      			   		<td class="text-left"><img id="proImg" src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}"></td>
			      			   </c:if>
			      			   
			      		</tr>      		
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td><input id="textLogo" type="file" name="file"></td>      			
			      		</tr>           		
			      	</table>
			      	<input type = "text" name = "id" value = "${authUser.id }">
			      	<div id="btnArea">
			      		<button class="btn_l" type="submit" >기본설정변경</button>
			      	</div>
				</form>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
/*
//기본설정 변경버튼 클릭시 이미지 블로그 제목 바꾸기
$("#btnArea").on("click", "button", function(){
	event.preventDefault();
	console.log("기본설정 변경 버튼 클릭")
	
	
});*/

</script>


</html>
