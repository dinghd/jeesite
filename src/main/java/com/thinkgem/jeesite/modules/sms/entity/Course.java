package com.thinkgem.jeesite.modules.sms.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 课程Entity
 * @author Gaowang
 * @version 2017-08-02
 */

public class Course extends DataEntity<Course> {

    private static final long serialVersionUID = 1L;
    private String name;
    private String reserved1;
    private Integer reserved2;

    public Course() {super();}

    public Course(String id) {
        this();
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reserved1='" + reserved1 + '\'' +
                ", reserved2=" + reserved2 +
                '}';
    }
}