<%@page import="aiwa.entity.Kanji"%>
<%@page import="aiwa.entity.Category"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<Kanji> kanjis = (ArrayList<Kanji>) request.getAttribute("kanjis");
	String word = (String) request.getAttribute("word");
	int categoryid = (int) request.getAttribute("categoryid");
	ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
%>

<style>
	.card-img-top {
		height:500px;
		object-fit:cover;
		
	}
	.card-body{
	background-color:#d1f0ec;
	}
	.image{
	padding: 50px 50px 50px 50px;
	}
	
	body{
	background-color:#ede31c;
	}
	
	
	
	
</style>
</head>
<body>
<div class="container">
	<h1 class="display-1 text-center "> Dictionary <i class="bi bi-journal-bookmark"></i></h1>

	<form action="KanjiListController">
		<div class="mb-3">
			<select class="form-select" name="categoryid">
				<option value="0" <%= categoryid == 0 ? "selected" : "" %>>すべて</option>

				<% for(Category c : categories) { %>
				<option value="<%= c.getCategoryid() %>" <%= categoryid == c.getCategoryid() ? "selected" : "" %>>
					<%= c.getCategoryname() %>
				</option>
				<% } %>
			</select>
		</div>
		<div class="mb-3">
			<input class="form-control" type="text" name="keyword" placeholder="キーワード" value="<%= word %>">
		</div>
		<div class="mb-3 d-grid">
			<button class="btn btn-primary" type="submit">検索 <i class="bi bi-search"></i></button>
		</div>
	</form>

	<div class="row">
		<% for(Kanji kanji : kanjis) { %>
			<div class="col-md-3 col-sm-6 mb-3">

				<div class="card">
					<img class="image"  src="<%= kanji.getImage() %>" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title text-truncate"><%= kanji.getMeaning() %></h5>
						<p class="card-text"><%= kanji.getCategory().getCategoryname() %></p>
						<a href="KanjiDetailController?kanjiid=<%= kanji.getKanjiid() %>" class="btn btn-dark">詳しく見る <i class="bi bi-eye"></i></a>
					</div>
				</div>

			</div>
		<% } %>
	</div>
</div>
</body>
</html>