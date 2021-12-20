package com.github.rskupnik.edgar.spotifyplayer.core;

public class SpotifyPlayerImpl implements SpotifyPlayer {

    private final SpotifyClient spotifyClient;

    public SpotifyPlayerImpl(SpotifyClient spotifyClient) {
        this.spotifyClient = spotifyClient;
    }

    @Override
    public void test3() {
        spotifyClient.test3();
    }
}
