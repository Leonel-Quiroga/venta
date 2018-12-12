<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="description"
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url"
          content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image"
          content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description"
          content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>Inicio</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">
<!-- Navbar-->
<header class="app-header">
    <a class="app-header__logo" href="index.html">VENTA</a>
    <!-- Sidebar toggle button-->
    <a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
       aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#"
                                data-toggle="dropdown" aria-label="Open Profile Menu"><i
                class="fa fa-user fa-lg"></i> <s:property
                value="#session.usuario.apellido" /> &nbsp; <s:property
                value="#session.usuario.nombre" /> </a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li><a class="dropdown-item" href="page-login.html"> <i
                        class="fa fa-sign-out fa-lg"></i> Salir
                </a></li>
            </ul></li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <ul class="app-menu">
        <li><a class="app-menu__item active" href="index.html"><i
                class="app-menu__icon fa fa-barcode" aria-hidden="true"></i><span
                class="app-menu__label">Facturación</span></a></li>
        <li class="treeview"><a class="app-menu__item" href="#"
                                data-toggle="treeview"><i
                class="app-menu__icon fa fa-shopping-cart" aria-hidden="true"></i><span
                class="app-menu__label">Stock</span><i
                class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="AltaProducto"><i
                        class="icon fa fa-circle-o"></i>Alta Producto</a></li>
                <li><a class="treeview-item"
                       href="listaProductos"
                       rel="noopener"><i class="icon fa fa-circle-o"></i> Lista de productos</a></li>
                <li><a class="treeview-item" href="ui-cards.html"><i
                        class="icon fa fa-circle-o"></i> Cards</a></li>
            </ul></li>
        <li class="treeview"><a class="app-menu__item" href="#"
                                data-toggle="treeview"><i
                class="app-menu__icon fa fa-shopping-cart" aria-hidden="true"></i><span
                class="app-menu__label">Cuentas Corrientes</span><i
                class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="formularioCtaCorriente"><i
                        class="icon fa fa-circle-o"></i>Alta Cuenta Corriente</a></li>
                <li><a class="treeview-item"
                       href="listaCtaCorrientes"
                       rel="noopener"><i class="icon fa fa-circle-o"></i> Lista de Ctas Corrientes</a></li>
            </ul></li>
        <li class="treeview"><a class="app-menu__item" href="#"
                                data-toggle="treeview"><i
                class="app-menu__icon fa fa-file-text-o" aria-hidden="true"></i><span
                class="app-menu__label">Reportes</span><i
                class="treeview-indicator fa fa-angle-right"></i></a>
            <ul class="treeview-menu">
                <li><a class="treeview-item" href="form-components.html"><i
                        class="icon fa fa-circle-o"></i> Form Components</a></li>
                <li><a class="treeview-item" href="form-custom.html"><i
                        class="icon fa fa-circle-o"></i> Custom Components</a></li>
                <li><a class="treeview-item" href="form-samples.html"><i
                        class="icon fa fa-circle-o"></i> Form Samples</a></li>
                <li><a class="treeview-item" href="form-notifications.html"><i
                        class="icon fa fa-circle-o"></i> Form Notifications</a></li>
            </ul></li>
    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <div>
            <h1>
                <i class="fa fa-barcode" aria-hidden="true"></i> &nbsp; Alta de Productos
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="col-md-12">
                        <s:form action="guardarProducto" >
                            <div class="form-group">
                                <input required class="form-control" type="number" name="codigo" value="${codigo}" placeholder="Ingrese codigo"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control"  name="nombre" value="${nombre}" placeholder="Ingrese Nombre"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control" type="number" name="cantidad" value="${cantidad}" placeholder="Ingrese La Cantidad"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control" step="0.01" type="number" name="precioUnitario" value="${precioUnitario}" placeholder="Ingrese el Precio Unitario"/>
                            </div>
                            <div class="form-group btn-container">
                                <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in fa-lg fa-fw"></i>Guardar</button>
                            </div>

                        </s:form>

                    </div>

                </div>
            </div>
        </div>
    </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script type="text/javascript" src="js/plugins/chart.js"></script>
<script type="text/javascript">
    var data = {
        labels : [ "January", "February", "March", "April", "May" ],
        datasets : [ {
            label : "My First dataset",
            fillColor : "rgba(220,220,220,0.2)",
            strokeColor : "rgba(220,220,220,1)",
            pointColor : "rgba(220,220,220,1)",
            pointStrokeColor : "#fff",
            pointHighlightFill : "#fff",
            pointHighlightStroke : "rgba(220,220,220,1)",
            data : [ 65, 59, 80, 81, 56 ]
        }, {
            label : "My Second dataset",
            fillColor : "rgba(151,187,205,0.2)",
            strokeColor : "rgba(151,187,205,1)",
            pointColor : "rgba(151,187,205,1)",
            pointStrokeColor : "#fff",
            pointHighlightFill : "#fff",
            pointHighlightStroke : "rgba(151,187,205,1)",
            data : [ 28, 48, 40, 19, 86 ]
        } ]
    };
    var pdata = [ {
        value : 300,
        color : "#46BFBD",
        highlight : "#5AD3D1",
        label : "Complete"
    }, {
        value : 50,
        color : "#F7464A",
        highlight : "#FF5A5E",
        label : "In-Progress"
    } ]

    var ctxl = $("#lineChartDemo").get(0).getContext("2d");
    var lineChart = new Chart(ctxl).Line(data);

    var ctxp = $("#pieChartDemo").get(0).getContext("2d");
    var pieChart = new Chart(ctxp).Pie(pdata);
</script>
<!-- Google analytics script-->
<script type="text/javascript">
    if (document.location.hostname == 'pratikborsadiya.in') {
        (function(i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function() {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o), m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script',
            '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-72504830-1', 'auto');
        ga('send', 'pageview');
    }
</script>
</body>
</html>