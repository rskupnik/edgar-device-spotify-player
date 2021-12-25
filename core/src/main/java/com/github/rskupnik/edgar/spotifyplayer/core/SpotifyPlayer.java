package com.github.rskupnik.edgar.spotifyplayer.core;

import com.typesafe.config.ConfigFactory;

public interface SpotifyPlayer {

    void test3();

    void startPlayback();
    void stopPlayback();

    static SpotifyPlayer defaultImplementation() {
        var config = ConfigFactory.load();
        return new SpotifyPlayerImpl(
                config.getString("spotifyClient.deviceId"),
                new HttpSpotifyClient(
                    config.getString("spotifyClient.clientId"),
                    config.getString("spotifyClient.clientSecret"),
                    config.getString("spotifyClient.redirectUri"),
                    config.getString("spotifyClient.refreshToken")
                )
        );
    }
}
