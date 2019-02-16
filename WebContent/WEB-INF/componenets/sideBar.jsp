<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <ul class="app-menu">
        <li>
            <a class="app-menu__item active" href="cargarCtasCtes?e=true">
                <i class="app-menu__icon fa fa-barcode" aria-hidden="true"></i>
                <span class="app-menu__label">Facturación</span>
            </a>
        </li>
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
        <li class="treeview">
            <a class="app-menu__item" href="#" data-toggle="treeview">
                <i class="app-menu__icon fa fa-file-text-o" aria-hidden="true"></i>
                <span class="app-menu__label">Reportes</span>
            </a>
    </ul>
</aside>