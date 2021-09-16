package com.libary.controllers;

import com.libary.model.Libary;
import com.libary.repository.LibaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/")
public class LibaryController {

    @Autowired
    private LibaryRepository libaryRepository;

    @GetMapping("/")
    public List<Libary> listBooks() {
        return this.libaryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libary listBook(@PathParam("id") Long id) {
        return this.libaryRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Long> deleteBook(@PathParam("id") Long id) {
        this.libaryRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Libary addBook(@RequestBody Libary libary) {
        return this.libaryRepository.save(libary);
    }
}
