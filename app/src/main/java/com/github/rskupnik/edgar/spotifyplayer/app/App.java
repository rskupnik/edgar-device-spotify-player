/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.rskupnik.edgar.spotifyplayer.app;

import com.github.rskupnik.edgar.spotifyplayer.core.SpotifyPlayer;

public class App {
    public static void main(String[] args) {
        SpotifyPlayer spotifyPlayer = SpotifyPlayer.defaultImplementation();
        //spotifyPlayer.test3();
        //spotifyPlayer.startPlayback("5BhYw83I5svASNyTjQfQpq");
        spotifyPlayer.toggleShuffle(true);
    }
}
