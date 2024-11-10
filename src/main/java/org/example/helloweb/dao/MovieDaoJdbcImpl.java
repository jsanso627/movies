package org.example.helloweb.dao;

import org.example.helloweb.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class MovieDaoJdbcImpl implements MovieDao {
    public MovieDaoJdbcImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Movie> findAll(){
        try {
            Connection connection = getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            Statement statement = connection.createStatement();
            String query = "select * from movies";
            ResultSet result = statement.executeQuery(query);

            List<Movie> movies = new ArrayList<>();
            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int year = result.getInt("year");

                Movie movie = new Movie(id,title,description,year);
                movies.add(movie);
            }
            return movies;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Movie findById(Long id){
        Movie movie = null;
        String query = "SELECT * FROM movies WHERE id = ?";

        try (Connection connection = getConnection("jdbc:mysql://db:3306/movies", "root", "root");
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                int year = resultSet.getInt("year");

                movie = new Movie(id, title, description, year);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movie;
    }

    @Override
    public void create(Movie movie) {
        try {
            Connection connection = getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO movies (title, description, year) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getYear());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();

            if (result.next()) {
                movie.setId(result.getLong(1));
            } else {
                throw new SQLException("No s'ha pogut afegir l'ID");
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try {
            Connection connection = getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM movies WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Movie movie) {
        try {
            Connection connection = getConnection("jdbc:mysql://db:3306/movies", "root", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE movies SET title = ?, description = ?, year = ? WHERE id = ?");
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getYear());
            preparedStatement.setLong(4, movie.getId());
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
