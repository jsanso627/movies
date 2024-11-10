package org.example.helloweb.controler.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DispatcherServlet", urlPatterns = "/*")
public class DispatcherServlet extends HttpServlet {

}
