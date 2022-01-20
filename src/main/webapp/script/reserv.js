let id = 0;
$(document).ready(function () {
    $.ajax({
        url: "ReservationController",
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
	    var nom = $("#nom").val();
    	var code = $("#code").val();
        var heureDeb = $("#heureDeb").val();
    	var date = $("#date").val();
        console.log(heureDeb);
        
            $.ajax({
                url: "ReservationController",
                data: {nom:nom,code:code,heureDeb:heureDeb,date:date},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
       
            

    });
    $("#content").on("click", ".delete", function () {
        //alert($(this).attr('val'));
        var id = $(this).closest('tr').find('td').eq(0).text();
        $.ajax({
            url: "ReservationController",
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
        var statut = $(this).closest('tr').find('td').eq(6).text();
       
         $("#statut").val(statut);

//console.log(date);
     

    });
    
function remplir(data) 
{ var ligne = ""; 
for (var i = 0; i < data.length; i++) { 
ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].nom+"</td><td>" + data[i].code +  "</td><td>" + data[i].heureDeb + "</td><td>" + data[i].heureFin + "</td><td>" + data[i].date +"</td><td>" + data[i].status + "</td></tr>"; } 
$("#content").html(ligne); 
}


});