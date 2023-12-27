package com.rrow.study.poi.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/12/27 17:34
 * Description: 这里不能用字符流,否则会有问题,下面是错误代码,我们先用response来写出试试
 */
public class XSSFWorkbookExcelExport {
    public static void main(String[] args) throws IOException {
        //Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create file system using specific name
        FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx"));

        //write operation workbook using file out object
        workbook.write(out);
        out.close();
        System.out.println("createworkbook.xlsx written successfully");
    }
}