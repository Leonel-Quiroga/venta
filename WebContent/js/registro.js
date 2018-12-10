function validar() {

	$('#dni').parent().removeClass('has-error');
	$('#dni').siblings().removeClass('help-block');
	$('#numafi').parent().removeClass('has-error');
	$('#numafi').siblings().removeClass('help-block');
	$('#mail').parent().removeClass('has-error');
	$('#mail').siblings().removeClass('help-block');

	var dni = $('#dni').val();
	var numero = $('#numafi').val();
	var mail = $('#mail').val();
	var pass = $('#pass').val();
	var repass = $('#re-pass').val();
	var valor = true;
	if ($('#recovery').val() == 'false') {
		if (dni == '' || dni <= 0 || dni.length < 5) {
			$('#dni').parent().addClass('has-error has-feedback');
			$('#dni').siblings().addClass('help-block');
			valor = false;
		} else {
			$('#dni').parent().removeClass('has-error');
			$('#dni').siblings().removeClass('help-block');

		}
		if ((numero == '' || numero <= 0 || numero.length < 4)
				&& ($('#numafi').attr('disabled') != true && $('#numafi').attr(
						'disabled') != 'disabled')) {
			$('#numafi').parent().addClass('has-error has-feedback');
			$('#numafi').siblings().addClass('help-block');
			valor = false;
		} else {
			$('#numafi').parent().removeClass('has-error');
			$('#numafi').siblings().removeClass('help-block');

		}
		if ((mail == '' || mail <= 0)
				&& ($('#mail').attr('disabled') != true && $('#mail').attr(
						'disabled') != 'disabled')) {
			$('#mail').parent().addClass('has-error has-feedback');
			$('#mail').siblings().addClass('help-block');

			valor = false;
		} else {
			$('#mail').parent().removeClass('has-error');
			$('#mail').siblings().removeClass('help-block');

		}
		
	}
	valor=validarPass(pass,repass,valor)
	if (valor == true){
		load('crear');
	$('#crearUsuario').submit();
	}else{
	return false;	
	}
}
function load(id) {
	$('#' + id).addClass('buttonload');
	$('#' + id)
			.prepend(
					'<i class="fa fa-circle-o-notch fa-spin"  style="margin-right:0.5em;"></i>');
}
function habilitar(value) {
	var habilitar = value.length == 0;
	$('#numafi').attr('disabled', habilitar);
	$('#mail').attr('disabled', habilitar);
	$('#pass').attr('disabled', habilitar);
	$('#re-pass').attr('disabled', habilitar);

}
function validarDocumento() {
	$('#dni').parent().removeClass('has-error has-success has-feedback');
	$('#dni').siblings('span').remove();
	$('#dni').siblings('strong').removeClass('help-block');
	if($('#dni').val().length>0){
	
	$.ajax({
				dataType : "json",
				url : 'validarDocumento.action',
				contentType : 'application/json',
				cache : false,
				data : {
					'form.documento' : $('#dni').val()
				},
				success : function(response) {
					if (response.valido) {
						$('#dni')
								.parent()
								.addClass('has-success has-feedback')
								.append(
										'<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
						if($('#error').val()=='true'){
							validarAsociado();
						}
					} else {
						$('#dni')
								.parent()
								.addClass('has-error has-feedback')
								.append(
										'<span class="help-block"><strong>'
												+ response.message
												+ '</strong></span><span class="glyphicon glyphicon-remove form-control-feedback"></span>');
						$('#dni').focus();
					}
				},
				error : function(ajaxContext) {
				}
			});
	}
}
var socValid=false;
function validarAsociado() {
	$('#numafi').parent().removeClass('has-error has-success has-feedback');
	$('#numafi').siblings('span').remove();
	$('#numafi').siblings('strong').removeClass('help-block');
	$.ajax({
				dataType : "json",
				url : 'validarAsociado.action',
				contentType : 'application/json',
				cache : false,
				data : {
					'form.documento' : $('#dni').val(),
					'numAsociado' : $('#numafi').val()
				},
				success : function(response) {
					if (response.valido) {
						socValid=response.valido;
						$('#numafi')
								.parent()
								.addClass('has-success has-feedback')
								.append(
										'<span id="m_e" class="glyphicon glyphicon-ok form-control-feedback"></span>');
						if($('#error').val()=='true'){
							validarMail('mail');
						}
					} else {
						socValid=response.valido;
						$('#numafi')
								.parent()
								.addClass('has-error has-feedback')
								.append(
										'<span class="help-block"><strong>'
												+ response.message
												+ '</strong></span><span class="glyphicon glyphicon-remove form-control-feedback"></span>');
						$('#numafi').focus();
					}
				},
				error : function(ajaxContext) {
				}
			});
}
