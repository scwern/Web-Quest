package com.javarush.alisov.webquest.service;
import com.javarush.alisov.webquest.entity.Question;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

class GameServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    private GameServlet gameServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameServlet = new GameServlet();
        when(request.getSession()).thenReturn(session);

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    }

    @Test
    void testDoGet() throws Exception {
        when(session.getAttribute("gameCounter")).thenReturn(null);
        when(request.getParameter("answerid")).thenReturn("1");

        gameServlet.doGet(request, response);

        verify(request).setAttribute(eq("question"), any(Question.class));
        verify(session).setAttribute(eq("gameCounter"), eq(1));
    }

    @Test
    void testDoPost() throws Exception {
        when(session.getAttribute("gameCounter")).thenReturn(null);
        when(request.getParameter("answerid")).thenReturn("1");

        gameServlet.doPost(request, response);

        verify(request).setAttribute(eq("question"), any(Question.class));
        verify(session).setAttribute(eq("gameCounter"), eq(1));
    }
}
