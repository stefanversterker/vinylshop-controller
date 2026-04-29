package nl.novi.vinylshop.services;

import nl.novi.vinylshop.entities.Genre;
import nl.novi.vinylshop.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre findGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre met ID " + id + " niet gevonden"));
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long id, Genre genreInput){
        Genre existing = findGenreById(id);

        existing.setName(genreInput.getName());
        existing.setDescription(genreInput.getDescription());

        return genreRepository.save(existing);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

}
