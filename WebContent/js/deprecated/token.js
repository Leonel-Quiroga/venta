document.write('<script src="js/jsrsasign-latest-all-min.js"></script>');
function getTokenLogin(user,data){
	// Header
	var oHeader = {alg: 'HS256', typ: 'JWT'};
	// Payload
	var oPayload = {};
	var tNow = KJUR.jws.IntDate.get('now');
	var tEnd = KJUR.jws.IntDate.get('now + 1day');
	oPayload.iss = "http://osam.org.ar";
	oPayload.sub = user;
	oPayload.pass = data.pass;
	oPayload.codDoc = data.codDoc;
	var sHeader = JSON.stringify(oHeader);
	var sPayload = JSON.stringify(oPayload);
	var sJWT = KJUR.jws.JWS.sign("HS256", sHeader, sPayload, {b64:"uWqgd1YyfAqDEWyKQfvhasrqEVTnOUvYwFubgWKkoJY=" });
	return sJWT; 
}