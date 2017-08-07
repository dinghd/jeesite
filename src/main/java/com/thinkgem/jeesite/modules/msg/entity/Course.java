package com.thinkgem.jeesite.modules.msg.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class Course extends DataEntity<Course> {
    private static final long serialVersionUID = 1L;

    private String name;
    private String reserved1;
    private String reserved2;

    public Course() {
    }
    public Course(String id){
        super(id);
    }

    public Course(String name, String reserved1, String reserved2) {
        this.name = name;
        this.reserved1 = reserved1;
        this.reserved2 = reserved2;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
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
    public void setReserved2(String reserved2) {this.reserved2 = reserved2;}
}
