$(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/sale",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['oznaka'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['kapacitet']  + "</td>";
                row += "<td>" + data[i]['fitnessCentar'].id  + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#sale').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });
    let selektovanRed = 0;
    let staraBoja = null;
    $("#sale").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#sale tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
        }
        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });

    $("#obrisi").click(function() {
        var sala = selektovanRed;
        var obj = JSON.stringify({
            "idKorisnika" : sala
        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/sale/brisanje",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "brisanjeSale.html";
            },
            error: function (data) {
                alert("Greška!");
            }
        });
    });


});