package com.gabriel.bookxml.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gabriel.bookxml.entities.BookEntity;
import com.gabriel.bookxml.entities.ChapterEntity;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;



@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookXmlModel {

    private UUID book_id;

    private String name;

    private Integer pagesNumber;

    @JsonManagedReference
    @XmlElementWrapper(name = "chapters")
    @XmlElement(name = "chapter")
    private List<ChapterXmlModel> chapters;





    public BookXmlModel() { }

    public UUID getBook_id() {
        return this.book_id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPagesNumber() {
        return this.pagesNumber;
    }

    public List<ChapterXmlModel> getChapters() {
        return this.chapters;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPagesNumber(Integer pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public void setChapters(List<ChapterXmlModel> chapters) {
        this.chapters = chapters;
    }




    @Override
    public boolean equals(final Object obj) {

        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BookXmlModel bookXml = (BookXmlModel) obj;
        return bookXml.book_id == this.book_id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(book_id);
    }



    @Override
    public String toString() {
        return "BookXmlModel(" +
                    "book_id="          + this.getBook_id() +
                    ", name="           + this.getName() +
                    ", pagesNumber="    + this.getPagesNumber() +
                    ", chapters="       + "[]" +
                ")";
    }


    public BookXmlModel bookEntityToXml(BookEntity entity) {

        BookXmlModel bookXml = new BookXmlModel();
        bookXml.setBook_id( entity.getBook_id() );
        bookXml.setName( entity.getName() );
        bookXml.setPagesNumber(entity.getPagesNumber() );
        if (entity.getChapters() != null) {
            bookXml.setChapters( chaptersEntitiesToXml(entity.getChapters()) );
        }
        else {
            List<ChapterXmlModel> chapsXml = new ArrayList<>();
            bookXml.setChapters( chapsXml );
        }

        return bookXml;
    }



    public List<ChapterXmlModel> chaptersEntitiesToXml(List<ChapterEntity> chapters) {

        List<ChapterXmlModel> chaptersXml = new ArrayList<>();

        for(ChapterEntity chap :  chapters) {

            ChapterXmlModel chapXml = new ChapterXmlModel();
            chapXml.setChapter_id( chap.getChapter_id() );
            chapXml.setTitle( chap.getTitle() );
            chapXml.setText( chap.getText() );
            chapXml.setBook( new BookXmlModel() );
            chaptersXml.add(chapXml);
        }

        return chaptersXml;
    }


}















