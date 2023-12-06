<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<form method="get" action="/demo_war_exploded/addUser">
  <label for="username">用户名</label>
  <input type="text" name="username" id="username" required>
  <label for="password">密码</label>
  <input type="password" name="password" id="password" required>
  <label for="phone">手机号</label>
  <input type="text" name="phone" id="phone" required>
  <button type="submit">提交</button>
</form>
</body>
</html>