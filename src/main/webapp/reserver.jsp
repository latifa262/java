<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestion des salles</title>
    
    <script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="script/reserv.js" type="text/javascript"></script>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.reservation"%>
<%@page import="service.ReservationService"%>
<%@page import="controller.ReservationController"%>
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
          
     <div class="content" style="float:left; margin: 200px; display: block;margin-top: 100px; background-color:#cce6ff;">
  
            <div class="card-body">
           <h4 class="card-title">Reservation</h4>
                               <div class="table-responsive" style="margin-bottom: 10px;">
           
                <table border="0" >
                    <tr>
                    <label for="exampleInputName1">nom</label> 
                          <select  class="form-control" id="nom" name="nom">
											<%
											String login2 = "root";
											String password2 = "";
											String driver2 = "com.mysql.cj.jdbc.Driver";
											String url2 = "jdbc:mysql://localhost/prjweb";
											Class.forName(driver2);
											String sql2 = "select id,nom from client";
											Connection cn2 = DriverManager.getConnection(url2, login2, password2);
											PreparedStatement ps2 = cn2.prepareStatement(sql2);
											ResultSet rs2 = ps2.executeQuery();
											while (rs2.next() == true) {
											%>
											<option value="<%=rs2.getInt(1)%>"><%=rs2.getString(2)%>
											</option>
											<%
											}
											%>
										</select>
										</tr>
										<tr>
                    <label for="exampleInputName1">Numéro de salle</label> 
                    <select class="form-control" id="code" name="code">
											<%
											String login = "root";
											String password = "";
											String driver = "com.mysql.cj.jdbc.Driver";
											String url = "jdbc:mysql://localhost/prjweb";
											Class.forName(driver);
											String sql = "select id,code from salle";
											Connection cn = DriverManager.getConnection(url, login, password);
											PreparedStatement ps = cn.prepareStatement(sql);
											ResultSet rs = ps.executeQuery();
											while (rs.next() == true) {
											%>
											<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%>
											</option>
											<%
											}
											%>
										</select>
										</tr>
										
										<tr>
										<label for="exampleInputName2">heure deb </label> 
										<select class="form-control" id="heureDeb" name="heureDeb">
											<%
											String login1 = "root";
											String password1 = "";
											String driver1 = "com.mysql.cj.jdbc.Driver";
											String url1 = "jdbc:mysql://localhost/prjweb";
											Class.forName(driver1);
											String sql1 = "select id,heureDeb from crenau";
											Connection cn1 = DriverManager.getConnection(url1, login1, password1);
											PreparedStatement ps1 = cn1.prepareStatement(sql1);
											ResultSet rs1 = ps1.executeQuery();
											while (rs1.next() == true) {
											%>
											<option value="<%=rs1.getInt(1)%>"><%=rs1.getTime(2)%>
											</option>
											<%
											}
											%>
										</select>
										</tr>
						<tr>
                       <label >Heure Fin </label> 
                      
                        <td><input  style="margin-left: 100px;" id="heureFin" type="time" name="heureFin" value="" required="" /></td>
                         </tr>
										
					<tr>
                       <td >date </td> 
                        <td><input id="date" type="date" name="date" value="" required="" /></td> 
                    </tr>
                    <tr>
                        
                        <td>
                            <input style="margin-left: 40px; margin-top: 30px;" class="btn btn-secondary btn-rounded btn-fw" id="add" type="submit" value="Envoyer" />
                            
                        </td>
                    </tr>
                </table>
                <div style="margin-top: 50px;">
                <fieldset>

                <table border="1" class="tab">
                    <thead style="padding: 30px;">
                        <tr>
                            <th>Id</th>
                            <th>nom </th>
                            <th>code</th>
                            <th>heureDeb</th>
                             <th>heureFin</th>
                              <th>date</th>
                              <th>status</th>
                        </tr>
                    </thead>
                    <tbody id="content">

                    </tbody>
                </table>

            </fieldset>
            </div>
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
