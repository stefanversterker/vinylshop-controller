package nl.novi.vinylshop.controllers;

import nl.novi.vinylshop.entities.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nl.novi.vinylshop.services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> genre_by_id(@RequestParam("id") Long id) {
        Genre genre = genreService.findGenreById(id);
        return ResponseEntity.ok(genre);
    }

    @GetMapping
    public ResponseEntity<List<Genre>> all_genres() {
        List<Genre> allGenres = genreService.findAllGenres();
        return ResponseEntity.ok(allGenres);
    }

    @PostMapping
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre){
        Genre createdGenre = genreService.createGenre(genre);
        return ResponseEntity.status(201).body(createdGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genreInput) {
        Genre updatedGenre = genreService.updateGenre(id, genreInput);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
