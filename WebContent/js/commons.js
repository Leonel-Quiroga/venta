var n = '0123456789';
var l = 'QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm';
$( document ).ready(function() {
	$('#mailModal').on('hidden.bs.modal',function(){
		var id = "mail";
		  if($('#cambioMail').val()=='true'){
				$('#'+id).parent()
				.addClass('has-success has-feedback')
				.append('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');  
				$('#pass').focus();
		  }else{
				$('#'+id).parent()
				.addClass('has-error')
				.append('<span class="glyphicon glyphicon-remove form-control-feedback"></span>'
						+'<span class="help-block"><strong>El correo no coincide con el registrado.</strong></span>');
				$('#'+id).focus();
		  }
	})
});
function validarMail(id) {
	$('#'+id).parent().removeClass('has-error has-success has-feedback');
	$('#'+id).siblings('span').remove();
	$('#'+id).siblings('strong').removeClass('help-block');
	var email = $('#'+id).val();
if(socValid){
	var caract = new RegExp(
			/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/);

	if (caract.test(email)) {
		$.ajax({
			dataType : "json",
			url : 'validarCorreo.action',
			contentType : 'application/json',
			cache : false,
			data : {
				'form.correo':$('#mail').val(),
				'form.documento' : $('#dni').val(),
				'numAsociado' : $('#numafi').val()
			},
			success : function(response) {
				if (response.valido) {
					$('#'+id).parent()
					.addClass('has-success has-feedback')
					.append('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
				} else {
					$('#mailModal').modal('show');
					$('#modalTitle').text('');
					$('#modalTitle').append($('#mail').val());
				}
			},
			error : function(ajaxContext) {
			}
		});
	} else {
		$('#'+id).parent()
					.addClass('has-error')
					.append('<span class="help-block"><strong><s:text name="CORREO_INVALIDO" /></strong></span>'
							+'<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
		$('#'+id).focus();
	}
	}else{
		$('#numafi').focus();
	}
}
function validarPass(pass,repass,valido){
	$('#pass').parent().removeClass('has-error has-feedback');
	$('#pass').siblings('span').remove();
	$('#pass').siblings().removeClass('help-block');
	$('#re-pass').parent().removeClass('has-error has-feedback');
	$('#re-pass').siblings('span').remove();
	$('#re-pass').siblings().removeClass('help-block');
	if ((pass == '' || pass <= 0)
			&& ($('#pass').attr('disabled') != true && $('#pass').attr(
					'disabled') != 'disabled')) {
		$('#pass').parent().addClass('has-error has-feedback');
		$('#pass').siblings().addClass('help-block');

		valor = false;
	} else if (pass.length < 6
			&& ($('#pass').attr('disabled') != true && $('#pass').attr(
					'disabled') != 'disabled')) {
		$('#pass').parent().addClass('has-error has-feedback');
		$('#pass')
				.parent()
				.append(
						'<span><strong class="help-block">La clave debe tener como mínimo una longitud de 6 caracteres</strong></span>')
		return false;
	} else {
		var cn = 0, cl = 0;
		for (var i = 0; i < pass.length; i++) {
			if (n.indexOf(pass[i]) > -1) {
				cn++;
			} else if (l.indexOf(pass[i]) > -1) {
				cl++;
			} else {
				$('#pass').parent().addClass('has-error has-feedback');
				$('#pass')
						.parent()
						.append(
								'<span><strong class="help-block">La clave contiene caracteres inválidos.</strong></span>')
				return false;
			}
		}
		if ((cn > 0 && cl > 0 && valido)
				|| ($('#pass').attr('disabled') == true || $('#pass').attr(
						'disabled') == 'disabled')) {
			$('#pass').parent().removeClass('has-error has-feedback');
			$('#pass').siblings('span').remove();
			$('#pass').siblings().removeClass('help-block');
		} else {
			$('#pass').parent().addClass('has-error has-feedback');
			$('#pass')
					.parent()
					.append(
							'<span><strong class="help-block">La clave debe contener numeros y letras</strong></span>')
			return false;
		}
	}
	if ((repass == '' || repass <= 0)
			&& ($('#re-pass').attr('disabled') != true && $('#re-pass').attr(
					'disabled') != 'disabled')) {
		$('#re-pass').parent().addClass('has-error has-feedback');
		$('#re-pass').siblings().addClass('help-block');
		return false;
	} else {
		if (repass != pass) {
			$('#re-pass').parent().addClass('has-error has-feedback');
			$('#re-pass')
					.parent()
					.append(
							'<span><strong class="help-block">Las claves no coinciden</strong></span>')
			return false;
		} else {
			$('#re-pass').parent().removeClass('has-error has-feedback');
			$('#re-pass').siblings('span').remove();
			$('#re-pass').siblings().removeClass('help-block');
		}
	}
	return true;
}
function cambio(estado){
	$('#cambioMail').val(estado);
	$('#mailModal').modal('hide');
}