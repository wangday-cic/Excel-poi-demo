/**
 * Copyright 2006-2019 Mazda Motor Co. All Rights Reserved.
 *
 * This software is the proprietary information of Mazda Motor Co.
 * Use is subject to license terms.
 */
package com.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import com.bean.*;
import com.utils.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * description
 *
 *
 * @author 会社名:, 名前(ローマ字):
 *
 */
public class StudentDao {
    public List<Student> getAllStudentFromDB() {
        Connection conn = null;
        String sql = "select * from STUDENT";
        List<Student> students = new ArrayList();
        try {
            conn = DBUtils.getConn();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setS_no(rs.getInt("S_NO"));
                student.setS_name(rs.getString("S_NAME"));
                student.setS_age(rs.getInt("S_AGE"));
                student.setS_sex(rs.getString("S_SEX"));
                student.setS_grade(rs.getFloat("S_GRADE"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }
    public List<Student> getAllStudentFromExcel(String filePath) {
        List<Student> students = new ArrayList();
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            int sheetNum = workbook.getNumberOfSheets();
            for (int i = 0; i <= sheetNum - 1; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                int rowNum = sheet.getLastRowNum();
                System.out.println(rowNum);
                for (int j = 1; j <= rowNum; j++) {
                    Row row = sheet.getRow(j);
                    Student student = new Student();
                    student.setS_no((int) row.getCell(0).getNumericCellValue());
                    student.setS_name((String) row.getCell(1).getStringCellValue());
                    student.setS_age((int) row.getCell(2).getNumericCellValue());
                    student.setS_sex((String) row.getCell(3).getStringCellValue());
                    student.setS_grade((float) row.getCell(4).getNumericCellValue());
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        return students;
    }
    public int InsertInfoToDB(String filePath) {
        int successCount = 0;
        Connection conn = null;
        int[] results = null;
        String sql = "Insert into STUDENT (S_NO,S_NAME,S_AGE,S_SEX,S_GRADE) values (?,?,?,?,?)";
        List<Student> students = getAllStudentFromExcel(filePath);
        try {
            conn = DBUtils.getConn();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            for (Student student : students) {
                ps.setInt(1, student.getS_no());
                ps.setString(2, student.getS_name());
                ps.setInt(3, student.getS_age());
                ps.setString(4, student.getS_sex());
                ps.setDouble(5, student.getS_grade());
                if (ps.executeUpdate() > 0) {
                    successCount++;
                }
                // ps.addBatch(sql);
            }
            // results= ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return successCount;
        // return results.length;
    }
}
