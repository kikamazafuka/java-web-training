<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/nav" %>
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
                <span class="mdl-layout-title">Title</span>
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
            <span class="mdl-layout-title">Title</span>
            <nav:nav-links />
        </div>
        <main class="mdl-layout__content">
            <div class="page-content">
                <div class="mdl-grid">
                    <div class="mdl-cell mdl-cell--2-col">
                    </div>
                    <div class="mdl-cell mdl-cell--8-col">
                        <c:choose>
                            <c:when test="${not empty viewName}">
                                <jsp:include page="views/${viewName}.jsp" />
                            </c:when>
                            <c:otherwise>
                                <div class="mdl-grid">
                                    <div class="mdl-cell mdl-cell--12-col">
                                        Go to command
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="mdl-cell mdl-cell--2-col">
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>

</html>