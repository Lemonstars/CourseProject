<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>Hostel World</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html"><strong><i class="icon fa fa-plane"></i> Hostel World</strong></a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a href="/branch-plan?id=${id}"><i class="fa fa-desktop"></i>发布计划</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-sitemap"></i>信息登记<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/branch-registerIn?id=${id}">入住登记</a>
                        </li>
                        <li>
                            <a href="/branch-registerOut?id=${id}">离店登记</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit"></i> 修改信息</a>
                </li>
                <li>
                    <a href="/branch-count?id=${id}"><i class="fa fa-qrcode"></i> 统计查看</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div class="header">
            <h1 class="page-header">
              申请修改信息  <small> 总店经理审核后生效</small>
            </h1>

        </div>

        <div id="page-inner">

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <div class="card-title">
                                <div class="title">填写新信息</div>
                            </div>
                        </div>

                        <div class="panel-body">
                            <form action="/branch-applyChangeInfor" method="post">
                                <input class="hidden" value="${id}" name="id">
                                <input class="hidden" value="${icard}" name="old_icard">
                                <input class="hidden" value="${city}" name="old_city">
                                <input class="hidden" value="${address}" name="old_address">
                                <input class="hidden" value="${numOfRoom}" name="old_numOfRoom">
                                <div class="form-group col-xs-5">
                                    <label for="icard">银行卡</label>
                                    <input type="text" class="form-control" id="icard" name="icard" value="${icard}">
                                </div>
                                <div class="form-group col-xs-5">
                                    <label for="city">城市</label>
                                    <input type="text" class="form-control" id="city" name="city" value="${city}">
                                </div>
                                <div class="form-group col-xs-5">
                                    <label for="address">地址</label>
                                    <input type="text" class="form-control" id="address" name="address" value="${address}">
                                </div>
                                <div class="form-group col-xs-5">
                                    <label for="numOfRoom">房间数</label>
                                    <input type="text" class="form-control" id="numOfRoom" name="numOfRoom" value="${numOfRoom}">
                                </div>

                                <div class="col-xs-5">
                                    <input type="submit" value="申请审核" class="btn btn-primary btn-lg" >
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div>
                <footer><p>Copyright &copy; 2017.Company Hostel World All rights reserved.</p></footer>
            </div>
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

<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>
