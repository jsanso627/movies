package org.example.helloweb.controler.movie;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.helloweb.dao.MovieDao;
import org.example.helloweb.dao.MovieDaoJdbcImpl;
import org.example.helloweb.model.Movie;

@WebServlet(name = "moviesServlet", value = "/movies")
public class MoviesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MovieDao movieDao = new MovieDaoJdbcImpl();
        List<Movie> movies = movieDao.findAll();

        request.setAttribute("movies", movies);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);


    }
}