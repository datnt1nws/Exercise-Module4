package com.example.musicvalidate.controller;

import com.example.musicvalidate.model.Song;
import com.example.musicvalidate.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/")
    public String redirectToAddSong() {
        return "redirect:/add-song";
    }

    @GetMapping("/add-song")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        return "add-song";
    }

    @PostMapping("/add-song")
    public String addSong(@Valid Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-song";
        }
        songService.saveSong(song);
        return "redirect:/success";
    }

    @GetMapping("/edit-song/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            return "redirect:/add-song";
        }
        model.addAttribute("song", song);
        return "edit-song";
    }

    @PostMapping("/edit-song")
    public String updateSong(@Valid Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-song";
        }
        songService.updateSong(song);
        return "redirect:/success";
    }
}