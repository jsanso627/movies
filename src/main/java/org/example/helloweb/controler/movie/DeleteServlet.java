package org.example.helloweb.controler.movie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.helloweb.dao.MovieDao;
import org.example.helloweb.dao.MovieDaoJdbcImpl;

import java.io.IOException;

@WebServlet(name = "deleteServlet", value = "/movies/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));

        MovieDao movieDao = new MovieDaoJdbcImpl();
        movieDao.delete(id);

        response.sendRedirect("/helloweb/movies");
    }
}
