<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
      <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <title>Login</title>
  </head>
  <body>
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
    <!-- Essential javascripts for application to work-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="js/plugins/pace.min.js"></script>
</body>
</html>