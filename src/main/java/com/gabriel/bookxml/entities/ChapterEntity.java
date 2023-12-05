package com.gabriel.bookxml.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_CHAPTER")
public class ChapterEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID chapter_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @Nullable
    @JsonBackReference
    @JacksonXmlProperty(localName = "book")
    private BookEntity book;

    /*@OneToMany(mappedBy = "chapter", fetch = FetchType.EAGER)
    @Nullable
    @JsonManagedReference
    @JacksonXmlElementWrapper(localName = "pages")
    @JacksonXmlProperty(localName = "page")
    private List<PageEntity> pages;*/

    @Column(nullable = false)
    @NotNull
    private String title;

    @Column
    @NotNull
    private String text;

}
