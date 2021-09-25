$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/pregledTreninga",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['naziv'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tip'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#pregledTreninga').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });
});

let selektovanRed = 0;
let staraBoja = null;
$("#pregledTreninga").on('click', 'tr:not(:first-child)', function() {
    if (staraBoja != null) {
        $('#pregledTreninga tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
    }
    selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
    staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

    $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
    console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
});


$(document).on("submit","form",function(event){
    event.preventDefault();

    var nazivTreninga=$("#nazivTreninga").val();
    var cena=$("#cena").val();
    var datumPocetkaTreninga=$("#datumPocetkaTreninga").val();
    var idTreninga=selektovanRed;
    var newFitnesCentarJSON=formToJSON(nazivTreninga,cena,datumPocetkaTreninga,idTreninga);
    $.ajax({
        type:"POST",
        url:"http://localhost:8181/api/termini/kreiranje",
        dataType:"json",
        contentType:"application/json",
        data: newFitnesCentarJSON,
        success:function(){
            alert("Uspesno ste dodali novi termin ");
            window.location.href="izmenaTermina.html";
        }
    });
});
function formToJSON(nazivTreninga,cena,datumPocetkaTreninga,idTreninga){
    return JSON.stringify({
        "nazivTreninga":nazivTreninga,
        "cena":cena,
        "datumPocetkaTreninga":datumPocetkaTreninga ,
        "idTreninga":idTreninga
    });
}