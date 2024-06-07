<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link type="image/x-icon" href="img/favicon.ico" rel="shortcut icon">
    <link type="Image/x-icon" href="img/favicon.ico" rel="icon">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<h4>Количество игр : ${sessionScope.gameCounter} </h4>
<a href="index.jsp">Вернуться на главную страницу</a>
<section>
    <c:choose>
        <c:when test="${empty question}">
            <div class="container-fluid d-flex justify-content-center align-items-center" style="height: 75vh;">
                <h3 class="text-center">
                    В мире, где технологии слились с повседневной жизнью,<br>
                    загадочные сети начали угрожать людям,<br>
                    запутывая их в своих цифровых паутинах.<br>
                    Однажды утром вы обнаружили,<br>
                    что Ваш чип посетил Искусственный Интеллект<br>
                    из черного заслона.<br>
                    Ваши решения определят исход этой встречи.<br><br>
                    <a href="game-servlet?start=true" class="btn btn btn-success btn-lg">Начать игру</a></h3>
            </div>
        </c:when>
        <c:otherwise>
            <div class="container-fluid d-flex flex-column justify-content-center align-items-center" style="height: 75vh;">
                <h3 class="text-center">${question.text}</h3>

                <form action="${question.type == 'LOSE' || question.type == 'WIN' ? 'start-servlet' : 'game-servlet'}" method="get" style="margin-top: 30px;">
                    <div class="text-center" style="font-size: 1.2em;">
                        <c:forEach items="${answers}" var="answer">
                            <jsp:useBean id="answer" type="com.javarush.alisov.webquest.entity.Answer"/>
                            <input type="radio" name="answerid" value="${answer.id}">${answer.answerText}<br>
                        </c:forEach>
                    </div>
                    <div class="text-center" style="margin-top: 30px;">
                        <button type="submit" class="btn btn-success btn-lg" >${question.type == 'LOSE' || question.type == 'WIN' ? 'Сыграть еще' : 'Ответить'}</button>
                    </div>
                </form>
            </div>
        </c:otherwise>
    </c:choose>
</section>

</body>
</html>