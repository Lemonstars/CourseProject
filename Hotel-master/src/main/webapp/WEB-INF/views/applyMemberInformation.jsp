﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <title>BRILLIANT Free Bootstrap Admin Template</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand"><strong><i class="icon fa fa-plane"></i> Hostel World</strong></a>
            </div>
        </nav>
        <%--<!--/. NAV TOP  -->--%>
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="#"><i class="fa fa-edit"></i>你的信息</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div class="header">
                <h1 class="page-header">
                    你的信息  <small>请记住您的申请编号</small>
                </h1>
            </div>

            <div id="page-inner">

                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="card-title">
                                    <div class="title">申请信息</div>
                                </div>
                            </div>
                            <div class="panel-body">

                                <div class="form-group col-xs-4">
                                    <label>你的编号:</label>
                                    <span class="label label-primary">${aid}</span>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="card-title">
                                    <div class="title">个人信息</div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="form-group col-xs-4">
                                    <label>姓名:</label>
                                    <span class="label label-primary"> ${name}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>身份证号:</label>
                                    <span class="label label-primary"> ${icard}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>银行卡号:</label>
                                    <span class="label label-primary"> ${bankNum}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>手机号:</label>
                                    <span class="label label-primary"> ${phone}</span>
                                </div>
                                <td>
                                    <c:choose>
                                        <c:when test="${isMember.equals('yes')}">
                                            <div class="form-group col-xs-4">
                                                <label>会员:</label>
                                                <span class="label label-primary">是</span>
                                            </div>
                                        </c:when>
                                        <c:when test="${isMember.equals('no')}">
                                            <div class="form-group col-xs-4">
                                                <label>会员:</label>
                                                <span class="label label-primary">否</span>
                                            </div>
                                        </c:when>

                                    </c:choose>
                                </td>
                            </div>
                        </div>
                    </div>
                </div>


                <footer><p>Copyright &copy; 2017.Company Hostel World All rights reserved.</p></footer>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

</body>
</html>