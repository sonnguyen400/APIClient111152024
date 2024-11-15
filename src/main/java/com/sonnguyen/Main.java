package com.sonnguyen;

import com.sonnguyen.service.AbstractAlbumService;
import com.sonnguyen.service.HttpClientAlbumService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AbstractAlbumService abstractAlbumService=new HttpClientAlbumService();
        try {
            abstractAlbumService.findAll().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}