package com.javarush.alisov.webquest.service;
import com.javarush.alisov.webquest.service.StartServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StartServletTest {

    @Test
    void testDoGet() throws IOException {
        StartServlet startServlet = new StartServlet();
        HttpServletResponse mockResponse = Mockito.mock(HttpServletResponse.class);

        startServlet.doGet(null, mockResponse);

        verify(mockResponse).sendRedirect("game.jsp");
    }
    @Test
    void testDoPost() throws IOException {
        StartServlet startServlet = new StartServlet();
        HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = Mockito.mock(HttpServletResponse.class);

        when(mockRequest.getContextPath()).thenReturn("/test");
        startServlet.doPost(mockRequest, mockResponse);

        verify(mockResponse).sendRedirect("/test/game-servlet");
    }
}