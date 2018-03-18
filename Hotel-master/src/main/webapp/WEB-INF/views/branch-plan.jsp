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
                    <a href="#"><i class="fa fa-desktop"></i>发布计划</a>
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
                    <a href="/branch-changeInfor?id=${id}"><i class="fa fa-edit"></i>修改信息</a>
                </li>
                <li>
                    <a href="/branch-count?id=${id}"><i class="fa fa-qrcode"></i>统计查看</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div class="header">
            <h1 class="page-header">
               制定计划  <small>发布房间价格</small>
            </h1>

        </div>

        <div id="page-inner">

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="card-title">
                                <div class="title">房间价格</div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="form-group col-xs-5">
                                <label>类型:</label>
                                <span class="label label-info">一人间</span>
                            </div>
                            <div class="form-group col-xs-5">
                                <label>价格:</label>
                                <span class="label label-info">${firstPrice}元</span>
                            </div>

                            <div class="form-group col-xs-5">
                                <label>类型:</label>
                                <span class="label label-info">两人间</span>
                            </div>
                            <div class="form-group col-xs-5">
                                <label>价格:</label>
                                <span class="label label-info">${scondPrice}元</span>
                            </div>

                            <div class="form-group col-xs-5">
                                <label>类型:</label>
                                <span class="label label-info">三人间</span>
                            </div>
                            <div class="form-group col-xs-5">
                                <label>价格:</label>
                                <span class="label label-info">${thirdPrice}元</span>
                            </div>

                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            制定房间价格
                        </div>
                        <div class="panel-body">

                            <form class="form-inline" action="/branch-changePlan">
                                <input class="hidden" value="${id}" name="id"/>
                                <div class="form-group col-xs-4">
                                    <div>
                                        <label>类型:</label>
                                        <span class="label label-info">一人间</span>
                                    </div>
                                    <div>
                                        <label for="exampleInputName1">价格:</label>
                                        <input type="text" class="form-control" id="exampleInputName1" name="price1">
                                        <span class="label label-info">元</span>
                                    </div>
                                    <div>
                                        <label>期限:</label>
                                        <select class="selectbox">
                                            <option value="10">未来10天</option>
                                            <option value="20">未来20天</option>
                                            <option value="30">未来30天</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group col-xs-4">
                                    <div>
                                        <label>类型:</label>
                                        <span class="label label-info">一人间</span>
                                    </div>
                                    <div>
                                        <label for="exampleInputName2">价格:</label>
                                        <input type="text" class="form-control" id="exampleInputName2" name="price2">
                                        <span class="label label-info">元</span>
                                    </div>
                                    <div>
                                        <label>期限:</label>
                                        <select class="selectbox">
                                            <option value="10">未来10天</option>
                                            <option value="20">未来20天</option>
                                            <option value="30">未来30天</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group col-xs-4">
                                    <div>
                                        <label>类型:</label>
                                        <span class="label label-info">一人间</span>
                                    </div>
                                    <div>
                                        <label for="exampleInputName3">价格:</label>
                                        <input type="text" class="form-control" id="exampleInputName3" name="price3">
                                        <span class="label label-info">元</span>
                                    </div>
                                    <div>
                                        <label>期限:</label>
                                        <select class="selectbox">
                                            <option value="10">未来10天</option>
                                            <option value="20">未来20天</option>
                                            <option value="30">未来30天</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-2">
                                    <p>
                                         <input type="submit" value="全部发布" class="btn btn-sm btn-primary"/>
                                    </p>
                                </div>

                            </form>

                        </div>

                    </div>
                    <!--End Advanced Tables -->
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
