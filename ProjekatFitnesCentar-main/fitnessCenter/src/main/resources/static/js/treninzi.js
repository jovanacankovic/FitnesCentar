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


    /*
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/pregledTreninga",
        dataType: "json",
        success: function (response) {
            console.log("SUCCESS:\n", response);

            for (let trening of response) {
                let row = "<tr>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tip + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "</tr>";

                $('#pregledTreninga').append(row);
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);
        }
    });
}); */

$(document).on('click','#sortNaziv',function(){
    $.ajax({
        type:"GET",
        url:"http://localhost:8181/api/pregledTreninga/sortNaziv",
        dataType:"json",
        success:function(data){

            console.log("SUCCESS: ",data);
            $('#pregledTreninga td').remove();
            for(i=0;i<data.length;i++){
                var row="<tr>";
                row +="<td>" + data[i]['naziv'] + "</td>";
                row +="<td>" + data[i]['opis'] + "</td>";
                row +="<td>" + data[i]['tip'] +"</td>";
                row +="<td>" + data[i]['trajanje'] +"</td>";
                $('#pregledTreninga').append(row);
            }
        },
        error:function(data){
            console.log("ERROR: ",data);
        }

    });
});

$(document).on('click','#sortTipTreninga',function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/pregledTreninga/sortTipTreninga",
        dataType: "json",
        success: function (data) {

            console.log("SUCCESS: ", data);
            $('#pregledTreninga td').remove();
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tip'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                $('#pregledTreninga').append(row);
            }
        },
        error: function (data) {
            console.log("ERROR: ", data);
        }

    });

    $(document).on('click', '#sortTranjanje', function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:8181/api/pregledTreninga/sortTrajanje",
            dataType: "json",
            success: function (data) {

                console.log("SUCCESS: ", data);
                $('#pregledTreninga td').remove();
                for (i = 0; i < data.length; i++) {
                    var row = "<tr>";
                    row += "<td>" + data[i]['naziv'] + "</td>";
                    row += "<td>" + data[i]['opis'] + "</td>";
                    row += "<td>" + data[i]['tip'] + "</td>";
                    row += "<td>" + data[i]['trajanje'] + "</td>";
                    $('#pregledTreninga').append(row);
                }
            },
            error: function (data) {
                console.log("ERROR: ", data);
            }

        });


        $(document).on("submit", "naziv", function (event) {
            event.preventDefault();

            var naziv = $("#nazivTr").val();
            $.ajax({
                type: "GET",
                url: "http://localhost:8181/api/pregledTreninga/naziv/" + naziv,
                dataType: "json",
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    alert("Trazi se trening " + naziv);
                   // window.location.href = "pregledTreninga.html";
                    $('#pregledTreninga td').remove();
                    var row = "<tr>";
                    row += "<td>" + data['naziv'] + "</td>";
                    row += "<td>" + data['opis'] + "</td>";
                    row += "<td>" + data['tip'] + "</td>";
                    row += "<td>" + data['trajanje'] + "</td>";
                    $('#pregledTreninga').append(row);
                },
                error: function () {
                    alert("Greška!");
                }
            });
        });

        $(document).on("submit", "tipTreninga", function (event) {
            event.preventDefault();

            var tip = $("#tipTr").val();
            $.ajax({
                type: "GET",
                url: "http://localhost:8181/api/pregledTreninga/tipTreninga/" + tip,
                dataType: "json",
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    alert("Trazi se trening " + tip);
                    //window.location.href = "pregledTreninga.html";
                    $('#pregledTreninga td').remove();
                    var row = "<tr>";
                    row += "<td>" + data['naziv'] + "</td>";
                    row += "<td>" + data['opis'] + "</td>";
                    row += "<td>" + data['tip'] + "</td>";
                    row += "<td>" + data['trajanje'] + "</td>";
                    $('#pregledTreninga').append(row);
                },
                error: function () {
                    alert("Greška!");
                }
            });
        });
    });
});