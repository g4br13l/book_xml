package com.gabriel.bookxml.repositories;

import com.gabriel.bookxml.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;



@Repository
public interface BookRepo extends JpaRepository<BookEntity, UUID> { }
