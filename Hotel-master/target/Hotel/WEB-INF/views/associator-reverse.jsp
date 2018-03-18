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
    <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" media="screen">
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
                        <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i>登出</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="#"><i class="fa fa-check-square-o"></i>客房预定</a>
                    </li>
                    <li>
                        <a href="/associator-unsubscribe?id=${id}"><i class="fa fa-home"></i>我的订单</a>
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
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div class="header">
                <h1 class="page-header">
                  来预定    <small>给你最舒适的客房</small>
                </h1>
            </div>

            <div id="page-inner">

                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="card-title">
                                    <div class="title">请填写详细信息</div>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form action="/reverse" method="post">
                                    <div class="col-xs-6">
                                        <div class="sub-title">
                                            支付方式：
                                        </div>
                                        <div class="radio3 radio-check radio-inline">
                                            <input type="radio" id="pay1" name="reverse_pay" value="option1" checked="">
                                            <label for="pay1">
                                                会员卡支付
                                            </label>
                                        </div>
                                        <div class="radio3 radio-check radio-success radio-inline">
                                            <input type="radio" id="pay2" name="reverse_pay" value="option2">
                                            <label for="pay2">
                                                银行卡支付
                                            </label>
                                        </div>
                                    </div>

                                    <div class="col-xs-6">
                                        <div class="sub-title">
                                            类型：
                                        </div>
                                        <div class="radio3 radio-check radio-inline">
                                            <input type="radio" id="radio4" name="reverse_type" value="1" checked="">
                                            <label for="radio4">
                                                单人间
                                            </label>
                                        </div>
                                        <div class="radio3 radio-check radio-success radio-inline">
                                            <input type="radio" id="radio5" name="reverse_type" value="2">
                                            <label for="radio5">
                                                双人间
                                            </label>
                                        </div>
                                        <div class="radio3 radio-check radio-warning radio-inline">
                                            <input type="radio" id="radio6" name="reverse_type" value="3">
                                            <label for="radio6">
                                                三人间
                                            </label>
                                        </div>
                                    </div>

                                    <div class="col-xs-6">
                                        <div class="sub-title">分店：</div>
                                        <div>
                                            <select class="selectbox" name="reverse_address">
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



                                    <div class="col-xs-4">
                                        <div class="sub-title">
                                            预定日期：
                                        </div>
                                        <div class="input-group date form_date " data-date-format="yyyy MM dd">
                                            <input class="form-control" size="16" type="text" name="reverse_date" value="2018 一月 01" readonly>
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-remove"></i></span>
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                        </div>
                                    </div>

                                    <div class="col-xs-3">
                                        <p>
                                            <input type="submit" value="确认支付" class="btn btn-primary btn-lg" >
                                        </p>
                                    </div>
                                    <input class="hidden" value="${id}" name="id"/>
                                </form>
                            </div>
                    </div>
                </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <!-- Advanced Tables -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               房间价格
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                        <tr>
                                            <th>分店编号</th>
                                            <th>分店地址</th>
                                            <th>房间类型</th>
                                            <th>房间价格(元)</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${roomList}" var="room">
                                            <tr>
                                                <td>${room.branchByHid.id}</td>
                                                <td>${room.branchByHid.name}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${room.type == 1}">
                                                            单人间
                                                        </c:when>
                                                        <c:when test="${room.type == 2}">
                                                            双人间
                                                        </c:when>
                                                        <c:otherwise>
                                                            三人间
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>${room.price}  </td>
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

                <footer><p>Copyright &copy; 2017.Company Hostel World All rights reserved.</p></footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>

    <script type="text/javascript" src="assets/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript">
        $('.form_date').datetimepicker({
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    </script>
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
    <script src="../../assets/js/custom-scripts.js"></script>
</body>
</html>