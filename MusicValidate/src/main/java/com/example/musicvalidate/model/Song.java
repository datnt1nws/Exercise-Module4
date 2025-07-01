package com.example.musicvalidate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern; // Thêm import này

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Song name is required")
    @Size(max = 800, message = "Song name must not exceed 800 characters")
    @Pattern(regexp = "^[^@;,.=+-]*$", message = "Song name must not contain special characters like @, ;, ,, ., =, -, +")
    private String songName;

    @NotBlank(message = "Artist is required")
    @Size(max = 300, message = "Artist name must not exceed 300 characters")
    @Pattern(regexp = "^[^@;,.=+-]*$", message = "Artist name must not contain special characters like @, ;, ,, ., =, -, +")
    private String artist;

    @NotBlank(message = "Genre is required")
    @Size(max = 1000, message = "Genre must not exceed 1000 characters")
    @Pattern(regexp = "^[^@;=.+-]*$", message = "Genre must not contain special characters except comma (,)")
    private String genre;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}