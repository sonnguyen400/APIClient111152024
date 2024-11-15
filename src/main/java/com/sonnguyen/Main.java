package com.sonnguyen;

import com.sonnguyen.model.Album;
import com.sonnguyen.service.AbstractAlbumService;
import com.sonnguyen.service.HttpClientAlbumService;
import com.sonnguyen.utils.TextFileUtils;
import com.sonnguyen.utils.XlsxFileUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AbstractAlbumService albumService=new HttpClientAlbumService();
        Scanner scanner=new Scanner(System.in);
        int a;
        do{
            System.out.println("1. Find All");
            System.out.println("2. Find By Id");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            a= scanner.nextInt();
            switch(a){
                case 1:
                    findAllCmd(albumService,scanner);
                    break;
                case 2:
                    findByIdCmd(albumService,scanner);
                default:
                    break;
            }
        }while(a!=3);
    }
    public static void findAllCmd(AbstractAlbumService albumService,Scanner scanner){
        List<Album> list=null;
        try {
            list=albumService.findAll();
            list.forEach(System.out::println);
            int a;
            do{
                System.out.println("1. Export to txt");
                System.out.println("2. Export to excel");
                System.out.println("3. Exit");
                System.out.print("Enter your choice:");
                a=scanner.nextInt();
                switch(a){
                    case 1:
                        TextFileUtils.saveListAlbums(list);
                        break;
                    case 2:
                        XlsxFileUtils.saveListAlbums(list);
                        break;
                    default:
                        break;
                }

            }while (a!=3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void findByIdCmd(AbstractAlbumService albumService,Scanner scanner){
        System.out.println("Enter id: ");
        int id=scanner.nextInt();
        Album album=null;
        try {
            album=albumService.findById(id);
            System.out.println("Result: "+album);
            int a;
            do{
                System.out.println("1. Export to txt");
                System.out.println("2. Export to excel");
                System.out.println("3. Exit");
                System.out.print("Enter your choice:");
                a=scanner.nextInt();
                switch(a){
                    case 1:
                        TextFileUtils.saveListAlbums(List.of(album));
                        break;
                    case 2:
                        XlsxFileUtils.saveListAlbums(List.of(album));
                        break;
                    default:
                        break;
                }

            }while (a!=3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}