<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>Bootstrap Admin html Template</title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- Morris Chart Styles-->
   
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
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="／logout"><i class="fa fa-sign-out fa-fw"></i>登出</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="/associator-reverse?id=${id}"><i class="fa fa-check-square-o"></i>客房预定</a>
                    </li>
                    <li>
                        <a href="/associator-unsubscribe?id=${id}"><i class="fa fa-home"></i>我的订单</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-table"></i>信息统计</a>
                    </li>
                    <li>
                        <a href="/associator-modify?id=${id}"><i class="fa fa-edit"></i>我的信息</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		   <div class="header">
                <h1 class="page-header">
                   看数据   <small> 统计您的酒店记录 </small>
                </h1>
		   </div>
		
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="board">
                            <div class="panel panel-primary">
                                <div class="number">
                                    <h3>
                                        <h3>${numOfReserve}</h3>
                                        <small>预定次数</small>
                                    </h3>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-home fa-5x red"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="board">
                            <div class="panel panel-primary">
                                <div class="number">
                                    <h3>
                                        <h3>${consumeSum}</h3>
                                        <small>消费金额(元)</small>
                                    </h3>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-shopping-cart fa-5x blue"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="board">
                            <div class="panel panel-primary">
                                <div class="number">
                                    <h3>
                                        <h3>${maxDate}</h3>
                                        <small>最近入住</small>
                                    </h3>
                                </div>
                                <div class="icon">
                                    <i class="fa fa-check fa-5x green"></i>
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
                             消费记录
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover"  >
                                    <thead>
                                        <tr>
                                            <th>消费编号</th>
                                            <th>会员编号</th>
                                            <th>分店编号</th>
                                            <th>房间类型</th>
                                            <th>消费金额(元)</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${consumeList}" var="consume">
                                        <tr>
                                            <td>${consume.id}</td>
                                            <td>${consume.aid}</td>
                                            <td>${consume.hid}</td>
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
                                            <td>${consume.price}  </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
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
                                入住记录
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>入住编号</th>
                                            <th>会员编号</th>
                                            <th>分店编号</th>
                                            <th>入住日期</th>
                                            <th>房间类型</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach items="${checkInList}" var="checkIn">
                                            <tr>
                                                <td>${checkIn.id}</td>
                                                <td>${checkIn.aid}</td>
                                                <td>${checkIn.hid}</td>
                                                <td>${checkIn.time}  </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${checkIn.roomType == 1}">
                                                            单人间
                                                        </c:when>
                                                        <c:when test="${checkIn.roomType == 2}">
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
                                预定记录
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>入住编号</th>
                                            <th>会员编号</th>
                                            <th>分店编号</th>
                                            <th>操作日期</th>
                                            <th>预定日期</th>
                                            <th>房间类型</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach items="${reserveList}" var="reserve">
                                            <tr>
                                                <td>${reserve.id}</td>
                                                <td>${reserve.associatorByAid.aid}</td>
                                                <td>${reserve.branchByHid.id}</td>
                                                <td>${reserve.operatTime}  </td>
                                                <td>${reserve.targetTime}  </td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${checkIn.roomType == 1}">
                                                            单人间
                                                        </c:when>
                                                        <c:when test="${checkIn.roomType == 2}">
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

                            </div>
                        </div>
                        <!--End Advanced Tables -->
                    </div>
                </div>

        </div>
            <footer><p>Copyright &copy; 2017.Company Hostel World All rights reserved.</p></footer>
        </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
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
         <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

</body>
</html>