package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Computer {
    private int id;
    private MusicPlayer MusicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        MusicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer " + this.id + " "  + this.MusicPlayer.playMusic();
    }
}
