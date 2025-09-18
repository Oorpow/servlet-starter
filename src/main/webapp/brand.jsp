<%--
  Created by IntelliJ IDEA.
  User: oorpow
  Date: 2025/9/18
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.demo.Brand" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//  ArrayList<Brand> brands = new ArrayList<>();
  List<Brand> brandList = new ArrayList<Brand>();
  brandList.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
  brandList.add(new Brand(2,"xiaomi","xiaomi",200,"mimimimimi",30));
  brandList.add(new Brand(3,"apple","apple",100,"appppppp",50));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
    <input type="button" value="add" />
<%--    ${brandList}--%>
    <div>
      <table>
        <tr>
          <th>序号</th>
          <th>品牌名称</th>
          <th>企业名称</th>
          <th>排序</th>
          <th>品牌介绍</th>
          <th>状态</th>
          <th>操作</th>
        </tr>
<%--        通过Servlet将数据转发至jsp文件--%>
        <c:forEach items="${brandList}" var="brandItem">
          <tr>
            <td>${brandItem.id}</td>
            <td>${brandItem.brandName}</td>
            <td>${brandItem.companyName}</td>
            <td>${brandItem.ordered}</td>
            <td>${brandItem.description}</td>
            <td>${brandItem.status == 1 ? 'enabled' : 'disabled'}</td>
            <td><a href="#">修改</a> <a href="#">删除</a></td>
          </tr>
        </c:forEach>
<%--        <%--%>
<%--          for (int i = 0; i < brandList.size(); i++) {--%>
<%--            Brand brand = brandList.get(i);--%>
<%--        %>--%>

<%--        <tr>--%>
<%--          <td><%=brand.getId()%></td>--%>
<%--          <td><%=brand.getBrandName()%></td>--%>
<%--          <td><%=brand.getCompanyName()%></td>--%>
<%--          <td><%=brand.getOrdered()%></td>--%>
<%--          <td><%=brand.getStatus() == 1 ? "enabled" : "disabled"%></td>--%>
<%--          <td><a href="#">修改</a> <a href="#">删除</a></td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--          }--%>
<%--        %>--%>
      </table>
    </div>
  </div>
</body>
</html>
