<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
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
                        <li><a href="／logout"><i class="fa fa-sign-out fa-fw"></i>登出</a></li>
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
                        <a href="/associator-information?id=${id}"><i class="fa fa-table"></i>信息统计</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i>我的信息</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div class="header">
                <h1 class="page-header">
                    改资料  <small>请保证正确填写信息</small>
                </h1>
            </div>

            <div id="page-inner">

                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="card-title">
                                    <div class="title">兑换规则</div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <li>每消费100元兑换一个会员点</li>
                                <li>每100个会员点升一级</li>
                                <li>级别越高，会员折扣越大</li>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="card-title">
                                    <div class="title">会员卡信息</div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="form-group col-xs-4">
                                    <label >余额</label>
                                    <span class="label label-primary">${userInfor.balace}元</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label >等级</label>
                                    <span class="label label-primary">${userInfor.level}级</span>
                                </div>
                                <div class="form-group col-xs-4">
                                    <label>会员点</label>
                                    <span class="label label-primary">${userInfor.point}点</span>
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
                                    <div class="title">填写新信息</div>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form action="/modifyUserInfor" method="post">
                                    <input class="hidden" value="${id}" name="id">
                                    <div class="form-group col-xs-4">
                                        <label for="name">姓名</label>
                                        <input type="text" class="form-control" id="name" name="userName" value="${userInfor.name}">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="phone">电话</label>
                                        <input type="text" class="form-control" id="phone" name="userPhone" value="${userInfor.phone}">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="icard">银行卡</label>
                                        <input type="text" class="form-control" id="icard" name="userIcard" value="${userInfor.icard}">
                                    </div>

                                    <div class="form-group col-xs-4">
                                        <label for="password1">密码</label>
                                        <input type="password" class="form-control" id="password1" name="password1" placeholder="新密码">
                                    </div>


                                    <div class="form-group col-xs-4">
                                        <label for="password2">确认密码</label>
                                        <input type="password" class="form-control" id="password2" name="password2" placeholder="确认密码">
                                    </div>


                                    <div class="col-xs-4">
                                        <div class="sub-title">
                                            取消会员资格：
                                        </div>
                                        <div class="radio3 radio-check radio-inline">
                                            <input type="radio" id="yes" name="isMember" value="option1" checked="">
                                            <label for="yes">
                                                是
                                            </label>
                                        </div>
                                        <div class="radio3 radio-check radio-success radio-inline">
                                            <input type="radio" id="no" name="isMember" value="option2">
                                            <label for="no">
                                                否
                                            </label>
                                        </div>
                                    </div>

                                    <div class="col-xs-5">
                                        <input type="submit" value="确认修改" class="btn btn-primary btn-lg" >
                                    </div>
                                </form>
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
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

      
    <!-- Chart Js -->
    <script type="text/javascript" src="assets/js/Chart.min.js"></script>  
    <script type="text/javascript" src="assets/js/chartjs.js"></script>

</body>
</html>