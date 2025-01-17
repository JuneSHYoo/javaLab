package com.test.sangHoon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
 private String title;
 private String director;
 private Integer releaseYear;
 private List<String> genres;
 private Integer audience;

 public Movie(String title) {
     this.title = title.toLowerCase();
     this.director = null;
     this.releaseYear = null;
     this.genres = new ArrayList<>();
     this.audience = null;
 }
}
