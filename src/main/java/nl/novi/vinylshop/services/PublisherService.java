package nl.novi.vinylshop.services;

import nl.novi.vinylshop.entities.Publisher;
import nl.novi.vinylshop.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher met ID " + id + " niet gevonden"));
    }

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long id, Publisher publisherInput) {
        Publisher existing = findPublisherById(id);

        existing.setName(publisherInput.getName());
        existing.setDescription(publisherInput.getDescription());

        return publisherRepository.save(existing);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
