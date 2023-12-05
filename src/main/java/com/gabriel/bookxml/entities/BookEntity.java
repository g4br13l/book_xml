package com.gabriel.bookxml.entities;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.gabriel.bookxml.entities.ChapterEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;



@Getter @Setter @EqualsAndHashCode
@JsonRootName(value = "book")
@Entity
@Table(name = "TB_BOOK")
public class BookEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nullable
    private UUID book_id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private Integer pagesNumber;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @Nullable
    @JsonManagedReference
    @JacksonXmlElementWrapper(localName = "chapters")
    @JacksonXmlProperty(localName = "chapter")
    private List<ChapterEntity> chapters;


}
