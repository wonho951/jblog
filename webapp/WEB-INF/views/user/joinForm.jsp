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
	<div id="center-content">
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- 메인 해더 -->
	

		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id" value = ""></td>
		      			<td><button id="btnIdCheck" type="button">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2"></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value=""></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value=""></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
	      		
			</form>
			
		</div>
		
		<%-- <c:import url = "/WEB-INF/views/includes/main-footer.jsp"></c:import> --%>
		<!-- 메인 푸터  자리-->
		
	</div>

</body>

<script type="text/javascript">

//아이디 중복체크
//아이디 체크버튼 클릭할때
$("#btnIdCheck").on("click", function(){
	console.log("중복체크")
	
	var id = $("#txtId").val();
	console.log(id);
	
	$.ajax({
		
		url : "${pageContext.request.contextPath }/user/idcheck",		
		type : "post",
		//contentType : "application/json",
		data : {id :id},
		
		dataType : "json",
		success : function(state){
			/*성공시 처리해야될 코드 작성*/
			console.log(state);
			
			if(state == true){
				$("#tdMsg").html("사용가능한 아이디 입니다.")
			}else if(state == false){
				$("#tdMsg").html("사용중인 아이디 입니다. 다른 아이디를 사용해 주세요")
			} else {
				$("#tdMsg").html("관리자에게 문의해주세요.")
			}
			
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	}); 
	
});


//미입력 여부
$("#joinForm").on("submit", function() {
    console.log("회원가입 누를때");
    
    //아이디 미입력 체크
    var id = $("#txtId").val();
    if(id.length < 1){
    	alert("아이디를 입력해 주세요.")
    	return false;
    }
    
    //아이디 중복체크 여부
    var check = $("#btnIdCheck")
    
    //패스워드 5글자 이상 체크
    var password = $("#txtPassword").val();
    if(password.length < 5) {
       alert("패스워드를 5글자 이상 입력해 주세요");
       return false;
    }
   
    //이름 체크
    var name = $("#txtUserName").val();
    if(name.length < 1){
 	   alert("이름을 입력해 주세요");
 	      return false;
    }
   
   
    //약관동의 체크
    var agree = $("chkAgree").is(":checked");
    console.log(agree);
	if(agree == false){
		alert("약관에 동의해 주세요.");
		return false;
	}
   
    return true;
});




</script>


</html>