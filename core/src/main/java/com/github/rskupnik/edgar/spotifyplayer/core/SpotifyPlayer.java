package com.github.rskupnik.edgar.spotifyplayer.core;

import com.typesafe.config.ConfigFactory;

public interface SpotifyPlayer {

    void test3();

    static SpotifyPlayer defaultImplementation() {
        var config = ConfigFactory.load();
        return new SpotifyPlayerImpl(
                new HttpSpotifyClient(
                    config.getString("spotifyClient.clientId"),
                    config.getString("spotifyClient.clientSecret"),
                    config.getString("spotifyClient.redirectUri"),
                    config.getString("spotifyClient.refreshToken")
                )
        );
    }
}
