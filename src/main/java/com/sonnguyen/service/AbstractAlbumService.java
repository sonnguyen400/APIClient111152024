package com.sonnguyen.service;

import com.sonnguyen.model.Album;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public abstract class AbstractAlbumService {
    final static String url = "https://jsonplaceholder.typicode.com/albums";

    abstract public List<Album> findAll() throws IOException;

    final protected List<Album> parseAlbumlist(String json) throws IOException {
        List<JSONObject> results = (List<JSONObject>) JSONValue.parse(new StringReader(json));
        return results.stream().map((jsonObject) -> {
            return new Album((long) jsonObject.get("id"), (long) jsonObject.get("userId"), (String) jsonObject.get("title"));
        }).toList();
    }
}
