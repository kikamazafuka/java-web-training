<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/nav" %>
<%@ page errorPage = "error.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <title>Maintenance management system</title>
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
                        <c:if test="${violations != null}">
                            <c:forEach items="${violations}" var="violation">
                                 <p style="color:Red">${violation}.</p>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mdl-cell mdl-cell--4-col">.

                        <c:choose>
                            <c:when test="${not empty viewName}">
                                <jsp:include page="views/${viewName}.jsp" />
                            </c:when>
                            <c:otherwise>
                                <div class="mdl-grid">
                                    <div class="mdl-cell mdl-cell--12-col">



                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="mdl-cell mdl-cell--2-col">
                     <form action="${pageContext.request.contextPath}/registrationUser" method="post">
                                            <div class="mdl-textfield mdl-js-textfield">
                                                    <label class="mdl-textfield__label" for="firstname">Firstname : </label>
                                                    <input class="mdl-textfield__input" type="text" name="firstname" id="firstname" value="${firstname}">
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield">
                                                        <label class="mdl-textfield__label" for="lastname">Lastname :</label>
                                                        <input class="mdl-textfield__input" type="text" name="lastname" id="lastname" value="${lastname}">
                                                    </div>
                                                <div class="mdl-textfield mdl-js-textfield">
                                                        <label class="mdl-textfield__label" for="email">Email: </label>
                                                        <input class="mdl-textfield__input" type="text" name="email" id="email" value="${email}">
                                                      </div>
                                                <div>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                    <label class="mdl-textfield__label" for="login">Login : </label>
                                                    <input class="mdl-textfield__input" type="text" name="login" id="login" value="${login}">
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield">
                                                        <label class="mdl-textfield__label" for="password">Password :</label>
                                                        <input class="mdl-textfield__input" type="password" name="password" id="password" value="${password}">
                                                    </div>
                                                <div class="mdl-textfield mdl-js-textfield">
                                                        <label class="mdl-textfield__label" for="telephone">Phone number: </label>
                                                        <input class="mdl-textfield__input" type="text" name="telephone" id="telephone" value="${telephone}">
                                                      </div>
                                                <div>
                                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
                                                       Confirm
                                                </button>
                                                </div>
                                            </form>
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