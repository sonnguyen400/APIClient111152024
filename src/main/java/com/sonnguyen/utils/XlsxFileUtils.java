package com.sonnguyen.utils;

import com.sonnguyen.model.Album;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsxFileUtils {
    public static void saveListAlbums(List<Album> albums) {
        try(Workbook workbook=new XSSFWorkbook();
            FileOutputStream fileOutputStream=new FileOutputStream("list.xlsx")){
            Sheet sheet=workbook.createSheet("Sheet1");
            Row head=sheet.createRow(0);
            head.createCell(0).setCellValue("id");
            head.createCell(1).setCellValue("userId");
            head.createCell(2).setCellValue("title");
            for(int i=1; i<=albums.size(); i++){
                Row row=sheet.createRow(i);
                row.createCell(0).setCellValue(albums.get(i-1).getId());
                row.createCell(1).setCellValue(albums.get(i-1).getUserId());
                row.createCell(2).setCellValue(albums.get(i-1).getTitle());
            }
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
