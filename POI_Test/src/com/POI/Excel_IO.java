/**
 * Copyright 2006-2019 Mazda Motor Co. All Rights Reserved.
 *
 * This software is the proprietary information of Mazda Motor Co.
 * Use is subject to license terms.
 */
package com.POI;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.utils.ExcelUtils;

/**
 *
 * description
 *
 *
 * @author 会社名:, 名前(ローマ字):
 *
 */
class Function{
    void DBToExcel() throws IOException{
        System.out.print("请指定保存路径： ");
        Scanner scanner=new Scanner(System.in);
        String filePath=scanner.next();
        ExcelUtils excelUtils=new ExcelUtils();
        excelUtils.InsertInfoToExcel(filePath);
        System.out.println("文件已成功导出！ ");
    }  
    void ExcelToDB(){
        System.out.print("请输入文件路径： ");
        Scanner scanner=new Scanner(System.in);
        String filePath=scanner.next();
        System.out.println(filePath);
        StudentDao studentDao = new StudentDao();
        int successCount = studentDao.InsertInfoToDB(filePath);
        System.out.println(successCount + " 件已成功导入"); 
    }
}
public class Excel_IO {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        //String filePath = "C:\\Work\\Mazda\\ApachePOI\\Student.xlsx";
        System.out.println("请输入功能编号： ");
        System.out.println("1.从Excel向DB导入数据");
        System.out.println("2.从DB导出数据到Excel");
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Function function =new Function();
        switch (n) {
        case 1:
            function.ExcelToDB();
            break;
        case 2:
            function.DBToExcel();
            break;
        default:System.out.println("请输入正确的功能编号！");
            break;
        }
        
       
    }
}
