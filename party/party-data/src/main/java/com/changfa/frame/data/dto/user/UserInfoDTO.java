package com.changfa.frame.data.dto.user;

import java.util.Date;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/11
 */
public class UserInfoDTO {
    private String token;
    private String name;
    private String sex;
    private Date birthday;
    private String censusRegister;
    private String phone;
    private String national;
    private String educationalBackground;
    private String idNo;
    private String major;
    private String graduateSchool;
    private Date applicationJoinPartyTime;
    private String degreeIn;
    private Date joinPartyTime;
    private String descri;
    private String partyOrganization;
    private String userIcon;
    private String age;
    private String politicsStatus;

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCensusRegister() {
        return censusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        this.censusRegister = censusRegister;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public Date getApplicationJoinPartyTime() {
        return applicationJoinPartyTime;
    }

    public void setApplicationJoinPartyTime(Date applicationJoinPartyTime) {
        this.applicationJoinPartyTime = applicationJoinPartyTime;
    }

    public String getDegreeIn() {
        return degreeIn;
    }

    public void setDegreeIn(String degreeIn) {
        this.degreeIn = degreeIn;
    }

    public Date getJoinPartyTime() {
        return joinPartyTime;
    }

    public void setJoinPartyTime(Date joinPartyTime) {
        this.joinPartyTime = joinPartyTime;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getPartyOrganization() {
        return partyOrganization;
    }

    public void setPartyOrganization(String partyOrganization) {
        this.partyOrganization = partyOrganization;
    }
}
