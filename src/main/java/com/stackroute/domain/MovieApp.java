package com.stackroute.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "movie")

public class MovieApp {
    @Id
    String id;
    String title;
    String genre;
    String language;

    public MovieApp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return "MovieApp{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}

