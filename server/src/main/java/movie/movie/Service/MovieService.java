package movie.movie.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.movie.Entity.Movie;
import movie.movie.Repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).get();
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        movieRepository.findAll().forEach(movie -> movies.add(movie));
        return movies;
    }

    public void saveOrUpdate(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovieById(int id) {
        movieRepository.deleteById(id);
    }
}
