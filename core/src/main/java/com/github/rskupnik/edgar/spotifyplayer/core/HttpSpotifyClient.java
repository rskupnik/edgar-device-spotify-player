package com.github.rskupnik.edgar.spotifyplayer.core;

import org.apache.commons.codec.binary.StringUtils;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.miscellaneous.Device;
import se.michaelthelin.spotify.model_objects.specification.PlaylistSimplified;
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
            //var playlists = spotifyApi.getListOfUsersPlaylists("21avkgioine5h5mcamjvdm4mi").build().execute();
            var playlists = spotifyApi.getListOfCurrentUsersPlaylists().build().execute();
            for (PlaylistSimplified playlist : playlists.getItems()) {
                System.out.println(playlist);
            }
            var profile = spotifyApi.getUsersProfile("21avkgioine5h5mcamjvdm4mi").build().execute();
            System.out.println(profile);
            var devices = spotifyApi.getUsersAvailableDevices().build().execute();
            for (Device device : devices) {
                System.out.println(device);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startPlayback(String deviceId, String playlistId) {
        try {
            spotifyApi.startResumeUsersPlayback()
                    .device_id(deviceId)
                    .context_uri(playlistId == null || playlistId.equals("") ? null : "spotify:playlist:" + playlistId)
                    .build()
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopPlayback(String deviceId) {
        try {
            spotifyApi.pauseUsersPlayback().device_id(deviceId).build().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
