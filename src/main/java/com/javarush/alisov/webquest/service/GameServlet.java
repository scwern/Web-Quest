package com.javarush.alisov.webquest.service;

import com.javarush.alisov.webquest.entity.Answer;
import com.javarush.alisov.webquest.entity.Question;
import com.javarush.alisov.webquest.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "GameServlet", value = "/game-servlet")
public class GameServlet extends HttpServlet {

    private final Repository repository = new Repository();
    //private int gameCounter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        Integer gameCounter = (Integer) session.getAttribute("gameCounter");
        if (gameCounter == null) {
            gameCounter = 0;
        }

        String answerId = request.getParameter("answerid");
        Question question;
        if (answerId != null) {
            question = repository.getAnswerById(Integer.parseInt(answerId)).getNext();
            if ("WIN".equalsIgnoreCase(String.valueOf(question.getType())) || "LOSE".equalsIgnoreCase(String.valueOf(question.getType()))) {
                gameCounter++;
            }
        } else {
            question = repository.getQuestionById(0);
        }
        Collection<Answer> answers = repository.getAnswersFromQuestionId(question.getId());
        request.setAttribute("question", question);
        request.setAttribute("answers", answers);
        session.setAttribute("gameCounter", gameCounter);
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
