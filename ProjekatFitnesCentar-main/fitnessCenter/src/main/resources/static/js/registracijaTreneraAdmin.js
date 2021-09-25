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
        var aktivan = 'true';
        var da_li_je_registrovan = 'true';
        var obj = JSON.stringify({
            "korisnickoIme" : korisnickoIme,
            "lozinka" : lozinka,
            "ime" : ime,
            "prezime" : prezime,
            "telefon" : telefon,
            "email" : email,
            "datumRodjenja" : datumRodjenja,
            "uloga" : 1,
            "aktivan" : aktivan,
            "da_li_je_registrovan" : da_li_je_registrovan,
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/registracijaTreneraAdmin",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                alert(obj);
                window.location.href = "home.html";
            },
            error: function (data) {
                alert(data);
            }
        });

    });



});