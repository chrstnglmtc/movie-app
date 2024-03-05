package movie.movie.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movie.movie.Entity.Movie;
import movie.movie.Service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable("id") int id) {
        movieService.deleteMovieById(id);
    }

    @PostMapping("/movie")
    public void addMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
    }

    @PutMapping("/movie")
    public void updateMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie existingMovie = movieService.getMovieById(id);

        if (existingMovie != null) {
            // Update the existing movie with the new details
            existingMovie.setName(updatedMovie.getName());
            existingMovie.setDirector(updatedMovie.getDirector());
            existingMovie.setReview(updatedMovie.getReview());
            existingMovie.setRating(updatedMovie.getRating());

            movieService.saveOrUpdate(existingMovie);

            return ResponseEntity.ok("Movie updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie with ID " + id + " does not exist");
        }
    }
}
