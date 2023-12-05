package com.gabriel.bookxml.repositories;

import com.gabriel.bookxml.entities.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;




public interface ChapterRepo extends JpaRepository<ChapterEntity, UUID> { }
