<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="mdl-grid">
    <div class="mdl-cell mdl-cell--12-col">
        <form action="${pageContext.request.contextPath}/" method="POST">
            <input type="hidden" value="registerUserSave" name="commandName" />
            <div class="mdl-grid">
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" id="_user.firstName" name="user.firstName">
                        <label class="mdl-textfield__label" for="_user.firstName">First name</label>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" id="_user.lastName" name="user.lastName">
                        <label class="mdl-textfield__label" for="_user.lastName">Last name</label>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" id="_user.email" name="user.email">
                        <label class="mdl-textfield__label" for="_user.email">Email</label>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" id="_user.login" name="user.login">
                        <label class="mdl-textfield__label" for="_user.login">Login</label>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="password" id="_user.password" name="user.password">
                        <label class="mdl-textfield__label" for="_user.password">password</label>
                    </div>
                </div>
                <div class="mdl-cell mdl-cell--12-col">
                    <input class="mdl-button mdl-js-button mdl-button--raised" type="submit" value="Save" />
                </div>
            </div>
        <form>
    </div>
</div>