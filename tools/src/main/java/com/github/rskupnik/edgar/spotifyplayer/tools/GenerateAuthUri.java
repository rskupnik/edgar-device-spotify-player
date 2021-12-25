package com.github.rskupnik.edgar.spotifyplayer.tools;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import se.michaelthelin.spotify.SpotifyApi;

import java.net.URI;

public class GenerateAuthUri {

    public static void main(String[] args) {
        Config config = ConfigFactory.load();
        SpotifyApi spotifyApi = SpotifyApi.builder()
                .setClientId(config.getString("clientId"))
                .setClientSecret(config.getString("clientSecret"))
                .setRedirectUri(URI.create(config.getString("redirectUri")))
                .build();
        var authRequest = spotifyApi.authorizationCodeUri()
                .scope(config.getString("scope"))
                .build();
        System.out.println(authRequest.execute().toString());
    }
}
