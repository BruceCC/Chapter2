<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	var contextPath = '${ctx}';
</script>
<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

<%-- <link href="${ctx}/static/bootstrap-3.3.7-dist/css/dataTables.bootstrap.css" rel="stylesheet">

<link href="${ctx}/static/bootstrap-3.3.7-dist/css/dataTables.responsive.css" rel="stylesheet"> --%>

<link href="${ctx}/static/bootstrap-3.3.7-dist/css/sb-admin-2.min.css" rel="stylesheet">

<link href="${ctx}/static/bootstrap-3.3.7-dist/fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries
    //WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--  [if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif] -->