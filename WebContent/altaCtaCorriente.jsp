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
                <i class="fa fa-barcode" aria-hidden="true"></i> &nbsp; Alta de Cuentas Corrientes
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="col-md-12">
                        <s:form action="altaCtasCtes" >
                            <div class="form-group">
                                <input required class="form-control" type="number" name="documento" value="${documento}" placeholder="Ingrese documento"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control" name="nombre" value="${nombre}" placeholder="Ingrese Nombre"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control" name="apellido" value="${apellido}" placeholder="Ingrese Apellido"/>
                            </div>
                            <div class="form-group">
                                <input required type="email" class="form-control" name="mail" value="${mail}" placeholder="Ingrese Mail"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control" type="number"  step="0.01" name="saldoOperativo" value="${saldoOperativo}" placeholder="Ingrese el Saldo Inicial"/>
                            </div>
                            <div class="form-group">
                                <input required class="form-control" name="calle" value="${calle}" placeholder="Ingrese la Calle"/>
                            </div>

                            <div class="form-group">
                                <input required class="form-control" name="telefono" value="${telefono}" placeholder="Ingrese Telefono"/>
                            </div>
                            <div class="form-group" >
                                <s:select cssClass="form-control line" onselect="" headerKey="-1"
                                          headerValue="Seleccione una Localidad" list="listLocalidades"
                                          listKey="idLocalidad" listValue="denominacion + ' ' + codigoPostal"
                                            name="localidad">

                                </s:select>
                            </div>
                            <div class="form-group btn-container">
                                <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in fa-lg fa-fw"></i>Ingresar</button>
                            </div>

                        </s:form>

                    </div>

                </div>
            </div>
        </div>
    </div>
</main>
</b:base>