package com.changfa.frame.data.entity.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/10
 */
@Entity
@Table(name = "user_info")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class UserInfo {

    private Integer id;
    private Integer userId;
    private Integer companyId;
    private String sex;
    private String national;
    private String userIcon;
    private String email;
    private String idNo;
    private Date birthday;
    private String censusRegister;
    private String educationalBackground;
    private String degreeIn;
    private String graduateSchool;
    private String major;
    private Date applicationJoinPartyTime;
    private Date joinPartyTime;
    private String status;
    private Date statusTime;
    private Date createTime;
    private String descri;
    private String age;
    private String politicsStatus;

    @Basic
    @Column(name = "politics_status", nullable = true)
    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "descri", nullable = true)
    public String getDescri() {
        return descri;
    }

    public void setDescri(String descril) {
        this.descri = descril;
    }


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "company_id", nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "national", nullable = true, length = 32)
    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Basic
    @Column(name = "user_icon", nullable = true, length = 255)
    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "id_no", nullable = true, length = 32)
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "census_register", nullable = true, length = 255)
    public String getCensusRegister() {
        return censusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        this.censusRegister = censusRegister;
    }

    @Basic
    @Column(name = "educational_background", nullable = true, length = 2)
    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    @Basic
    @Column(name = "degree_in", nullable = true, length = 32)
    public String getDegreeIn() {
        return degreeIn;
    }

    public void setDegreeIn(String degreeIn) {
        this.degreeIn = degreeIn;
    }

    @Basic
    @Column(name = "graduate_school", nullable = true, length = 64)
    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    @Basic
    @Column(name = "major", nullable = true, length = 64)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "application_join_party_time", nullable = true)
    public Date getApplicationJoinPartyTime() {
        return applicationJoinPartyTime;
    }

    public void setApplicationJoinPartyTime(Date applicationJoinPartyTime) {
        this.applicationJoinPartyTime = applicationJoinPartyTime;
    }

    @Basic
    @Column(name = "join_party_time", nullable = true)
    public Date getJoinPartyTime() {
        return joinPartyTime;
    }

    public void setJoinPartyTime(Date joinPartyTime) {
        this.joinPartyTime = joinPartyTime;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "status_time", nullable = true)
    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return id == userInfo.id &&
                userId == userInfo.userId &&
                companyId == userInfo.companyId &&
                Objects.equals(sex, userInfo.sex) &&
                Objects.equals(national, userInfo.national) &&
                Objects.equals(userIcon, userInfo.userIcon) &&
                Objects.equals(email, userInfo.email) &&
                Objects.equals(idNo, userInfo.idNo) &&
                Objects.equals(birthday, userInfo.birthday) &&
                Objects.equals(censusRegister, userInfo.censusRegister) &&
                Objects.equals(educationalBackground, userInfo.educationalBackground) &&
                Objects.equals(degreeIn, userInfo.degreeIn) &&
                Objects.equals(graduateSchool, userInfo.graduateSchool) &&
                Objects.equals(major, userInfo.major) &&
                Objects.equals(applicationJoinPartyTime, userInfo.applicationJoinPartyTime) &&
                Objects.equals(joinPartyTime, userInfo.joinPartyTime) &&
                Objects.equals(status, userInfo.status) &&
                Objects.equals(statusTime, userInfo.statusTime) &&
                Objects.equals(createTime, userInfo.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, companyId, sex, national, userIcon, email, idNo, birthday, censusRegister, educationalBackground, degreeIn, graduateSchool, major, applicationJoinPartyTime, joinPartyTime, status, statusTime, createTime);
    }
}
