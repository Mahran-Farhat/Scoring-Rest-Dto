package com.scoring.cabinet.dto;

import java.io.Serializable;

public class DoctorDto implements Serializable {

    private long at01;
    private String at02;
    private String at03;
    private String at04;
    private String at05;

    public DoctorDto() {
    }

    public long getAt01() {
        return at01;
    }

    public void setAt01(long at01) {
        this.at01 = at01;
    }

    public String getAt02() {
        return at02;
    }

    public void setAt02(String at02) {
        this.at02 = at02;
    }

    public String getAt03() {
        return at03;
    }

    public void setAt03(String at03) {
        this.at03 = at03;
    }

    public String getAt04() {
        return at04;
    }

    public void setAt04(String at04) {
        this.at04 = at04;
    }

    public String getAt05() {
        return at05;
    }

    public void setAt05(String at05) {
        this.at05 = at05;
    }
}
