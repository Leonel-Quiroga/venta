
function setCookie(cname,cvalue,exdays) {
    var d = new Date(exdays);
    d.setSeconds(d.getSeconds()+10);
    //d.setHours(d.getHours()-3,d.getMinutes(),d.getSeconds(),d.getMilliseconds());
    var expires = "expires=" + d.toUTCString();
    
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function activo(name) {
    var user=getCookie(name);
    return user != ""
}

