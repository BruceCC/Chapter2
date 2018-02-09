<!DOCTYPE html>
<%@ include file="common/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>客户管理</title>
    <!-- jQuery -->
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${ctx}/static/bootstrap-3.3.7-dist/js/sb-admin-2.min.js"></script>
</head>

<body>

<div id="wrapper">

    <jsp:include page="common/nav.jsp" flush="true" />

    <div id="page-wrapper">
        <div class="row">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
                    <h1 class="page-header">客户管理</h1>
                </div>
            </div>
        </div>
        <!-- /.row -->
        <form id="" class="" action=""
              method="post">

        <div class="table-responsive">
            <table class="table table-striped  table-hover">
                <thead>
                <tr>
                    <th>name</th>
                    <th>contact</th>
                    <th>telephone</th>
                    <th>email</th>
                    <th>remark</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customerList }" var="customer">
                    <tr>
                        <td>${customer.name }</td>
                        <td>${customer.contact }</td>
                        <td>${customer.telephone }</td>
                        <td>${customer.email }</td>
                        <td>${customer.remark }</td>
                        <td>
                            <button type="button" class="btn btn-primary"
                                    onclick=""><i class="fa fa-pencil"></i>&nbsp修改</button>
                            <button type="button" class="btn btn-danger"
                                    data-toggle="modal" data-target="#common_confirm_model"
                                    ></i>&nbsp删除</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </form>
        <!-- /#table-responsive -->
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
</div>



</body>

</html>
