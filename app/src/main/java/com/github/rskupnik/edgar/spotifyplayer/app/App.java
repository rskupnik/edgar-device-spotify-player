/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.rskupnik.edgar.spotifyplayer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.github.rskupnik.edgar.spotifyplayer.app",
        "com.github.rskupnik.edgar.spotifyplayer.web"
})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
