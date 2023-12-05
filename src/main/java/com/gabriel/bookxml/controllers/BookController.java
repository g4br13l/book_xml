package com.gabriel.bookxml.controllers;

import com.gabriel.bookxml.dtos.BookDto;
import com.gabriel.bookxml.entities.BookEntity;
import com.gabriel.bookxml.entities.ChapterEntity;
import com.gabriel.bookxml.models.BookXmlModel;
import com.gabriel.bookxml.repositories.BookRepo;
import com.gabriel.bookxml.repositories.ChapterRepo;
import jakarta.validation.Valid;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    ChapterRepo chapterRepo;

    @Autowired
    private ModelMapper modelMapper;




    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookDto book) {

        List<ChapterEntity> chapters = chapterRepo.findAllById(book.ChapterIds());

        if (chapters.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Characters of book not found.");
        }

        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(book, bookEntity);
        bookEntity.setChapters(chapters);

        return ResponseEntity.status(HttpStatus.CREATED).body( bookRepo.save(bookEntity) );
    }



    @GetMapping(value = "/books_json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllBooksJson() {

        List<BookEntity> book = bookRepo.findAll();

        if(book.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books were found.");
        else return ResponseEntity.status(HttpStatus.OK).body(book);
    }


    @GetMapping(value = "/books_json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBookJsonById(@PathVariable(value="id") UUID id) {

        Optional<BookEntity> book = bookRepo.findById(id);

        if(book.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        else return ResponseEntity.status(HttpStatus.OK).body(book.get());
    }



    @GetMapping(value = "/books_xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAllBooksXml() {

        return getAllBooksJson();
    }



    @GetMapping(value = "/books_xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getBookXmlById(@PathVariable(value="id") UUID id) {

        return getBookJsonById(id);
    }




    @GetMapping(value = "/save_books_xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> saveAllBooksXml(@PathVariable(value="id") UUID id) {

        Optional<BookEntity> book = bookRepo.findById(id);
        if (book.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");

        BookEntity bookEntity = book.get();
        BookXmlModel bookXml = modelMapper.map(bookEntity, BookXmlModel.class);
        Boolean xmlSaved = saveBookXml(bookXml);

        if (xmlSaved) return ResponseEntity.status(HttpStatus.OK).body(bookEntity);
        else return ResponseEntity.status(HttpStatus.OK).body("Impossible to save your XML document.");
    }



    public Boolean saveBookXml(BookXmlModel bookXml) {

        try {
            JAXBContext context = JAXBContext.newInstance(BookXmlModel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Date actualDate = new Date();
            String date = new SimpleDateFormat("dd-MM-yy").format(actualDate);
            String hour = new SimpleDateFormat("HH-mm-ss").format(actualDate);
            String iniPath = ".\\src\\main\\java\\com\\gabriel\\bookxml\\xml\\exports\\";
            String path = iniPath + bookXml.getName() +"_"+ date +"_"+ hour +".xml";

            marshaller.marshal(bookXml, new File(path));
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}








