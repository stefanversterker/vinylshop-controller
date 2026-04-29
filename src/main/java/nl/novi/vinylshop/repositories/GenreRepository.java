package nl.novi.vinylshop.repositories;

import nl.novi.vinylshop.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {

}
