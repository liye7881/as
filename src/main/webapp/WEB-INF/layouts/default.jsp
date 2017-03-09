<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <script src="${pageContext.request.contextPath}/scripts/jquery/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery/jquery-ui.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/scripts/jquery/jquery-ui.css" />
    <link href="${pageContext.request.contextPath}/scripts/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css" />

    <tiles:insertAttribute name="meta" />
    <tiles:insertAttribute name="startScripts" />
</head>

<body style="padding-top: 70px;">
<tiles:insertAttribute name="menu" />
<div class="container">
    <tiles:insertAttribute name="body" />
</div>

<script
        src="${pageContext.request.contextPath}/scripts/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/scripts/bootstrap/js/bootstrap-contextmenu.js"></script>

<tiles:insertAttribute name="endScripts" />
</body>
</html>
