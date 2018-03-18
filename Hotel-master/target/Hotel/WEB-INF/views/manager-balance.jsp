<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>Bootstrap HTML5 Admin Template</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand"><strong><i class="icon fa fa-plane"></i> Hostel World</strong></a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a href="/manager-check"><i class="fa fa-desktop"></i>审核信息</a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> 统计信息<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/manager-checkIn">分店入住</a>
                            </li>
                            <li>
                                <a href="/manager-member">会员消费</a>
                            </li>
                            <li>
                                <a href="/manager-finance">总店财务</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-qrcode"></i>支付结算</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
		    <div class="header">
                <h1 class="page-header">
                    去结算 <small>支付分店会员卡费用</small>
                </h1>
		    </div>

            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                预定费用结算
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                        <tr>
                                            <th>预定日期</th>
                                            <th>会员编号</th>
                                            <th>酒店编号</th>
                                            <th>预定价格</th>
                                            <th>结算状态</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${reserveList}" var="reserve">
                                            <tr>
                                                <td>${reserve.date}</td>
                                                <th>${reserve.aid}</th>
                                                <th>${reserve.hid}</th>
                                                <td>${reserve.price}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${reserve.status == 0}">
                                                            未结算
                                                        </c:when>
                                                        <c:when test="${reserve.status == 1}">
                                                            已结算
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${reserve.status == 0}">
                                                            <a href="/finalizeBalance?id=${reserve.id}" type="button" class="btn btn-sm btn-info">结算</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="/deleteBalance?id=${reserve.id}" type="button" class="btn btn-sm btn-warning">删除</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <a href="/finalizeAllReserve" type="button" class="btn btn-sm btn-info">全部结算</a>

                                <a href="/deleteAllReserve" type="button" class="btn btn-sm btn-warning">已结算全删除</a>
                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                消费费用结算
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables">
                                        <thead>
                                        <tr>
                                            <th>消费日期</th>
                                            <th>会员编号</th>
                                            <th>酒店编号</th>
                                            <th>消费价格</th>
                                            <th>结算状态</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${consumeList}" var="consume">
                                            <tr>
                                                <td>${consume.date}</td>
                                                <td>${consume.aid}</td>
                                                <td>${consume.hid}</td>
                                                <td>${consume.price}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${consume.status == 0}">
                                                            未结算
                                                        </c:when>
                                                        <c:when test="${consume.status == 1}">
                                                            已结算
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${consume.status == 0}">
                                                            <a href="/finalizeBalance?id=${consume.id}" type="button" class="btn btn-sm btn-info">结算</a>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <a href="/deleteBalance?id=${consume.id}" type="button" class="btn btn-sm btn-warning">删除</a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <a href="/finalizeAllConsume" type="button" class="btn btn-sm btn-info">全部结算</a>
                                <a href="/deleteAllConsume" type="button" class="btn btn-sm btn-warning">已结算全删除</a>
                            </div>
                        </div>
                        <!--End Advanced Tables -->
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
            $('#dataTables').dataTable();
        });
    </script>
    
   
</body>
</html>
