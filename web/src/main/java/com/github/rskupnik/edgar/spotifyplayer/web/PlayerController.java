package com.github.rskupnik.edgar.spotifyplayer.web;

import com.github.rskupnik.edgar.spotifyplayer.core.SpotifyPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final SpotifyPlayer spotifyPlayer;

    @Autowired
    public PlayerController(SpotifyPlayer spotifyPlayer) {
        this.spotifyPlayer = spotifyPlayer;
    }

    @PostMapping("start")
    public void startPlayback() {
        spotifyPlayer.startPlayback(null);
    }

    @PostMapping("stop")
    public void stopPlayback() {
        spotifyPlayer.stopPlayback();
    }
}
