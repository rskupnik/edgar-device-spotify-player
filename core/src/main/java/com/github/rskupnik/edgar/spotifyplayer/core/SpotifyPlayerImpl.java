package com.github.rskupnik.edgar.spotifyplayer.core;

public class SpotifyPlayerImpl implements SpotifyPlayer {

    private final String deviceId;
    private final SpotifyClient spotifyClient;
    private final EdgarHubClient edgarHubClient;

    public SpotifyPlayerImpl(String deviceId, SpotifyClient spotifyClient, EdgarHubClient edgarHubClient) {
        this.deviceId = deviceId;
        this.spotifyClient = spotifyClient;
        this.edgarHubClient = edgarHubClient;

        registerWithHub();
    }

    private void registerWithHub() {
        edgarHubClient.register();
    }

    @Override
    public void test3() {
        spotifyClient.test3();
    }

    @Override
    public void startPlayback(String playlistId) {
        spotifyClient.startPlayback(deviceId, playlistId);
    }

    @Override
    public void stopPlayback() {
        spotifyClient.stopPlayback(deviceId);
    }

    @Override
    public void toggleShuffle(boolean value) {
        spotifyClient.toggleShuffle(value);
    }
}
