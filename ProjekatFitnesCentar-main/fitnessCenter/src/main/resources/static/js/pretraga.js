$(document).ready(function(){
    if(localStorage.getItem('uloga') != "CLAN")
       $("#zaClanove").css('display', 'none');
    else
       $("#zaClanove").css('display', 'block');
    $("#traziTrening").submit(function(event) {
        event.preventDefault();

        var naziv = $("#naziv").val();
        var trajanje = $("#trajanje").val();

        var datumPocetka = $("#datumPocetka").val();
        var cena = $("#cena").val();

        var obj = JSON.stringify({
            "naziv" : naziv,
            "trajanje" : trajanje,
            "cena" : cena,
            "datumPocetka" : datumPocetka
        });



        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/termini/pretraga",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);

                for (i = 0; i < data.length; i++) {
                    var row = "<tr data-id=" + data[i]['idt'] + ">";
                    row += "<td>" + data[i]['naziv'] + "</td>";
                    row += "<td>" + data[i]['cena'] + "</td>";
                    row += "<td>" + data[i]['trajanje'] + "</td>";
                    row += "<td>" + (data[i]['datumPocetka'].split("T"))[0] + "</td>";
                    row += "<td>" + data[i]['nazivSale'] + "</td>";

                    row += "</tr>";


                    $('#terminiTreninga').append(row);


                }
            },
            error: function (data) {
                alert("Dogodila se greska, pogledaj konzolu");
                console.log("ERROR : ", data);
            }
        });
    });

    let selektovanRed = 0;
    let staraBoja = null;
    $("#terminiTreninga").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#terminiTreninga tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
        }
        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });

    $("#rezervisi").click(function() {
        var korisnik = localStorage.getItem('id');
        var termin = selektovanRed;
        var obj = JSON.stringify({
            "idKorisnika" : korisnik,
            "idTermina" : termin
        });
        // console.log("Rezervisan termin ", selektovanRed);
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/termini/rezervacija",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "pretraga.html";
            },
            error: function (data) {
                alert("Gre??ka!");
            }
        });
    });

});