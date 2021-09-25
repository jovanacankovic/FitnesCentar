$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/termini",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['naziv'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['cena'] + "</td>";
                row += "<td>" + data[i]['datumPocetka'] + "</td>";
               // row += "<td>" + data[i]['sala'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#terminiTreninga').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });
});