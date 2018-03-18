<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    申请信息  <small>请记住您的申请编号</small>
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
                                    <label>申请编号:</label>
                                    <c:choose>
                                        <c:when test="${keyNum == -1}">
                                            <span class="label label-primary">申请失败</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="label label-primary"> ${keyNum}</span>
                                        </c:otherwise>

                                    </c:choose>
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
                                    <span class="label label-primary"> ${applyName}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>身份证号:</label>
                                    <span class="label label-primary"> ${applyIcard}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>银行卡号:</label>
                                    <span class="label label-primary"> ${applyBankNum}</span>
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
                                    <div class="title">分店信息</div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="form-group col-xs-4">
                                    <label>分店城市: </label>
                                    <span class="label label-primary"> ${city}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>具体地址:</label>
                                    <span class="label label-primary"> ${address}</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>客房数:</label>
                                    <span class="label label-primary"> ${numOfRoom}</span>
                                </div>
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