package com.github.rskupnik.edgar.spotifyplayer.core;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;

import java.net.URI;

public class HttpSpotifyClient implements SpotifyClient {

    private final SpotifyApi spotifyApi;
    private final AuthorizationCodeRefreshRequest refreshTokenRequest;

    public HttpSpotifyClient(String clientId, String clientSecret, String redirectUri, String refreshToken) {
        this.spotifyApi = SpotifyApi.builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(URI.create(redirectUri))
                .setRefreshToken(refreshToken)
                .build();

        refreshTokenRequest = spotifyApi.authorizationCodeRefresh().build();

        refreshToken();
    }

    public void refreshToken() {
        try {
            var newToken = refreshTokenRequest.execute();
            spotifyApi.setAccessToken(newToken.getAccessToken());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void test3() {
        try {
            var playlists = spotifyApi.getListOfUsersPlaylists("21avkgioine5h5mcamjvdm4mi").build().execute();
            System.out.println(playlists.getNext());
            var profile = spotifyApi.getUsersProfile("21avkgioine5h5mcamjvdm4mi").build().execute();
            System.out.println(profile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
