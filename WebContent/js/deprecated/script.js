document.write('<script src="js/coockie.js"></script>');
document.write('<script src="js/carga.js"></script>');
document.write('<script src="js/qr-generator.js"></script>');

// login
function login() {
	var token = getTokenLogin($('#user').val(), {
		'pass' : $('#pass').val(),
		'codDoc' : $('#dniType').val()
	});
	$.get("http://" + URL + "/!/login/auth/" + token).promise().done(
			function(response) {
				setCookie(AUTH, response.osm, response.expiry);
				redirect(INICIO,GLOBAL_CONTENT);
			}).fail(function(reason) {
		alert("error");
	});
}
// common
function getDniType() {
	$.get("http://" + URL + "/!/common/tipodocumentos/")
	.promise()
	.done(function(response) {
		for (var i = 0; i < response.length; i++) {
			$('#dniType').append('<option value="' + response[i].codigo + '">'
									+ response[i].descripcion + '</option>');
		}
	}).fail(function(reason) {
		alert("error");
	});
}
function redirect(pagina,content) {
	$.get("http://" + URL + "/!/common/redirect/" + pagina)
	.promise()
	.done(function(response) {
				$('#'+content).text('');
				$('#'+content).append(response);
				load(pagina);
	})
	.fail(function(reason) {
		alert("error");
	});
}
function load(pagina){
	switch(pagina) {
    case INICIO:
        inicio()
        break;
    case AUTORIZACIONES:
        autorizaciones()
        break;
    case AUTORIZACION:
        autorizacion()
        break;
    case REINTEGROS:
        reintegros()
        break;
    case CREDENCIALES:
        credenciales()
        break;
    case CERTIFICADOS:
    	certificados()
    	break;
    case LOGIN:
    	getDniType();
    	break;	
    default:
    	return false;
	}
}
function go(id,pagina) {
	if(activo(AUTH)){
	if(null!=id){	
	$('#'+id).addClass('active');
	$('#'+id).siblings('li').removeClass('active');
	}
	redirect(pagina,CONTENT);
	}else{
		redirect(LOGIN,GLOBAL_CONTENT);
	}
}
//end common

//datos de carga de la pantalla inicio.
function inicio(){
	$.get("http://" + URL + "/!/common/asociado/" + getCookie(AUTH))
	.promise()
	.done(function(response) {
		$('#nombre').text(response.nombre);
	})
	.fail(function(reason) {
		redirect(LOGIN,GLOBAL_CONTENT);
	});
}
//autorizaciones
function autorizaciones(){
	$.get("http://" + URL + "/!/common/beneficiario/" + getCookie(AUTH))
	.promise()
	.done(function(response) {
		for(var i=0;i<response.length;i++){
			$('#ben').append('<option value="' + response[i].codBeneficiario + '">'
					+ response[i].nombre+" "+response[i].apellido + '</option>');
		}
	})
	.fail(function(reason) {
		redirect(LOGIN,GLOBAL_CONTENT);
	});
	$.get("http://" + URL + "/!/autorizacion/listaAutorizaciones/" + getCookie(AUTH))
	.promise()
	.done(function(response) {
		for(var i=0;i<response.length;i++){
			$('#t_body').append('<tr><td>'+response[i].numero+'</td><td>'+response[i].numafi+" "+response[i].codcdb+'</td><td>'+response[i].codord+'</td><td>'+response[i].fecaut+'</td><td>'+response[i].estado+'</td></tr>');
		}
	})
	.fail(function(reason) {
		redirect(LOGIN,GLOBAL_CONTENT);
	});
}
//Autorizacion
function getQR(){
    if(activo(AUTH)){
	var token=getCookie(AUTH);
	var data = KJUR.jws.JWS.readSafeJSONString(b64utoutf8(token.split(".")[1]));
	var unique=new Date().getTime();
	update_qrcode(String(data.key)+"."+String(unique));
	$('#btn_qr_modal').click();
	getImagen(String(data.key)+"."+String(unique));
    }else{
		redirect(LOGIN,GLOBAL_CONTENT);
	}
    
}
function getImagen(key){
	$.get("http://" + URL + "/!/autorizacion/getFile/" + key)
	.done(function(response) {
		alert(response);
	})
	.fail(function(reason) {
		//redirect(LOGIN,GLOBAL_CONTENT);
	});
	
}