package com.rrow.study.controller;

import com.rrow.study.dto.ExcelDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Rrow
 * @date: 2023/12/28 1:58
 * Description:
 */
@RestController
@Slf4j
public class StudyController {

    @RequestMapping("/export")
    public void exportExcel(ExcelDTO excelDTO, HttpServletResponse response) throws IOException {
        String fileName = "投资建议书.xlsx";
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("投资建议书");

        // 隐藏除大格子外的所有其他单元格
        int totalRows = 30;
        int totalCols = 20;

        for (int i = 0; i < totalRows; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < totalCols; j++) {
                if (!(i >= 0 && i <= 29 && j >= 0 && j <= 19)) {
                    sheet.setColumnHidden(j, true);
                    Cell cell = row.createCell(j);
                    cell.setCellValue("");
                }
            }
        }

        // 合并单元格
        int firstRow = 0; // 开始行
        int lastRow = 29; // 结束行
        int firstCol = 0; // 开始列
        int lastCol = 19; // 结束列
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));

        // 写入内容到合并的单元格
        Row row = sheet.getRow(0);
        if (row == null) {
            row = sheet.createRow(0);
        }
        Cell cell = row.getCell(0);
        if (cell == null) {
            cell = row.createCell(0);
        }
        cell.setCellValue("这是合并的大格子");


        //下载
        response.setContentType(getContentType(fileName));
        response.setHeader("Content-Disposition", getDisposition(fileName, false));
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Cache-Control", "public");
        response.setHeader("Expires", "0");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setCharacterEncoding("UTF-8");

        ServletOutputStream out = response.getOutputStream();
        wb.write(out);
    }

    public static String getDisposition(String fileName, boolean open) {
        HttpServletRequest request = getRequest();
        return open ? "filename=\"" + encodeFileName(fileName, request) + "\"" : "attachment; filename=\"" + encodeFileName(fileName, request) + "\"";
    }

    public static String encodeFileName(String fileNames, HttpServletRequest request) {
        String codedFilename = null;
        if (request == null) {
            log.warn("encodeFileName中传递了空的HttpServletRequest,导致无法根据浏览器类型兼容中文乱码");
            return fileNames;
        } else {
            try {
                String agent = request.getHeader("USER-AGENT");
                if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident") || null != agent && -1 != agent.indexOf("Edge")) {
                    String name = URLEncoder.encode(fileNames, "UTF-8").replace("\\+", "%20").replace("%2B", "\\+");
                    codedFilename = name;
                } else {
                    if (null == agent || -1 == agent.indexOf("Mozilla")) {
                        return fileNames;
                    }

                    codedFilename = URLEncoder.encode(fileNames, "UTF-8").replace("\\+", "%20").replace("%2B", "\\+");
                }
            } catch (Exception var5) {
                log.warn("encodeFileName失败", var5);
            }

            return codedFilename;
        }
    }

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static String getContentType(String fileName) {
        String result = null;
        int i = StringUtils.isBlank(fileName) ? -1 : fileName.lastIndexOf(46);
        if (i >= 0) {
            String key = StringUtils.lowerCase(fileName.substring(i + 1));
            Map<String, String> contentTypeMap = new HashMap();
            contentTypeMap.put("txt", "text/plain");
            contentTypeMap.put("htm", "text/html");
            contentTypeMap.put("html", "text/html");
            contentTypeMap.put("xml", "text/xml");
            contentTypeMap.put("rtf", "text/richtext");
            contentTypeMap.put("doc", "application/msword");
            contentTypeMap.put("xls", "application/x-msexcel");
            contentTypeMap.put("ppt", "application/x-mspowerpoint");
            contentTypeMap.put("pdf", "application/pdf");
            contentTypeMap.put("bmp", "image/bmp");
            contentTypeMap.put("jpg", "image/jpeg");
            contentTypeMap.put("gif", "image/gif");
            contentTypeMap.put("exe", "application/octet-stream");
            result = (String)contentTypeMap.get(key);
        }

        return result == null ? "application/unknown" : result;
    }

}
