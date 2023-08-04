<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
        <title>Maintenance management system</title>
        <link rel="stylesheet" href="static/style/material.min.css">
        <link rel="stylesheet" href="static/style/material-icons.css">
        <script defer src="static/style/material.min.js"></script>
</head>
<body>

    <div>
        <!-- Uses a header that contracts as the page scrolls down. -->
    <style>
        .demo-layout-waterfall .mdl-layout__header-row .mdl-navigation__link:last-of-type  {
          padding-right: 0;
        }
        </style>

        <div class="demo-layout-waterfall mdl-layout mdl-js-layout">
          <header class="mdl-layout__header mdl-layout__header--waterfall">
            <!-- Top row, always visible -->
            <div class="mdl-layout__header-row">
              <!-- Title -->
              <span class="mdl-layout-title">Maintenance management system</span>
              <div class="mdl-layout-spacer"></div>
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                          mdl-textfield--floating-label mdl-textfield--align-right">
                <label class="mdl-button mdl-js-button mdl-button--icon"
                       for="waterfall-exp">
                  <i class="material-icons">search</i>
                </label>
                <div class="mdl-textfield__expandable-holder">
                  <input class="mdl-textfield__input" type="text" name="sample"
                         id="waterfall-exp">
                </div>
              </div>
            </div>
            <!-- Bottom row, not visible on scroll -->
            <div class="mdl-layout__header-row">
              <div class="mdl-layout-spacer"></div>
              <!-- Navigation -->
              <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="">Registration</a>
                <a class="mdl-navigation__link" href="">View all users</a>
              </nav>
            </div>
          </header>
          <div class="mdl-layout__drawer">
            <span class="mdl-layout-title">Title</span>
            <nav class="mdl-navigation">
              <a class="mdl-navigation__link" href="">Registration</a>
              <a class="mdl-navigation__link" href="">View all users</a>
            </nav>
          </div>

          <main class="mdl-layout__content">
            <div class="page-content"><!-- Your content goes here -->
                <div class="mdl-grid">
                        <div class="mdl-cell mdl-cell--4-col">
                        </div>
                        <div class="mdl-cell mdl-cell--4-col">
                            <h2>Спасибо за регистрацию!</h2>
                            <h3>Ваши введённые данные:</h3>
                            <p><strong>Имя:</strong> ${firstname}</p>
                            <p><strong>Фамилия:</strong> ${lastname}</p>
                            <p><strong>Email: </strong>${email}</p>
                            <p><strong>Phone number:</strong> ${telephone}</p>
                        </div>
                        <div class="mdl-cell mdl-cell--4-col"></div>
                      </div>
                </div>
          </main>

          <footer class="mdl-mini-footer">
                <div class="mdl-mini-footer__left-section">
                  <div class="mdl-logo">Title</div>
                  <ul class="mdl-mini-footer__link-list">
                    <li><a href="#">Help</a></li>
                    <li><a href="#">Privacy & Terms</a></li>
                  </ul>
                </div>
              </footer>

        </div>
    </div>
</body>
</html>