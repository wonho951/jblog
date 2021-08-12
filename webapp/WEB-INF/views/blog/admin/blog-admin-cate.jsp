<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<script type="text/javascript" src = "${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>

</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
		      			<%-- <tr>
							<td>1</td>
							<td>자바프로그래밍</td>
							<td>7</td>
							<td>자바기초와 객체지향</td>
						    <td class='text-center'>
						    	<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">
						    </td>
						</tr>
						<tr>
							<td>2</td>
							<td>오라클</td>
							<td>5</td>
							<td>오라클 설치와 sql문</td>
						    <td class='text-center'>
						    	<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">
						    </td>
						</tr> --%>
						<!-- 리스트 영역 -->
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">

//화면이 로딩되기 직전 -> DOM생성
$(document).ready(function(){
	console.log("화면 로딩 직전");
	

	
	fetchList();
	//나중에 코드 볼때 한눈에 알아 볼 수 있게끔 하기
});



//카테고리 추가 버튼 클릭
$("#btnAddCate").on("click", function(){
	event.preventDefault();
	console.log("카테고리 추가")
	
	//id값 가져오기
	var id = "${blogVo.id}";
	console.log(id);
	
	//카테고리명 읽어오기
	var cateName = $("[name='name']").val();
	console.log(cateName);
	
	//설명 값 읽어오기
	var description = $("[name='desc']").val();
	console.log(description);
	
	//데이터 조합
	var categoryVo = {
		id : id	,
		cateName : cateName,
		description : description
	};
	
	console.log(categoryVo);
	//데이터 ajax방식으로 서버에 전송
	$.ajax({
		url : "${pageContext.request.contextPath }/admin/category/add",
		type : "post",
		//contentType : "application/json",	//json방식으로 보내겠다!
		data : categoryVo,
		
		dataType : "json",
		success : function(cateVo){
			/*성공시 처리해야될 코드 작성*/
			console.log(cateVo);
			render(cateVo, "up");
			
			//입력폼 초기화
			$("[name='name']").val("");	//()안에 ""있으면 값 비워줌
			$("[name='desc']").val("");
			
		},
		error : function(XHR, status, error) {
			console.log('실패');
			console.error(status + " : " + error);
		}
	});
});


//리스트 가져오기
function fetchList(){
 	var id = "${blogVo.id}";
 	console.log(id);
	
	//ajax 요청하기
	$.ajax({
		
		url : "${pageContext.request.contextPath }/${id}/admin/category/list",
		type : "post",
		//contentType : "application/json",
		//data : {name: ”홍길동"},

		dataType : "json",					
		success : function(categoryList){
			/*성공시 처리해야될 코드 작성*/
			console.log(categoryList);
			
			//화면에 그리기
	         for(var i = 0; i < categoryList.length; i++) {
	             render(categoryList[i], "down");
	          }
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
};



//카테고리 리스트 그리기
function render(categoryVo, type){
	var str = '';
	
	str +='<tr>';
	str +='		<td>' + categoryVo.cateNo + '</td>';
	str +='		<td>' + categoryVo.cateName + '</td>';
	str +='		<td>' + categoryVo.postCount + '</td>';
	str +='		<td>' + categoryVo.description + '</td>';
	str +='		<td class="text-center">';
	str +='			<img data-cateno="' + categoryVo.cateNo + '" data-postcount="' + categoryVo.postCount +  '" class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">';
	str +='		</td>';
	str +='	</tr>';
	
	if(type === 'down'){
    	$("#cateList").append(str);            	
    } else if(type === 'up'){
    	$("#cateList").prepend(str);
    } else {
    	console.log("방향을 지정해 주세요");
    }
};

//삭제하기
$("#cateList").on("click", "img", function(){
	console.log("삭제하기")
	
	var cateNo = $(this).data("cateno");
	var postCount = $(this).data("postcount");
	console.log(cateNo);
	console.log(postCount);
	
	//포스트가 있는경우 삭제 할 수 없다.
	if (postCount > 0){
		alert("포스트가 존재하며 삭제할 수 없습니다.")
	} else {
		//서버에 삭제요청(cateNo, postCount 전달)
		$.ajax({
			
			url : "${pageContext.request.contextPath }/admin/category/remove",		
			type : "post",
			//contentType : "application/json",
			data : {cateNo : cateNo},

			dataType : "json",
			success : function(count){
				/*성공시 처리해야될 코드 작성*/
				console.log("성공");
									
				/* 리스트에 삭제버튼이 있던 테이블 화면에서 지운다. -> 삭제 누르면 삭제 누른 항목 브라우저에서 지워져야한다. -> DB에서는 지워짐 */
				$("#t-" + cateNo).remove();
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
});

</script>


</html>