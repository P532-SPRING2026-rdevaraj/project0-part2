package edu.iu.habahram.ducksservice.controllers;

import edu.iu.habahram.ducksservice.model.DuckData;
import edu.iu.habahram.ducksservice.repository.DuckRepository;
import org.springframework.web.bind.annotation.*;

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
}