package com.libary.controllers;

import com.libary.model.Libary;
import com.libary.repository.LibaryRepository;
import com.libary.service.LibaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/libary")
@Api("Api Rest De Biblioteca")
@CrossOrigin("*")
public class LibaryController {

    @Autowired
    private LibaryService libaryService;

    @Autowired
    private LibaryRepository libaryRepository;

    @GetMapping("/")
    @ApiOperation("Retorna Uma Lista De Livros.")
    public List<Libary> listBooks() {
        return this.libaryRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna Um Livro.")
    public Libary listBook(@PathVariable("id") Long id) {
        return this.libaryRepository.findById(id).get();
    }


    @PutMapping("/{id}")
    @ApiOperation("Atualiza Um Livro.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Libary updateBook(@PathVariable("id") Long id, @RequestBody Libary libary) {
        return this.libaryService.updateBookById(id, libary);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta Um Livro.")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> deleteBook(@PathVariable("id") Long id) {
        this.libaryRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Libary addBook(@RequestBody Libary libary) {
        return this.libaryRepository.save(libary);
    }
}
