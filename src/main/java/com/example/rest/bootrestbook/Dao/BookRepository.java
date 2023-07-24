package com.example.rest.bootrestbook.Dao;

import com.example.rest.bootrestbook.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{
    public Book findById(int id);
}
