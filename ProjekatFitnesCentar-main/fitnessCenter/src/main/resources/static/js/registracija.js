$(document).ready(function(){

    $("#addKorisnikForm").submit(function(event) {

        event.preventDefault();
        var korisnickoIme = $("#korisnickoIme").val();
        var lozinka = $("#lozinka").val();
        var ime = $("#ime").val();
        var prezime = $("#prezime").val();
        var telefon = $("#telefon").val();
        var email = $("#email").val();
        var datumRodjenja = $("#datumRodjenja").val();
        var aktivan = true;
        var da_li_je_registrovan = true;
        var obj = JSON.stringify({
            "korisnickoIme" : korisnickoIme,
            "lozinka" : lozinka,
            "ime" : ime,
            "prezime" : prezime,
            "telefon" : telefon,
            "email" : email,
            "datumRodjenja" : datumRodjenja,
            "uloga" : 2,
            "aktivan" : aktivan,
            "da_li_je_registrovan" : da_li_je_registrovan,
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/registrujClana",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                alert(obj);
                window.location.href = "index.html";
            },
            error: function (data) {
                alert("Da li se poruka prenela?");
                alert(data);
                alert("Izgleda da jeste");
            }
        });

/*
    });
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/korisnik/zahteviZaRegistracijuClana",
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

                $('#zahteviZaRegistracijuClana').append(row);
            }
        },
        error: function (response) {
        } */
    });


});