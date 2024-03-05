package movie.movie.Repository;

import org.springframework.data.repository.CrudRepository;

import movie.movie.Entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer>{
}
