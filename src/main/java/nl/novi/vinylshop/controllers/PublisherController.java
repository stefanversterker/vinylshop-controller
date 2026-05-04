package nl.novi.vinylshop.controllers;

import nl.novi.vinylshop.entities.Publisher;
import nl.novi.vinylshop.services.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> publisher_by_id(@RequestParam("id") Long id) {
        Publisher publisher = publisherService.findPublisherById(id);
        return ResponseEntity.ok(publisher);
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> all_publishers() {
        List<Publisher> allPublishers = publisherService.findAllPublishers();
        return ResponseEntity.ok(allPublishers);
    }

    @PostMapping
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher){
        Publisher createdPublisher = publisherService.createPublisher(publisher);
        return ResponseEntity.status(201).body(createdPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisherInput) {
        Publisher updatedPublisher = publisherService.updatePublisher(id, publisherInput);
        return ResponseEntity.ok(updatedPublisher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}
