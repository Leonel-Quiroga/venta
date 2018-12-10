var v=true;
$( document ).ready(function() {
	$('#opt_'+$('#solapa_activa').val()).click();
});
function validar(val){
	$('#oldPass').parent().removeClass('has-error has-success has-feedback');
	$('#oldPass').siblings().remove();
	$.ajax({
				dataType : "json",
				url : 'validarPassword.action',
				contentType : 'application/json',
				cache : false,
				data : {
					'oldPass' : val
				},
				success : function(response) {
					if (response.valido) {
						$('#oldPass')
								.parent()
								.addClass('has-success has-feedback')
								.append(
										'<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
						$('#pass').removeAttr('disabled');
						$('#re-pass').removeAttr('disabled');
						$('#pass').focus();
					} else {
						$('#oldPass')
								.parent()
								.addClass('has-error has-feedback')
								.append(
										'<span class="help-block"><strong>'
												+ response.message
												+ '</strong></span><span class="glyphicon glyphicon-remove form-control-feedback"></span>');
						$('#oldPass').focus();
					}
				},
				error : function(ajaxContext) {
				}
			});
}
function valid(campo){
	var valor=$('#'+campo).val();
	if(valor==null || valor=='' || valor<1){
		v=false;
		$('#'+campo).parent().addClass('has-error has-feedback');
		$('#'+campo).siblings().addClass('help-block');
		$('#ok').attr('disabled',true);
	}else{
		$('#'+campo).parent().removeClass('has-error has-feedback');
		$('#'+campo).siblings().removeClass('help-block');
		$('#ok').removeAttr('disabled');
		v=true;
	}
}
function cargarLoc(campo){
	valid(campo);
	if(v){
		$.ajax({
			dataType : "json",
			url : 'reloadLoc.action',
			contentType : 'application/json',
			cache : false,
			data : {
				'misDatos.codpro' : $('#'+campo).val()
			},
			success : function(response) {
				$( "#divLoc" ).load( location.href+" #divLoc");
			},
			error : function(ajaxContext) {
			}
		});
	}
}
function validarCorreo(mail){
	$('#newMail').parent().removeClass('has-error has-success has-feedback');
	$('#newMail').siblings().remove();
	if (mail != '') {
		$('#newMail').parent().addClass('has-success has-feedback')
					.append('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
	} else {
		$('#newMail').parent().addClass('has-error has-feedback')
					.append('<span class="help-block" style="margin-bottom:0;"><strong>'
							+ 'Dirección de Correo Electrónico inválida'
							+ '</strong></span><span class="glyphicon glyphicon-remove form-control-feedback"></span>');
		$('#newMail').focus();
	}
}