package edu.iu.habahram.ducksservice.controllers;

import edu.iu.habahram.ducksservice.model.DuckData;
import edu.iu.habahram.ducksservice.repository.DuckRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ducks")
public class DuckController {

    private final DuckRepository duckRepository;

    public DuckController(DuckRepository duckRepository) {
        this.duckRepository = duckRepository;
    }

    @GetMapping
    public List<DuckData> getAllDucks() {
        return duckRepository.findAll();
    }

    @PostMapping
    public DuckData addDuck(@RequestBody DuckData duck) {
        return duckRepository.save(duck);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<String> uploadImage(@PathVariable Long id,
                                              @RequestParam("file") MultipartFile file) throws IOException {
        DuckData duck = duckRepository.findById(id).orElseThrow();
        duck.setImage(file.getBytes());
        duck.setImageContentType(file.getContentType());
        duckRepository.save(duck);
        return ResponseEntity.ok("Image uploaded successfully");
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        DuckData duck = duckRepository.findById(id).orElseThrow();

        byte[] image = duck.getImage();
        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        String contentType = duck.getImageContentType();
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(image);
    }
}