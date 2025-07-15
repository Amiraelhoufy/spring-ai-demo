package org.agcodes.spring_ai_ollama.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Book {

  private Long id;
  private String title;
  private String author;
  private String genre;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate publishedDate;
  // getters/setters

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getGenre() {
    return genre;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }
}
