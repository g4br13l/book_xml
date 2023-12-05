package com.gabriel.bookxml.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Data
@JsonRootName(value = "page")
@Entity
@Table(name = "TB_PAGE")
public class PageEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nullable
    private UUID page_id;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    @Nullable
    @JsonBackReference
    @JacksonXmlProperty(localName = "chapter")
    private ChapterEntity chapter;

    @Column(nullable = false)
    private String textPage;

}
