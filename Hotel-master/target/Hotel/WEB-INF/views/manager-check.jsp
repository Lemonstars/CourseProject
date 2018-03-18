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
                    <a href="#"><i class="fa fa-desktop"></i>审核信息</a>
                </li>

                <li>
                    <a href="#"><i class="fa fa-sitemap"></i>统计信息<span class="fa arrow"></span></a>
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
                    <a href="/manager-balance"><i class="fa fa-qrcode"></i>支付结算</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div class="header">
            <h1 class="page-header">
               来审核  <small>审核分店申请</small>
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

                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>分店编号</th>
                                        <th>申请日期</th>
                                        <th>原身份证</th>
                                        <th>新身份证</th>
                                        <th>原城市</th>
                                        <th>新城市</th>
                                        <th>原地址</th>
                                        <th>新地址</th>
                                        <th>原房间数</th>
                                        <th>新房间数</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${changeInforList}" var="changeInfor">
                                        <tr>
                                            <td>${changeInfor.branchId}</td>
                                            <td>${changeInfor.date}</td>
                                            <td>${changeInfor.oldIcard}</td>
                                            <td>${changeInfor.newIcard}</td>
                                            <td>${changeInfor.oldCity}</td>
                                            <td>${changeInfor.newCity}</td>
                                            <td>${changeInfor.oldAddress}</td>
                                            <td>${changeInfor.newAddress}</td>
                                            <td>${changeInfor.oldNumOfRoom}</td>
                                            <td>${changeInfor.newNumOfRoom}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${changeInfor.status == 0}">
                                                        未处理
                                                    </c:when>
                                                    <c:when test="${changeInfor.status == 1}">
                                                        同意
                                                    </c:when>
                                                    <c:otherwise>
                                                        拒绝
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${changeInfor.status == 0}">
                                                        <a href="/accpetChangeInfor?changeID=${changeInfor.changeId}" type="button" class="btn btn-sm btn-info">同意</a>
                                                        <a href="/refuseChangeInfor?changeID=${changeInfor.changeId}" type="button" class="btn btn-sm btn-danger">拒绝</a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="/deleteChangeInfor?changeID=${changeInfor.changeId}" type="button" class="btn btn-sm btn-warning">删除</a>
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
                            开设新店申请
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables">
                                    <thead>
                                    <tr>
                                        <th>申请人姓名</th>
                                        <th>申请人身份证号</th>
                                        <th>关联银行卡号</th>
                                        <th>分店城市</th>
                                        <th>分店地址</th>
                                        <th>分店房间数</th>
                                        <th>申请日期</th>
                                        <th>申请状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${applyList}" var="apply">
                                        <tr>
                                            <td>${apply.applyerName}</td>
                                            <th>${apply.icard}</th>
                                            <td>${apply.bankNumber}</td>
                                            <td>${apply.address}  </td>
                                            <td>${apply.name}  </td>
                                            <td>${apply.numOfRoom}  </td>
                                            <td>${apply.applyTime}  </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${apply.status == 0}">
                                                       未处理
                                                    </c:when>
                                                    <c:when test="${apply.status == 1}">
                                                        同意
                                                    </c:when>
                                                    <c:otherwise>
                                                        拒绝
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                            <c:choose>
                                                <c:when test="${apply.status == 0}">
                                                    <a href="/accpetApply?applyID=${apply.id}" type="button" class="btn btn-sm btn-info">同意</a>
                                                    <a href="/refuseApply?applyID=${apply.id}" type="button" class="btn btn-sm btn-danger">拒绝</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="/deleteApply?applyID=${apply.id}" type="button" class="btn btn-sm btn-warning">删除</a>
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
        $('#dataTables').dataTable();
    });
</script>

<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>
