<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="b" tagdir="/WEB-INF/tags" %>
<b:base>
    <jsp:include page="WEB-INF/componenets/navBar.jsp"/>
    <jsp:include page="WEB-INF/componenets/sideBar.jsp"/>
<main class="app-content">
    <div class="app-title">
        <div>
            <h1>
                <i class="fa fa-barcode" aria-hidden="true"></i> &nbsp; Cuentas Corrientes
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Codigo</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Precio Unitario</th>
                                <th scope="col">Activo</th>
                                <th scope="col">Fecha de carga</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="listaProductos" status="s">
                                <tr>
                                    <td><s:property value="%{codigo}" /> </td>

                                    <td><s:property value="%{nombre}" /> </td>

                                    <td><s:property value="%{cantidad}" /> </td>

                                    <td><s:property value="%{precioUnitario}" /> </td>

                                    <td><s:property value="%{activo}" /> </td>

                                    <td><s:property value="%{alta}" /> </td>
                                    <td>
                                        <s:form action="borrarProducto" >
                                            <input name="idProducto" type="hidden" value="<s:property value="%{idProducto}" />"/>
                                            <button type="submit" class="btn btn-danger ">Borrar</button>
                                        </s:form>
                                    </td>

                                </tr>
                            </s:iterator>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
</b:base>