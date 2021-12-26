package com.github.rskupnik.edgar.spotifyplayer.core;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.io.entity.StringEntity;

public class HttpEdgarHubClient implements EdgarHubClient {

    private final HttpClient httpClient;

    public HttpEdgarHubClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void register() {
        try {
            var request = new HttpPost("http://192.168.0.154:8080/devices");
            request.setEntity(
                    new StringEntity("""
                            {
                                "id": "spotifyPlayer",
                                "name": "Spotify Player",
                                "endpoints": [
                                    {
                                        "name": "start",
                                        "path": "/start",
                                        "method": "POST"
                                    },
                                    {
                                        "name": "stop",
                                        "path": "/stop",
                                        "method": "POST"
                                    }
                                ]
                            }
                    """)
            );
            request.setHeader("Content-type", "application/json");
            httpClient.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
