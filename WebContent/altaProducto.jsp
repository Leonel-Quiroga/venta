<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="b" tagdir="/WEB-INF/tags" %>
<b:base>
    <jsp:include page="WEB-INF/componenets/navBar.jsp"/>
    <jsp:include page="WEB-INF/componenets/sideBar.jsp"/>
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
</main>
</b:base>