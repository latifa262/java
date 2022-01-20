<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestion des crenaux</title>
    
        <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="script/crenaux.js" type="text/javascript"></script>
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" href="style/assets/vendors/mdi/css/materialdesignicons.min.css" />
    <link rel="stylesheet" href="style/assets/vendors/flag-icon-css/css/flag-icon.min.css" />
    <link rel="stylesheet" href="style/assets/vendors/css/vendor.bundle.base.css" />
    <link rel="stylesheet" href="style/assets/vendors/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="style/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css" />
    <link rel="stylesheet" href="style/assets/css/style.css" />
    <link rel="shortcut icon" href="style/assets/images/favicon.png" /> 
    
    
    </head>

    <body>
          <%@include file="WEB-INF/header.jsp" %>
 <div style="float:left;">  <%@include file="WEB-INF/menu.jsp" %>  </div>           
     <div class="content" style="float:left; margin: 300px; display: block;margin-top: 100px;background-color:#cce6ff;">

      <div class="card-body">
           <h4 class="card-title">Table des Crenaux</h4>
                    
                    <div class="table-responsive">
                      <table class="table">
                       <tr>
                        <td>Heure Debut</td>
                        <td><input id="heureDeb" type="time" name="heureDeb" value=""  required=""/></td>
                    </tr>
                    <tr>
                        <td>Heure Fin</td>
                        <td><input  id="heureFin" type="time" name="heureFin" value="" required="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input class="btn btn-secondary btn-rounded btn-fw" id="add" type="submit" value="Envoyer" />
                            
                        </td>
                    </tr>
                      </table>
     
     

            <fieldset>
                <legend>Liste des crenaux</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Heure Debut <br>
                            <th>Heure Fin</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody id="content">

                    </tbody>
                </table>

            </fieldset>
         </div>  
         </div>
         </div>
</body>
        <script src="style/assets/vendors/js/vendor.bundle.base.js"></script>
    
     <script src="style/assets/vendors/chart.js/Chart.min.js"></script>
    <script src="style/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
    <script src="style/assets/vendors/flot/jquery.flot.js"></script>
    <script src="style/assets/vendors/flot/jquery.flot.resize.js"></script>
    <script src="style/assets/vendors/flot/jquery.flot.categories.js"></script>
    <script src="style/assets/vendors/flot/jquery.flot.fillbetween.js"></script>
    <script src="style/assets/vendors/flot/jquery.flot.stack.js"></script>
    <script src="style/assets/vendors/flot/jquery.flot.pie.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="style/assets/js/off-canvas.js"></script>
    <script src="style/assets/js/hoverable-collapse.js"></script>
    <script src="style/assets/js/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="style/assets/js/dashboard.js"></script>
    
</html>
