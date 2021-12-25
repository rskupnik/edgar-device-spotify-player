package com.github.rskupnik.edgar.spotifyplayer.tools;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import se.michaelthelin.spotify.SpotifyApi;

import java.net.URI;

public class RetrieveRefreshToken {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 1) {
            System.out.println("Please pass the auth code as first and only argument (retrieve it using GenerateAuthUri");
        }

        Config config = ConfigFactory.load();
        SpotifyApi spotifyApi = SpotifyApi.builder()
                .setClientId(config.getString("clientId"))
                .setClientSecret(config.getString("clientSecret"))
                .setRedirectUri(URI.create(config.getString("redirectUri")))
                .build();
        var authRequest = spotifyApi.authorizationCode(args[0])
                .build();
        System.out.println(authRequest.execute().getRefreshToken());
    }
}
