let id = 0;
$(document).ready(function () {
    $.ajax({
        url: "CrenauController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });


    $("#add").click(function () {
        var heureDeb = $("#heureDeb").val();
        var heureFin = $("#heureFin").val();
        //alert("hello");
        if (id === 0)
        {
            $.ajax({
                url: "CrenauController",
                data: {heureDeb: heureDeb, heureFin: heureFin},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                    //alert("hello");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        } else
        {
            $.ajax({
                url: "CrenauController",
                data: {op: "update", id: id, heureDeb: heureDeb, heureFin: heureFin},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                    id = 0;
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        }

    });
    $("#content").on("click", ".delete", function () {
        //alert($(this).attr('val'));
        var id = $(this).closest('tr').find('td').eq(0).text();
        $.ajax({
            url: "CrenauController",
            data: {op: "delete", id: id},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                remplir(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });

    });
    $("#content").on("click", ".update", function () {
        //alert($(this).attr('val'));
          
         id = $(this).closest('tr').find('td').eq(0).text();
        var heureDeb = $(this).closest('tr').find('td').eq(1).text();
        var heureFin = $(this).closest('tr').find('td').eq(2).text();

        var date1 = new Time(heureDeb);
        var date2 = new Time(heureFin);
        
        var dd = date1.getHour();
        var mm = date1.getMinute() ; //January is 0!
        var yy = date1.getSecond();
        
         var dd = date2.getHour();
        var mm = date2.getMinute() ; //January is 0!
        //var yy = date2.getSecond();
        
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }
    /*if (yy < 10) {
        yy = '0' + yy;
    }*/
    
    date1 = dd + ':' + mm ;
    date2 = dd + ':' + mm ;

         $("#heureDeb").val(date1);
         $("#heureFin").val(date2);


console.log(date);
     

    });
    function remplir(data) {
        var ligne = "";
        //   var mod = "";
        for (var i = 0; i < data.length; i++) {
      //alert("hello");
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].heureDeb + "</td><td>" + data[i].heureFin +  "</td><td><button class='delete' val='" + data[i].id + "'>Supprimer</button>\n\
</td><td><button class='update' val='" + data[i].id + "' >Modifier</button></td></tr>";
        }
        $("#content").html(ligne);
    }


});
