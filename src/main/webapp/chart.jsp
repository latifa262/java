<!DOCTYPE html>

<html>

<head> 
    <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>

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

<div style="display:inline; float:left; margin-top: 100px;text-align: center;">
<h4 class="card-title">les salle le plus reservees</h4>
<canvas id="MyChart" ></canvas>

</div>
<div style="display:inline; float:left; margin-top: 100px;text-align: center;">
<h4 class="card-title"> Reservation de l'annee derniere </h4>
<canvas id="Monthly"></canvas>


</div>
<script src="script/chart.js"></script>
<script src="chart.js/dist/Chart.min.js"></script>

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