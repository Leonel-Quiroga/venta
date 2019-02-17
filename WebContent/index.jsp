<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="b" tagdir="/WEB-INF/tags" %>

<b:base>
	<jsp:include page="WEB-INF/componenets/navBar.jsp"/>
	<jsp:include page="WEB-INF/componenets/sideBar.jsp"/>
	<main class="app-content">
		<div class="app-title">
			<div>
				<h1><i class="fa fa-barcode" aria-hidden="true"></i> &nbsp; FACTURACIÓN</h1>
			</div>
		</div>

			<div class="col-md-12">
				<div class="tile">
					<div class="tile-body">
						<div class="col-md-12">
							<s:form action="facturar">
								<div id="error-div" class="alert alert-danger" role="alert" style="display: none">
									<span id="error-message" ><s:property value="#session.validaciones" /></span>
								</div>
								<div class="row">
									<div class="col-md-4">
										  <s:select cssClass="form-control line" onselect="" headerKey="-1"
													headerValue="Seleccionar Cta Cte" list="listCtasCtes"
													listKey="idCuentaCorriente" listValue="apellido + ' ' + nombre"
													name="listCtasCtes.idCuentaCorriente" id="idCuentaCorriente"/>
									</div>
									<div class="col-md-3">
										<div class="dropdown">
											  <s:select cssClass="form-control line" onselect="" headerKey="-1"
														headerValue="Seleccionar producto" list="listProductos"
														listKey="idProducto" listValue="nombre"
														name="listProductos.idProducto" id="producto" />
										</div>
									</div>
									&nbsp;
									<div class="col-md-1">
										 <s:textfield name="Cantidad"  placeholder="Cantidad" cssClass="form-control" id="cantidad" type="text" />
								    </div>
								    <div class="col-md-2">
								 	  <button type="button" class="btn btn-primary btn-block" onclick="agregarProducto();">
									   Agregar producto
									  </button>
								    </div>
								    
								</div>
							</div>
							
								<div class="row">
									<div id="contenido">
										<table class="table">
											<thead>
												<tr>
													<th scope="col">Codigo</th>
													<th scope="col">Descripcion</th>
													<th scope="col">Cantidad</th>
													<th scope="col">Precio Unit.</th>
													<th scope="col">Total x Unidad</th>
													<th scope="col">I.V.A</th>
													<th scope="col">Total</th>
												</tr>
											</thead>
											<tbody>
												<s:if test="#session.detalleVenta.size()>0">
												<s:iterator value="#session.detalleVenta" status="p" >
												<tr>												
													<td><s:property value="codigo" /> </td>	
													<td><s:property value="nombre" /> </td>											
													<td><s:property value="cantidad" /> </td>
													<td><s:property value="precioUnitario" /> </td >
													<td><s:property value="totalPorUnidad" /> </td>											
													<td><s:property value="iva" /> </td>
													<td><s:property value="total" /> </td>
												</tr>												
												</s:iterator>
												</s:if>
											</tbody>
										</table>
									</div>
								</div>
								<hr>
							<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-3">	
									<div class="row">														
										<div class="col-md-8 text-right">							  	
										 <strong><a>SUBTOTAL</a></strong> 													
										</div>
									</div>
									<div class="row">														
										<div class="col-md-8 text-right">							  	
										 <strong><a>IVA</a></strong> 												
										</div>
									</div>
									<div class="row">	
																						
										<div class="col-md-8 text-right">							  	
										 <strong><a>TOTAL</a></strong> 													
										</div>
									</div>
								</div>
								<div class="col-md-3" id="totales">
									<div class="row">
										<div class="col-md-8 text-right">							  	
										 <strong><a><s:property value="#session.totalesFactura.totalNetoFactura"/></a></strong> 													
										</div>
									</div>
									<div class="row">														
										<div class="col-md-8 text-right">							  	
										 <strong><a><s:property value="#session.totalesFactura.totalIVAFactura"/> </a></strong> 												
										</div>
									</div>
									<div class="row">														
										<div class="col-md-8 text-right">							  	
										 <strong><a><s:property value="#session.totalesFactura.totalFactura"/></a></strong> 													
										</div>
									</div>
								</div>
							</div>							
							<div class="row">								
								<div class="col-md-12 text-right">								
								  <a type="button"  href="cargarCtasCtes?e=true" class="btn btn-primary" style="-webkit-appearance:none;"> Cancelar</a>	&nbsp;						
								  <s:submit type="button" value="Finalizar Venta" cssClass="btn btn-primary" />							
								</div>
							</div>
							</s:form>
						</div>
					</div>
				</div>
			
		</div>
	</main>

	<script type="text/javascript" src="js/movimiento-detalle.js"></script>

</b:base>