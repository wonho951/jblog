<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<div id="header" class="clearfix">
			<h1><a href="">정우성의 블로그입니다.</a></h1>
			<ul class="clearfix">
				<!-- 로그인 전 메뉴 -->
				<c:if test = "${empty sessionScope.authUser }">
					<li><a class="btn_s" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
				</c:if>
				
				<!-- 로그인 후 메뉴 -->
				<!-- 자신의 블로그일때만 관리 메뉴가 보인다. -->
				<c:if test = "${not empty sessionScope.authUser }">
					<li><a class="btn_s" href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">내블로그 관리</a></li>
					<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
		<!-- //header -->
		