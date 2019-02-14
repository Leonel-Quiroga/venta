function myFunction(x) {
    x.classList.toggle("change");
   ($('#mySidenav').width()>0)?closeNav():openNav();
}
/* Set the width of the side navigation to 250px */
function openNav() {
    document.getElementById("mySidenav").style.width = "150px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";

}