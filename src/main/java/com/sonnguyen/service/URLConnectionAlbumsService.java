package com.sonnguyen.service;

import com.sonnguyen.model.Album;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class URLConnectionAlbumsService extends AbstractAlbumService {
    @Override
    public Album findById(long id) throws IOException{
        URL url = new URL(String.format("%s/%s",AbstractAlbumService.url,id));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuilder response = new StringBuilder();
            while ((input = rd.readLine()) != null) {
                response.append(input);
            }
            return parseAlbum((JSONObject) JSONValue.parse(response.toString()));
        }
        throw new ConnectException("Can't connect to server");
    }

    public List<Album> findAll() throws IOException {
        URL url = new URL(AbstractAlbumService.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuilder response = new StringBuilder();
            while ((input = rd.readLine()) != null) {
                response.append(input);
            }
            return parseAlbumlist(response.toString());
        }
        throw new ConnectException("Can't connect to server");
    }
}
