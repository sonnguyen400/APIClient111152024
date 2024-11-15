package com.sonnguyen.utils;

import com.sonnguyen.model.Album;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFileUtils {
    public static void saveListAlbums(List<Album> albums){
        File file=new File("albums.txt");

        if(!file.exists()) {
            try {
                if(!file.createNewFile()) throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try( FileWriter fileWriter=new FileWriter(file)){
            String result=String.join(",\n",albums.stream().map(Album::toString).toArray(String[]::new));
            fileWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
