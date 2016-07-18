<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Pig Latin Translator</title>
</head>
<body>
	<h1>Pig Latin Translator</h1>
	<form action="PigLatin" method="POST">
		Word/Phrase to translate:<input type="text" name="phrase" /> <input
			type="submit" value="Translate" id="translation"/>
	</form>
<c:if test="${! empty(sessionScope.translations)}">
	<p>Word/Phrase Translated: ${wordTranslated}</p>
</c:if>
</body>
</html>