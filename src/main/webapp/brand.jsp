<%--
  Created by IntelliJ IDEA.
  User: oorpow
  Date: 2025/9/18
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
    <input type="button" value="add" />
    <div>
      dispatch过来的数据 ${brandList}
    </div>
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
            <c:if test="${brandItem.status == 1}">
              <td>enabled</td>
            </c:if>
            <c:if test="${brandItem.status != 1}">
              <td>disabled</td>
            </c:if>
            <td><a href="/demo02/brand?id=${brandItem.id}">修改</a> <a href="#">删除</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>
</html>
