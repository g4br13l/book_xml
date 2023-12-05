package com.gabriel.bookxml.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gabriel.bookxml.entities.ChapterEntity;
import jakarta.persistence.MappedSuperclass;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Objects;
import java.util.UUID;


@XmlRootElement(name = "chapter")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChapterXmlModel {

    private UUID chapter_id;

    @XmlTransient
    @JsonBackReference
    private BookXmlModel book;

    private String title;

    private String text;





    public ChapterXmlModel() { }


    public UUID getChapter_id() {
        return this.chapter_id;
    }

    public BookXmlModel getBook() {
        return this.book;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public void setChapter_id(UUID chapter_id) {
        this.chapter_id = chapter_id;
    }

    public void setBook(BookXmlModel book) {
        this.book = book;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }





    public boolean equals(final Object obj) {

        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ChapterXmlModel chapterXml = (ChapterXmlModel) obj;
        return chapterXml.chapter_id == this.chapter_id;
    }



    public int hashCode() {
        return Objects.hash(chapter_id);
    }

    public String toString() {
        return "ChapterXmlModel(" +
                    "chapter_id="   + this.getChapter_id() +
                    ", book="       + this.getBook() +
                    ", title="      + this.getTitle() +
                    ", text="       + this.getText() +
                ")";
    }
}
