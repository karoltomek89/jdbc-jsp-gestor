<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="r" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<%@ page %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>

<div class="row">
    <div class="col-1">
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link" id="v-pills-parent-tab" href="${pageContext.request.contextPath}/parent"
               role="tab"
               aria-controls="v-pills-parent" aria-selected="false">Info</a>
            <a class="nav-link" id="v-pills-grades-tab" data-toggle="pill" href="#v-pills-grades" role="tab"
               aria-controls="v-pills-grades" aria-selected="false">Oceny dzieci</a>
            <a class="nav-link" id="v-pills-notes-tab" data-toggle="pill" href="#v-pills-notes" role="tab"
               aria-controls="v-pills-notes" aria-selected="false">Uwagi dzieci</a>
            <a class="nav-link  active" id="v-pills-messages-tab" href="${pageContext.request.contextPath}/messages"
               role="tab"
               aria-controls="v-pills-messages" aria-selected="true">Wiadomości</a>
            <a class="nav-link" id="v-pills-logout-tab" href="${pageContext.request.contextPath}/logout" role="tab"
               aria-controls="v-pills-logout" aria-selected="false">Wyloguj</a>
        </div>
    </div>

    <div class="col-11">

        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade" id="v-pills-grades" role="tabpanel" aria-labelledby="v-pills-grades-tab">
                Tutaj będą prezentowane uzyskane przez dzieci oceny
            </div>
            <div class="tab-pane fade" id="v-pills-notes" role="tabpanel" aria-labelledby="v-pills-notes-tab">
                Tutaj będą prezetowane uwagi dla dzieci od nauczycieli
            </div>
            <div class="tab-pane fade show active" id="v-pills-messages" role="tabpanel"
                 aria-labelledby="v-pills-messages-tab">

                <c:forEach var="item" items="${messagesList}">

                    <p>
                        <button class="btn btn-primary" type="button">
                            Nadawca: ${item.from}
                        </button>

                        <button class="btn btn-primary" type="button">
                            Temat: ${item.topic}
                        </button>

                        <button class="btn btn-primary" type="button" data-toggle="collapse"
                                data-target="#collapse${item.id}" aria-expanded="false" aria-controls="collapse">
                            Pokaz wiadomość
                        </button>

                    <FORM id="deleteMessage" method="POST" action="${pageContext.request.contextPath}/deleteMessage">
                        <INPUT TYPE="hidden" NAME="messageId" VALUE="${item.id}">
                    </FORM>

                    <button type="submit" form="deleteMessage" class="btn btn-primary">Usuń wiadomość</button>

                    </p>
                    <div class="collapse" id="collapse${item.id}">
                        <div class="card card-body">
                                ${item.text}
                        </div>
                    </div>

                </c:forEach>

            </div>

        </div>
    </div>
</div>