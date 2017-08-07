package com.thinkgem.jeesite.modules.msg.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class Student extends DataEntity<Student> {
    private static final long serialVersionUID = 1L;
    private String name;
    private String no;
    private Integer age;
    private String grade;
    private String stuclass;
    private String reserved1;
    private String reserved2;

    public Student(){

    }
    public Student(String id){
        super(id);
    }

    public Student(String name,String no,Integer age,String grade,String stuclass,String reserved1, String reserved2) {
        this.name = name;
        this.no=no;
        this.age=age;
        this.grade=grade;
        this.stuclass=stuclass;
        this.reserved1 = reserved1;
        this.reserved2 = reserved2;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }



}
