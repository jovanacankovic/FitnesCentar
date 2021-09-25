$(document).ready(function(){

    $("#addTrenerForm").submit(function(event) {

        event.preventDefault();
        var korisnickoIme = $("#korisnickoIme").val();
        var lozinka = $("#lozinka").val();
        var ime = $("#ime").val();
        var prezime = $("#prezime").val();
        var telefon = $("#telefon").val();
        var email = $("#email").val();
        var datumRodjenja = $("#datumRodjenja").val();

        var obj = JSON.stringify({
            "korisnickoIme": korisnickoIme,
            "lozinka": lozinka,
            "ime": ime,
            "prezime": prezime,
            "telefon": telefon,
            "email": email,
            "datumRodjenja": datumRodjenja
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/registrujTrenera",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                //alert(obj);
                alert("Vas zahtev za registraciju je poslat adminu na odobrenje.");
                window.location.href = "index.html";

            },
            error: function (data) {
                alert("Da li se poruka prenela?");
            }
        });

     

        let selektovanRed = 0;
        let staraBoja = null;
        $("#zahteviZaRegistracijuTrenera").on('click', 'tr:not(:first-child)', function () {
            if (staraBoja != null) {
                $('#zahteviZaRegistracijuTrenera tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
            }
            selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
            staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

            $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
            console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
        });

        $("#odobri").click(function () {
            var obj = JSON.stringify({
                "idKorisnika": selektovanRed
            });
            $.ajax({
                type: "POST",
                url: "http://localhost:8181/api/korisnik/registrujTrenera",
                dataType: "json",
                contentType: "application/json",
                data: obj,
                success: function (data) {
                    console.log("SUCCESS : ", data);

                },
                error: function (data) {
                    alert("Greška!");
                    console.log("ERROR : ", data);
                }
            });
        });

});
});










/* $(document).ready(function() {

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/korisnik/registrujTrenera",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function () {
            alert(obj);
            window.location.href = "pregledZahtevaZaRegTrenera.html";
        },
        error: function (data) {
            alert("Greska");
        }
    });


    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/korisnik/zahteviZaRegistraciju",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);
            for (let trener of response) {
                let row = "<tr>";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.telefon + "</td>";
                row += "</tr>";

                $('#zahtevi').append(row);
            }
        },
        error: function (response) {
        }
    });
});

 */