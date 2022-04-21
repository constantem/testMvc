<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadFile</title>
</head>
<body>
<form action="uploadfile.controller" method="post" enctype="multipart/form-data">
   Please Select a Picture To Upload:<br/>
   <input type="file" name="myFiles"/>
   <button type="submit" value="upload">Upload</button>
</form>
</body>
</html>