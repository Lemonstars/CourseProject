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
    <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
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
                    <a href="/branch-changeInfor?id=${id}"><i class="fa fa-edit"></i>修改信息</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-qrcode"></i>统计查看</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >

        <div class="header">
            <h1 class="page-header">
               看统计  <small>预定入住财务信息</small>
            </h1>

        </div>

        <div id="page-inner">

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            预定信息总览
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>会员编号</th>
                                        <th>分店编号</th>
                                        <th>操作时间</th>
                                        <th>目标时间</th>
                                        <th>房间类型</th>
                                        <th>状态</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${reserveList}" var="reserve">
                                        <tr>
                                            <td>${reserve.associatorByAid.aid}</td>
                                            <td>${reserve.branchByHid.id}</td>
                                            <td>${reserve.operatTime}</td>
                                            <td>${reserve.targetTime}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${reserve.roomType == 1}">
                                                        单人间
                                                    </c:when>
                                                    <c:when test="${reserve.roomType == 2}">
                                                        双人间
                                                    </c:when>
                                                    <c:otherwise>
                                                        三人间
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${reserve.status == 0}">
                                                        未入住
                                                    </c:when>
                                                    <c:when test="${reserve.status == 0}">
                                                        已入住
                                                    </c:when>
                                                    <c:otherwise>
                                                        已取消
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div>
                                <div class="sub-title">预定总数:</div>
                                <div class="inline-block">
                                    <div class="form-group col-xs-4">
                                        <label>单人间:</label>
                                        <span class="label label-primary">${numOfReserve1}间</span>
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label>双人间:</label>
                                        <span class="label label-primary">${numOfReserve2}间</span>
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label>三人间:</label>
                                        <span class="label label-primary">${numOfReserve3}间</span>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            入住信息总览
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-checkIn">
                                    <thead>
                                    <tr>
                                        <th>会员编号</th>
                                        <th>分店编号</th>
                                        <th>入住时间</th>
                                        <th>房间类型</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${checkInList}" var="checkIn">
                                        <tr>
                                            <td>${checkIn.aid}</td>
                                            <td>${checkIn.hid}</td>
                                            <td>${checkIn.time}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${reserve.roomType == 1}">
                                                        单人间
                                                    </c:when>
                                                    <c:when test="${reserve.roomType == 2}">
                                                        双人间
                                                    </c:when>
                                                    <c:otherwise>
                                                        三人间
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div>
                                <div class="sub-title">入住总数:</div>
                                <div class="inline-block">
                                    <div class="form-group col-xs-4">
                                        <label>单人间:</label>
                                        <span class="label label-primary">${numOfReserve1}间</span>
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label>双人间:</label>
                                        <span class="label label-primary">${numOfReserve2}间</span>
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label>三人间:</label>
                                        <span class="label label-primary">${numOfReserve3}间</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            消费信息总览
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-consume">
                                    <thead>
                                    <tr>
                                        <th>会员编号</th>
                                        <th>分店编号</th>
                                        <th>消费时间</th>
                                        <th>房间类型</th>
                                        <th>支付类型</th>
                                        <th>消费金额(元)</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${consumeList}" var="consume">
                                        <tr>
                                            <td>${consume.aid}</td>
                                            <td>${consume.hid}</td>
                                            <td>${consume.time}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${consume.roomType == 1}">
                                                        单人间
                                                    </c:when>
                                                    <c:when test="${consume.roomType == 2}">
                                                        双人间
                                                    </c:when>
                                                    <c:otherwise>
                                                        三人间
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${consume.payType == 0}">
                                                        会员卡
                                                    </c:when>
                                                    <c:when test="${consume.payType == 1}">
                                                        银行卡
                                                    </c:when>
                                                    <c:otherwise>
                                                        现金
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${consume.price}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div>
                                <div class="sub-title">消费总额:</div>
                                <div class="inline-block">
                                    <div class="form-group col-xs-4">
                                        <label>单人间:</label>
                                        <span class="label label-primary">${priceOfConsume1}元</span>
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label>双人间:</label>
                                        <span class="label label-primary">${priceOfConsume2}元</span>
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label>三人间:</label>
                                        <span class="label label-primary">${priceOfConsume3}元</span>
                                    </div>
                                </div>
                            </div>
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
<!-- DATA TABLE SCRIPTS -->
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<script>
    $(document).ready(function () {
        $('#dataTables-checkIn').dataTable();
    });
</script>
<script>
    $(document).ready(function () {
        $('#dataTables-consume').dataTable();
    });
</script>

<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>
