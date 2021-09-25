$(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/trener",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trener of response) {
                let row = "<tr data-id=" + trener.id + ">";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.datumRodjenja + "</td>";
                row += "</tr>";

                $('#terminiTreninga').append(row);
            }
        },
        error: function (response) {
        }

    });
    let selektovanRed = 0;
    let staraBoja = null;
    $("#terminiTreninga").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#terminiTreninga tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja);
        }
        selektovanRed = this.dataset.id;
        staraBoja = $(this).css('background-color');

        $(this).css('background-color', '#a6c9e2');
        console.log("Selektovan red ", selektovanRed);
    });

    $("#obrisi").click(function() {
        var trener = selektovanRed;
        var obj = JSON.stringify({
            "idKorisnika" : trener
        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/trener/brisanje",
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