<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <div class="text-center sidebar-brand-wrapper d-flex align-items-center">
          <a class="sidebar-brand brand-logo" href=""><img src="style/assets/images/logo.svg" alt="logo"></a>
          <a class="sidebar-brand brand-logo-mini pl-4 pt-3" href=""><img src="style/assets/images/logo-mini.svg" alt="logo"></a>
        </div>
        <ul class="nav">
          <li class="nav-item nav-profile">

              <div style="width: 500px;">
                
              </div>

          </li>
         
          <li class="nav-item" style="margin-top: 50px;">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="mdi mdi-crosshairs-gps menu-icon"></i>
              <span class="menu-title">Gestion</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item">
                  <a class="nav-link" href="salles.jsp">Salles</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="crenau.jsp">Crenau</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="client.jsp">Client</a>
                </li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="reserver.jsp">
              <i class="mdi mdi-contacts menu-icon"></i>
              <span class="menu-title">Reservation </span>
            </a>
          </li>
         
          <li class="nav-item">
            <a class="nav-link" href="chart.jsp">
              <i class="mdi mdi-chart-bar menu-icon"></i>
              <span class="menu-title">Statistique</span>
            </a>
          </li>
          
          <li class="nav-item">
            <span class="nav-link" href="#">
              <span class="menu-title">Docs</span>
            </span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="https://www.bootstrapdash.com/demo/breeze-free/documentation/documentation.html">
              <i class="mdi mdi-file-document-box menu-icon"></i>
              <span class="menu-title">Documentation</span>
            </a>
          </li>
          <li class="nav-item sidebar-actions">
            <div class="nav-link">
              <div class="mt-4">
                <div class="border-none">
                  <p class="text-black">Notification</p>
                </div>
                <ul class="mt-4 pl-0">
                  <li>Sign Out</li>
                </ul>
              </div>
            </div>
          </li>
        </ul>
      </nav>