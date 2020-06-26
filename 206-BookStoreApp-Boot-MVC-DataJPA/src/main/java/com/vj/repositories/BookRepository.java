package com.vj.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Serializable> {

}
