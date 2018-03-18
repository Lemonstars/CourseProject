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
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
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

        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="/associator-reverse?id=${id}"><i class="fa fa-check-square-o"></i>客房预定</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-home"></i>我的订单</a>
                    </li>
                    <li>
                        <a href="/associator-information?id=${id}"><i class="fa fa-table"></i>信息统计</a>
                    </li>
                    <li>
                        <a href="/associator-modify?id=${id}"><i class="fa fa-edit"></i>我的信息</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div id="page-wrapper" >
            <div class="header">
                <h1 class="page-header">
                    去退订 <small>欢迎下次预定</small>
                </h1>
            </div>
		
            <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    我的预定
                                </div>
                                <div class="panel-body">

                                    <div class="col-lg-12">
                                        <div class="sub-title">
                                            房间价格：
                                        </div>
                                        <table class="table table-bordered table-striped">
                                            <tr>
                                                <th>预定编号 </th>
                                                <th>操作时间</th>
                                                <th>分店位置</th>
                                                <th>目标时间</th>
                                                <th>房间类型</th>
                                                <th>订单状态</th>
                                                <th>操作</th>
                                            </tr>
                                            <c:forEach items="${reserveList}" var="reserve">
                                                <form action="/deleteReserve" method="post">
                                                <tr>
                                                    <td>${reserve.id}</td>
                                                    <td>${reserve.operatTime}</td>
                                                    <td>${reserve.branchByHid.name}</td>
                                                    <td>${reserve.targetTime}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${reserve.roomType == 1}">
                                                                单人间
                                                            </c:when>
                                                            <c:when test="${salary == 2}">
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
                                                                进行中
                                                            </c:when>
                                                            <c:when test="${reserve.status == 1}">
                                                                 兑现
                                                            </c:when>
                                                            <c:when test="${salary == 2}">
                                                                 取消
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                    <input class="hidden" value="${id}" name="userId">
                                                    <input class="hidden" value="${reserve.id}" name="orderId">
                                                    <td>
                                                        <input type="submit" value="删除" class="btn btn-sm btn-danger" >
                                                    </td>
                                                </tr>
                                                </form>
                                            </c:forEach>
                                        </table>
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
        </div>
    </div>

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
