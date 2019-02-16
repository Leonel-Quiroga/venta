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
                                <th scope="col">Documento</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Mail</th>
                                <th scope="col">Telefono</th>
                                <th scope="col">Saldo</th>
                                <th scope="col">Borrar</th>
                            </tr>
                            </thead>
                            <tbody>
                            <s:iterator value="listCuentasCorrientes" status="s">
                                <tr>
                                    <td><s:property value="%{documento}" /> </td>

                                    <td><s:property value="%{nombre}" /> </td>

                                    <td><s:property value="%{apellido}" /> </td>

                                    <td><s:property value="%{mail}" /> </td>

                                    <td><s:property value="%{telefono}" /> </td>

                                    <td><s:property value="%{saldoOperativo}" /> </td>
                                    <td>
                                        <s:form action="borrarCtaCorriente" >
                                            <input name="idCtaCorriente" type="hidden" value="<s:property value="%{idCuentaCorriente}" />"/>
                                            <button type="submit" class="btn btn-danger">Borrar</button>
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