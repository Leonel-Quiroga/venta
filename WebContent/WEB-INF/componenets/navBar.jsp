<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Navbar-->
<header class="app-header">
    <a class="app-header__logo" href="cargarCtasCtes">VENTA</a>
    <!-- Sidebar toggle button-->
    <a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
       aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#"
                                data-toggle="dropdown" aria-label="Open Profile Menu"><i
                class="fa fa-user fa-lg"></i>
            <s:property value="#session.usuario.apellido" /> &nbsp;
            <s:property value="#session.usuario.nombre" /> </a>
            <ul class="dropdown-menu settings-menu dropdown-menu-right">
                <li><a class="dropdown-item" href="logout"> <i
                        class="fa fa-sign-out fa-lg"></i> <s:text name="Salir" />
                </a></li>
            </ul></li>
    </ul>
</header>