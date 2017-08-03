package com.thinkgem.jeesite.modules.sms.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生Entity
 * @author Gaowang
 * @version 2017-08-02
 */

public class Student extends DataEntity<Student> {

    private static final long serialVersionUID = 1L;
    private String name;
    private String no;
    private Integer age;
    private String grade;
    private String stuClass;
    private String reserved1;
    private Integer reserved2;

    public Student() {super();}

    public Student(String id) {
        this();
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
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
        this.grade = grade == null ? null : grade.trim();
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1 == null ? null : reserved1.trim();
    }

    public Integer getReserved2() {
        return reserved2;
    }

    public void setReserved2(Integer reserved2) {
        this.reserved2 = reserved2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2=" + reserved2 +
                '}';
    }
}