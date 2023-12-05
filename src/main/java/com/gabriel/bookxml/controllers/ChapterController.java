package com.gabriel.bookxml.controllers;

import com.gabriel.bookxml.entities.BookEntity;
import com.gabriel.bookxml.entities.ChapterEntity;
import com.gabriel.bookxml.repositories.ChapterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChapterController {

    @Autowired
    ChapterRepo chapterRepo;



    @PostMapping("/chapters")
    public ResponseEntity<ChapterEntity> addChapter(@RequestBody ChapterEntity chapter) {

        ChapterEntity chapterEntity = chapterRepo.save(chapter);

        return ResponseEntity.status(HttpStatus.CREATED).body(chapterEntity);
    }

    @GetMapping(value = "/chapters_json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllChaptersJson() {

        List<ChapterEntity> chapter = chapterRepo.findAll();

        if(chapter.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books were found.");
        else return ResponseEntity.status(HttpStatus.OK).body(chapter);
    }


}
