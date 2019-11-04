/**
 * Copyright 2006-2019 Mazda Motor Co. All Rights Reserved.
 *
 * This software is the proprietary information of Mazda Motor Co.
 * Use is subject to license terms.
 */

package com.bean;

/**
*
* description
*
*
* @author 会社名:, 名前(ローマ字):
*
*/
public class Student {
    public static final int attribute_num=5;
    public static final String[] SheetTitles={"S_NO","S_NAME","S_AGE","S_SEX","S_GRADE"};
    private Integer s_no; //序号
    private String s_name; //名字
    private Integer s_age; //年龄
    private String s_sex; //性别
    private double s_grade; //分数
    
 
    //
    public Student() {
    }
 
    //
    public Student(Integer s_no, String s_name, Integer s_age, String s_sex, double s_grade) {
        this.s_no = s_no;
        this.s_name = s_name;
        this.s_age = s_age;
        this.s_sex = s_sex;
        this.s_grade = s_grade;
    }

 
    public Integer getS_no() {
        return s_no;
    }
 
    public void setS_no(Integer s_no) {
        this.s_no = s_no;
    }
 
    public String getS_name() {
        return s_name;
    }
 
    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
 
    public Integer getS_age() {
        return s_age;
    }
 
    public void setS_age(Integer s_age) {
        this.s_age = s_age;
    }
 
    public String getS_sex() {
        return s_sex;
    }
 
    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }
 
    public double getS_grade() {
        return s_grade;
    }
 
    public void setS_grade(double s_grade) {
        this.s_grade = s_grade;
    }
}
