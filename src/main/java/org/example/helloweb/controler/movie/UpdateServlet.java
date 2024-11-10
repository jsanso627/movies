package org.example.helloweb.controler.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.helloweb.dao.MovieDao;
import org.example.helloweb.dao.MovieDaoJdbcImpl;
import org.example.helloweb.model.Movie;

import java.io.IOException;

@WebServlet(name = "updateServlet", value = "/movies/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        MovieDao movieDao = new MovieDaoJdbcImpl();
        long id = Long.parseLong(request.getParameter("id"));
        Movie movie = movieDao.findById(id);
        if (movie!= null) {
            request.setAttribute("movie", movie);
            request.getRequestDispatcher("/updateMovie.jsp").forward(request, response);
        } else {
            response.sendRedirect("movies");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));

        response.setContentType("text/html");
        MovieDao movieDao = new MovieDaoJdbcImpl();

        Movie movie = movieDao.findById(id);
        if (movie != null) {
            movie.setTitle(request.getParameter("title"));
            movie.setDescription(request.getParameter("description"));
            movie.setYear(Integer.parseInt(request.getParameter("year")));
            movieDao.update(movie);
            response.sendRedirect(request.getContextPath() +"/movies");
        } else {
            response.sendRedirect(request.getContextPath() +"/movies");
        }
    }
}
