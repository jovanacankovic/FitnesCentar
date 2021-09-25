$(document).ready(function () {
    var korisnik = localStorage.getItem('id');
    var obj = JSON.stringify({
        "idKorisnika" : korisnik
    });
    $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/trener/treninziTrenera",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function (data) {
            console.log("SUCCESS:\n", data);

            for (i = 0; i < data.length; i++) {

                var row = "<tr data-id=" + data[i]['id'] + ">";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                row += "</tr>";

                $('#treninzi').append(row);
                //window.location.href = "dodavanjeTreninga.html";
            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);
        }
    });
    let selektovanRed = 0;
    let staraBoja = null;
    $("#treninzi").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#treninzi tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja);
        }
        selektovanRed = this.dataset.id;
        staraBoja = $(this).css('background-color');

        $(this).css('background-color', '#a6c9e2');
        console.log("Selektovan red ", selektovanRed);
    });
    $("#kreiraj").click(function() {
        var korisnik = localStorage.getItem('id');
        var trening = selektovanRed;
        var cena = $("#cena").val();
        var datumPocetkaTreninga = $("#datumPocetkaTreninga").val();

        var obj = JSON.stringify({
            "korisnik" : korisnik,
            "trening" : trening,
            "datumPocetkaTreninga" : datumPocetkaTreninga,
            "cena" : cena
        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/termini/kreiranje",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
            },
            error: function (data) {
                alert("Greška!");
            }
        });
    });

});