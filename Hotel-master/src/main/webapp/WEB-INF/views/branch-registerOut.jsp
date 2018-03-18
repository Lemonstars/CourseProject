<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta content="" name="description" />
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
                            <a href="#">离店登记</a>
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
               来登记  <small>离店信息登记</small>
            </h1>

        </div>

        <div id="page-inner">

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            修改信息申请
                        </div>


                        <div class="panel-body">
                            <form action="/branch_registerOutInfor" >
                                <input class="hidden" value="${id}" name="id">

                                <div class="col-xs-6">
                                    <div class="sub-title">
                                        支付方式：
                                    </div>
                                    <div class="radio3 radio-check radio-inline">
                                        <input type="radio" id="pay1" name="pay_type" value="0" checked="">
                                        <label for="pay1">
                                            会员卡支付
                                        </label>
                                    </div>
                                    <div class="radio3 radio-check radio-success radio-inline">
                                        <input type="radio" id="pay2" name="pay_type" value="1">
                                        <label for="pay2">
                                            银行卡支付
                                        </label>
                                    </div>
                                    <div class="radio3 radio-check radio-success radio-inline">
                                        <input type="radio" id="pay3" name="pay_type" value="2">
                                        <label for="pay3">
                                            现金支付
                                        </label>
                                    </div>
                                </div>

                                <div class="col-xs-6">
                                    <div class="sub-title">
                                        类型：
                                    </div>
                                    <div class="radio3 radio-check radio-inline">
                                        <input type="radio" id="radio4" name="room_type" value="1" checked="">
                                        <label for="radio4">
                                            单人间
                                        </label>
                                    </div>
                                    <div class="radio3 radio-check radio-success radio-inline">
                                        <input type="radio" id="radio5" name="room_type" value="2">
                                        <label for="radio5">
                                            双人间
                                        </label>
                                    </div>
                                    <div class="radio3 radio-check radio-warning radio-inline">
                                        <input type="radio" id="radio6" name="room_type" value="3">
                                        <label for="radio6">
                                            三人间
                                        </label>
                                    </div>
                                </div>

                                <div class="col-xs-6">
                                    <div class="sub-title">
                                        消费金额:
                                    </div>
                                    <div>
                                        <input type="text" id="price" name="price">
                                        元
                                    </div>
                                </div>

                                <div class="col-xs-6">
                                    <div class="sub-title">
                                        会员编号:
                                    </div>
                                    <div>
                                        <input type="text" id="aid" name="aid">
                                    </div>
                                </div>


                                <div class="col-xs-6">
                                    <div class="sub-title">入住分店：</div>
                                    <div>
                                        <select class="selectbox" name="hid">
                                            <c:forEach var="city" items="${addressMap}">

                                                <optgroup label="${city.key}">
                                                    <c:forEach items="${city.value}" var="branch">
                                                        <option value="${branch.id}">${branch.name}-${branch.id}</option>
                                                    </c:forEach>
                                                </optgroup>

                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-7">
                                    <p>
                                        <input type="submit" value="登记" class="btn btn-primary btn-lg" >
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


</body>
</html>
