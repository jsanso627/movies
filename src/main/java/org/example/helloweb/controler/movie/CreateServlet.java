package org.example.helloweb.controler.movie;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.example.helloweb.dao.MovieDao;
import org.example.helloweb.dao.MovieDaoJdbcImpl;
import org.example.helloweb.model.Movie;

@WebServlet(name = "createServlet", value = "/movies/create")
public class CreateServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/createMovie.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int year = Integer.parseInt(request.getParameter("year"));

        Movie movie = new Movie(0, title, description, year);

        MovieDao movieDao = new MovieDaoJdbcImpl();
        movieDao.create(movie);

        response.sendRedirect("/helloweb/movies");
    }
}
