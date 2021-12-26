package com.github.rskupnik.edgar.spotifyplayer.core;

import com.typesafe.config.ConfigFactory;
import org.apache.hc.client5.http.impl.classic.HttpClients;

public interface SpotifyPlayer {

    void test3();

    void startPlayback(String playlistId);
    void stopPlayback();
    void toggleShuffle(boolean value);

    static SpotifyPlayer defaultImplementation() {
        var config = ConfigFactory.load();
        return new SpotifyPlayerImpl(
                config.getString("spotifyClient.deviceId"),
                new HttpSpotifyClient(
                    config.getString("spotifyClient.clientId"),
                    config.getString("spotifyClient.clientSecret"),
                    config.getString("spotifyClient.redirectUri"),
                    config.getString("spotifyClient.refreshToken")
                ),
                new HttpEdgarHubClient(
                        HttpClients.createDefault()
                )
        );
    }
}
