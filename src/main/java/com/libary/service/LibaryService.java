package com.libary.service;


import com.libary.model.Libary;
import com.libary.repository.LibaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class LibaryService {

    @Autowired
    LibaryRepository rep;

    public Libary updateBookById(Long id, Libary libary) {
        Libary libaryFind = this.rep.findById(id).get();
        libaryFind.setNome(libary.getNome());
        libaryFind.setAutor(libary.getAutor());
        libaryFind.setPreco(libary.getPreco());
        libaryFind.setQuantidade(libary.getQuantidade());
        this.rep.save(libaryFind);
        return libaryFind;
    }
}
