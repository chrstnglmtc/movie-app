package movie.movie.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import movie.movie.Entity.Movie;
import movie.movie.Service.MovieService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
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

    @PostMapping("/uploadPoster")
    public ResponseEntity<String> uploadPoster(
            @RequestParam("id") int id,
            @RequestPart("file") MultipartFile file
    ) {
        try {
            // Check if the file size exceeds the allowed limit (e.g., 5 MB)
            long maxFileSize = 5 * 1024 * 1024; // 5 MB in bytes
            if (file.getSize() > maxFileSize) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File size exceeds the allowed limit");
            }
    
            // Retrieve the movie by movieId
            Movie movie = movieService.getMovieById(id);
    
            if (movie != null) {
                // Save the poster
                movie.setPoster(file.getBytes());
                movieService.saveOrUpdate(movie);
    
                // Log the poster data (You may want to save this to a database or other storage)
                System.out.println("Poster Data: " + Arrays.toString(movie.getPoster()));
    
                return ResponseEntity.ok("Poster uploaded successfully");
            } else {
                // Handle the case where the movie is not found
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            // Handle IOException (e.g., failed to read poster bytes)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload poster");
        }                                     
    }
    
}
