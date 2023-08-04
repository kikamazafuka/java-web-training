<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/nav" %>
<%@ page errorPage = "error.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all roles</title>
    <link rel="stylesheet" href="static/style/material.min.css">
    <link rel="stylesheet" href="static/style/material-icons.css">
    <script defer src="static/style/material.min.js"></script>
</head>

<body>

<div class="demo-layout-waterfall mdl-layout mdl-js-layout">
        <header class="mdl-layout__header mdl-layout__header--waterfall">
            <!-- Top row, always visible -->
            <div class="mdl-layout__header-row">
                <!-- Title -->
                <span class="mdl-layout-title">Maintenance management system</span>
                <div class="mdl-layout-spacer"></div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="waterfall-exp">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" type="text" name="sample" id="waterfall-exp">
                    </div>
                </div>
            </div>
            <!-- Bottom row, not visible on scroll -->
            <div class="mdl-layout__header-row">
                <div class="mdl-layout-spacer"></div>
                <nav:nav-links />
            </div>
        </header>
        <div class="mdl-layout__drawer">
            <span class="mdl-layout-title">Maintenance management system</span>
            <nav:nav-links />
        </div>
        <main class="mdl-layout__content">
            <div class="page-content">
                <div class="mdl-grid">
                    <div class="mdl-cell mdl-cell--2-col">

                    </div>
                    <div class="mdl-cell mdl-cell--4-col">.

<div class="mdl-grid">
    <div class="mdl-cell mdl-cell--4-col">
        <div>
            <!-- Wide card with share menu button -->
            <style>
            .demo-card-wide.mdl-card {
              width: 512px;
            }
            .demo-card-wide > .mdl-card__title {
              color: #fff;
              height: 176px;
              background: url('./img/computer_think_640.png') center / cover;
            }
            .demo-card-wide > .mdl-card__menu {
              color: #00f;
            }
            </style>

            <div class="demo-card-wide mdl-card mdl-shadow--2dp">
              <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Roles</h2>
              </div>
              <div class="mdl-card__supporting-text">
                    <table class="mdl-data-table mdl-js-data-table">
                      <thead>
                        <tr>
                          <th class="mdl-data-table__cell--non-numeric">Login</th>
                          <th class="mdl-data-table__cell--non-numeric">Password</th>
                        </tr>
                      </thead>
                      <tbody>
                            <c:forEach items="${users}" var="users">
                            <tr>
                              <td>${users.login}</td>
                              <td class="mdl-data-table__cell--non-numeric">${users.password}</td>
                            </tr>
                            </c:forEach>
                      </tbody>
                    </table>
              </div>
              <div class="mdl-card__actions mdl-card--border">
                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                  Get Started
                </a>
              </div>
              <div class="mdl-card__menu">
                <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                  <i class="material-icons">share</i>
                </button>
              </div>
            </div>
        </div>
    </div>
</div>



                    </div>
                    <div class="mdl-cell mdl-cell--2-col">

                    </div>
                </div>
            </div>
        </main>
              <footer class="mdl-mini-footer">
               <form action="${pageContext.request.contextPath}/viewAllRoles" method="get">
                                                <div>
                                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
                                                       View Roles
                                                </button>
                                                </div>
               </form>
                              <form action="${pageContext.request.contextPath}/viewAllUsers" method="get">
                                                               <div>
                                                               <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
                                                                      View Users
                                                               </button>
                                                               </div>
                              </form>
                    <div class="mdl-mini-footer__left-section">
                      <div class="mdl-logo">Title</div>
                      <ul class="mdl-mini-footer__link-list">
                        <li><a href="#">Help</a></li>
                        <li><a href="#">Privacy & Terms</a></li>
                      </ul>
                    </div>

                  </footer>
    </div>



</body>
</html>