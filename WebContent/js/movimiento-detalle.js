function agregarProducto() {
	console.log("lala");
	$.ajax({
			dataType : "json",
			url : 'agregarProducto.action',
			contentType : 'application/json',
			cache : false,
			async: false,
			data : {
				'idCuentaCorriente': $('#idCuentaCorriente').val(),
				'idProducto' : $('#producto').val(),
				'cantidad' : $('#cantidad').val(),
			},
			success : function(data) {
				$('#contenido').load(location.href.replace("true", "false") + ' #contenido');
				$('#totales').load(location.href.replace("true", "false") + ' #totales');
				$('#no-stock').css('visibility', 'hidden')
			
			},
			error : function(ajaxContext) {
				$('#no-stock').css('visibility', 'visible')
			}
		});
}


