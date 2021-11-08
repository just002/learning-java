package com.homer.ClassAndObject;

/**
 * 通讯信息类
 */
public class CommInfo {

    private String address;
    private String mobile;

    public CommInfo(String address, String mobile) {
        this.address = address;
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
