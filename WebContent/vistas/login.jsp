<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="b" tagdir="/WEB-INF/tags" %>
<b:base>
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <h1>Esto no es un sistema de ventas</h1>
      </div>
      <div class="login-box">
        <s:form action="login" namespace="/" theme="simple" cssClass="login-form">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>Inicie sesión</h3>
          <div class="form-group">
            <s:textfield name="usuario" cssClass="form-control" type="text" placeholder="Usuario"  />
          </div>
          <div class="form-group">
            <s:password cssClass="form-control"  name="contrasenia" type="password" placeholder="Contraseña" />
          </div>
          <div class="form-group btn-container">
            <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in fa-lg fa-fw"></i>Ingresar</button>
          </div>
        </s:form>
      </div>
    </section>
</b:base>