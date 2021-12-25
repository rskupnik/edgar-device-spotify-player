package com.github.rskupnik.edgar.spotifyplayer.core;

public interface SpotifyClient {

    void test3();

    void startPlayback(String deviceId, String playlistId);
    void stopPlayback(String deviceId);
}
