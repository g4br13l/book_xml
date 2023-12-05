package com.gabriel.bookxml.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record BookDto(

        @NotBlank String name,
        @NotNull Integer pagesNumber,
        @NotNull List<UUID> ChapterIds

) { }
