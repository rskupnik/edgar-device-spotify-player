package com.github.rskupnik.edgar.spotifyplayer.app;

import com.github.rskupnik.edgar.spotifyplayer.core.SpotifyPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SpotifyPlayer spotifyPlayer() {
        return SpotifyPlayer.defaultImplementation();
    }
}
