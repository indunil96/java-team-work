<%@page import="aiwa.entity.Kanji"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<%
	Kanji kanji = (Kanji) request.getAttribute("kanji");
%>
<style>
	.image{
	width:200px;
	margin-left:100px;
	}
	body{
	background-image:url("https://www.shutterstock.com/image-vector/vector-illustration-blank-open-book-600nw-1011514243.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	}
</style>
</head>
<body >
<div class="container col-6 mb-5">

	<button class="btn btn-primary mb-3 mt-3" onclick="history.back()"><i class="bi bi-backspace"></i> 戻る</button>
	<table class="table" style="margin-top:60px">
		<tr>
			<th class="col-2">ID</th><td><%= kanji.getKanjiid() %></td>
		</tr>
		<tr>
			<th>Kanji</th><td><%= kanji.getKanjiname() %></td>
		</tr>
		<tr>
			<th>Meaning</th><td><%= kanji.getMeaning() %></td>
		</tr>
		<tr>
			<th>Onyomi</th><td><%= kanji.getOnyomi() %></td>
		</tr>
		<tr>
			<th>Kunyomi</th><td><%= kanji.getKunyomi() %></td>
		</tr>
		<tr>
			<th>StrokeCount</th><td><%= kanji.getStrokecount() %></td>
		</tr>
		<tr>
			<th>Level</th><td><%= kanji.getCategory().getCategoryname() %></td>
		</tr>
		<tr>
			<th>Example</th><td><%= kanji.getExample() %></td>
		</tr>
		<tr>
			<th>画像</th><td><img class="image" src="<%= kanji.getImage() %>" class="img-fluid"></td>
		</tr>
	</table>
</div>
</body>
</html>