package com.workdatabase.resp;

public class IdentifyResp {



    private boolean flag;

    private String name;

    private  String openid;

    private String roommatename;

    private String phonenumber;

    private String graduationtime;

    private String major;

    private Integer banji;

    private String department;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoommatename() {
        return roommatename;
    }

    public void setRoommatename(String roommatename) {
        this.roommatename = roommatename;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGraduationtime() {
        return graduationtime;
    }

    public void setGraduationtime(String graduationtime) {
        this.graduationtime = graduationtime;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getBanji() {
        return banji;
    }

    public void setBanji(Integer banji) {
        this.banji = banji;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "IdentifyResp{" +
                "flag=" + flag +
                ", name='" + name + '\'' +
                ", openId='" + openid + '\'' +
                ", roommatename='" + roommatename + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", graduationtime='" + graduationtime + '\'' +
                ", major='" + major + '\'' +
                ", banji=" + banji +
                ", department='" + department + '\'' +
                '}';
    }
}