function agregarProducto() {
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
				'validaciones': $('#no-stock').val()
			},
			success : function(data) {
				$('#contenido').load(location.href + ' #contenido');
				$('#totales').load(location.href + ' #totales');
				$('#error-div').hide();
			},
			error : function(data) {
				var noStock = $('#error-div');
                noStock.load(location.href + ' #error-message');
                noStock.show();
			}
		});
}
