package com.thinkgem.jeesite.modules.sms.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 成绩Entity
 * @author Gaowang
 * @version 2017-08-02
 */

public class Score extends DataEntity<Score> {

    private static final long serialVersionUID = 1L;
    private Student student;
    private Course course;
    private Integer score;
    private String reserved1;
    private Integer reserved2;

    public Score() {super();}

    public Score(String id) {
        this();
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public Integer getReserved2() {
        return reserved2;
    }

    public void setReserved2(Integer reserved2) {
        this.reserved2 = reserved2;
    }

    @Override
    public String toString() {
        return "Score{" +
                "student=" + student +
                ", course=" + course +
                ", score=" + score +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2=" + reserved2 +
                '}';
    }
}