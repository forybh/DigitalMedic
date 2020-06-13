package com.example.digitalmedic;

public class MemberInfo {
    private String name;
    private String address;
    private String phoneNum;
    private String momPhone;
    private String illness;

    public MemberInfo(String name, String address, String phoneNum, String momPhone, String illness){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.momPhone = momPhone;
        this.illness = illness;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMomPhone() {
        return momPhone;
    }

    public void setMomPhone(String momPhone) {
        this.momPhone = momPhone;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
