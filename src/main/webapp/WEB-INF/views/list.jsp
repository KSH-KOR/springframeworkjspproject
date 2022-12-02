<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LeaveMeSomeReviews</title>
<style>
.box-container{
	display: flex;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap;
	width: 100%;
}
.box{
	width: 500px;
	box-shadow: 2px 2px 30px #202020;
	background-color: #dddddd;
	padding: 20px;
	margin: 15px;
	cursor: pointer;
}
.profile-img{
	width: 50px;
	height: 50px;
	border-radius: 50%;
	overflow: hidden;
	margin-right: 10px;
}
.profile-img img{
	width: 100%;
	height: 100%;
	object-fit: cover;
	object-position: center;
}
.profile{
	display: flex;
}
.name-user{
	display: flex;
	flex-direction: column;
}
.title strong{
	color: #252525;
	font-size: 1.1rem;
	letter-spacing: 0.5px;
}
.review{
	color: darkorange;
}
.box-top{
	display:flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
}
.context{
	font-size:0.9rem;
}
.box-bottom{
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-top: 20px;
	margin-bottom: 5px;
}
.buttons{
	display: flex;
}
.buttons a{
	margin: 0px 5px;
}
</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deletepost/'+id;
	}
</script>
</head>
<body>

<section id="review">
	<!--heading-------------->
	<div class="review-heading">
		<span>Comments</span>
		<h1>Clients say</h1>
		<br/><a href="addpost">Add New Post</a>
	</div>


	<c:forEach items="${modelList}" var="u">
		<div class="box-container">
			<div class="box">
				<div class = "box-top">
					<div class="profile">
						<div class="name-user">
							<strong>${u.writer}</strong>
							<span>ID: ${u.id}</span>
						</div>

					</div>
					<div class="title"><strong>${u.title}</strong></div>
					<div class="review">
						<span>rate: ${u.rate}</span>
					</div>
				</div>

				<div class="context">
					<p>${u.content}</p>
				</div>
				<div class="box-bottom">
					<div class="post-date">${u.timestamp}</div>
					<div class="buttons">
						<a href="../post/editpost/${u.id}">Edit</a>
						<a href="javascript:delete_ok('${u.id}')">Delete</a>
					</div>
				</div>
			</div>

		</div>
	</c:forEach>


</section>


</body>
</html>