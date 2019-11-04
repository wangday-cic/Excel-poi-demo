/**
 * Copyright 2006-2019 Mazda Motor Co. All Rights Reserved.
 *
 * This software is the proprietary information of Mazda Motor Co.
 * Use is subject to license terms.
 */

package com.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bean.Student;
import com.dao.StudentDao;

/**
*
* description
*
*
* @author 会社名:, 名前(ローマ字):
*
*/
public class ExcelUtils {
    public void InsertInfoToExcel(String filePath) throws IOException{
        StudentDao studentDao=new StudentDao();
        List<Student> students=studentDao.getAllStudentFromDB();
        try {
            FileOutputStream outputStream=new FileOutputStream(filePath);
            Workbook workbook=new XSSFWorkbook();
            Sheet sheet=workbook.createSheet();
            Row row=sheet.createRow(0);
            Cell cell=null;
            String[] sheetTitle=Student.SheetTitles;
            for(int i=0;i<=Student.attribute_num-1;i++){
               cell=row.createCell(i);
               cell.setCellValue(sheetTitle[i]);
            }
            int i=1;
            for(Student student:students){
                row = sheet.createRow(i);
                Cell cell0=row.createCell(0);
                cell0.setCellValue((int)student.getS_no());
                Cell cell1=row.createCell(1);
                cell1.setCellValue((String)student.getS_name());
                Cell cell2=row.createCell(2);
                cell2.setCellValue((int)student.getS_age());
                Cell cell3=row.createCell(3);
                cell3.setCellValue((String)student.getS_sex());
                Cell cell4=row.createCell(4);
                cell4.setCellValue((double)student.getS_grade());
                i++;
            }
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }
}

