$(document).on("submit","form",function(event){
    event.preventDefault();

    var naziv=$("#naziv").val();
    var idCentra=$("#idCentra").val();
    var kapacitet = $("#kapacitet").val();
    var newFitnesCentarJSON=formToJSON(naziv,idCentra,kapacitet);
    $.ajax({
        type:"POST",
        url:"http://localhost:8181/api/sviFitnesCentri/dodajSalu",
        dataType:"json",
        contentType:"application/json",
        data: newFitnesCentarJSON,
        success:function(){
            alert("Uspesno ste dodali salu u fitnes centar "+naziv);
            window.location.href="home.html";
        }
    });
});
function formToJSON(naziv,idCentra,kapacitet){
    return JSON.stringify({
        "naziv":naziv,
        "idCentra":idCentra,
        "kapacitet":kapacitet
    });
}