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
                        <a href="#"><i class="fa fa-edit"></i>资料填写</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div class="header">
                <h1 class="page-header">
                    填写资料  <small>请保证正确填写信息</small>
                </h1>
            </div>

            <div id="page-inner">

                <form action="/confirmApply" method="post">

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">申请人信息</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group col-xs-4">
                                        <label for="applyName">姓名</label>
                                        <input type="text" class="form-control" id="applyName" name="applyName" placeholder="姓名">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="icard">身份证号</label>
                                        <input type="text" class="form-control" id="icard" name="icard" placeholder="身份证号">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="bank_number">银行卡号</label>
                                        <input type="text" class="form-control" id="bank_number" name="bank_number" placeholder="银行卡号">
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
                                        <label for="city">城市</label>
                                        <input type="text" class="form-control" id="city" name="city" placeholder="城市">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="address">地址</label>
                                        <input type="text" class="form-control" id="address" name="address" placeholder="地址">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="numOfroom">房间数目</label>
                                        <input type="text" class="form-control" id="numOfroom" name="numOfroom" placeholder="房间数目">
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
                                        <div class="title">密码信息</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group col-xs-4">
                                        <label for="password1">密码</label>
                                        <input type="password" class="form-control" id="password1" name="password1" placeholder="密码">
                                    </div>
                                    <div class="form-group col-xs-4">
                                        <label for="password2">确认密码</label>
                                        <input type="password" class="form-control" id="password2" name="password2" placeholder="确认密码">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="col-xs-4">
                                        <input type="submit" value="申请" class="btn btn-primary btn-lg" >
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </form>

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

    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

</body>
</html>