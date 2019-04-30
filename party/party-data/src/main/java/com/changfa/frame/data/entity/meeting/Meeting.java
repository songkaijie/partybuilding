package com.changfa.frame.data.entity.meeting;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "meeting")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Meeting {
    private Integer id;
    private Integer companyId;
    private Integer meetingTypeId;
    private String theme;
    private String descri;
    private String mode;
    private Integer initiatorUserId;
    private Date beginTime;
    private Integer sessionLength;
    private String hostUserId;
    private String recorderUserId;
    private String data;
    private String requirement;
    private Integer partyOrganizationId;
    private String isSynchronousLive;
    private String otherSettings;
    private String password;
    private String signQrcode;
    private String releaseTerminalType;
    private String province;
    private String city;
    private String county;
    private String detailAddress;
    private String fullAddress;
    private String status;
    private Date statusTime;
    private Date createTime;

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
    @Column(name = "company_id", nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "meeting_type_id", nullable = false)
    public Integer getMeetingTypeId() {
        return meetingTypeId;
    }

    public void setMeetingTypeId(Integer meetingTypeId) {
        this.meetingTypeId = meetingTypeId;
    }

    @Basic
    @Column(name = "theme", nullable = true, length = 64)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "descri", nullable = true, length = 255)
    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    @Basic
    @Column(name = "mode", nullable = true, length = 2)
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Basic
    @Column(name = "initiator_user_id", nullable = true)
    public Integer getInitiatorUserId() {
        return initiatorUserId;
    }

    public void setInitiatorUserId(Integer initiatorUserId) {
        this.initiatorUserId = initiatorUserId;
    }

    @Basic
    @Column(name = "begin_time", nullable = true)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "session_length", nullable = true)
    public Integer getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }

    @Basic
    @Column(name = "host_user_id", nullable = true, length = 64)
    public String getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(String hostUserId) {
        this.hostUserId = hostUserId;
    }

    @Basic
    @Column(name = "recorder_user_id", nullable = true, length = 64)
    public String getRecorderUserId() {
        return recorderUserId;
    }

    public void setRecorderUserId(String recorderUserId) {
        this.recorderUserId = recorderUserId;
    }

    @Basic
    @Column(name = "data", nullable = true, length = 500)
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "requirement", nullable = true, length = 225)
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Basic
    @Column(name = "party_organization_id", nullable = true)
    public Integer getPartyOrganizationId() {
        return partyOrganizationId;
    }

    public void setPartyOrganizationId(Integer partyOrganizationId) {
        this.partyOrganizationId = partyOrganizationId;
    }

    @Basic
    @Column(name = "is_synchronous_live", nullable = true, length = 2)
    public String getIsSynchronousLive() {
        return isSynchronousLive;
    }

    public void setIsSynchronousLive(String isSynchronousLive) {
        this.isSynchronousLive = isSynchronousLive;
    }

    @Basic
    @Column(name = "other_settings", nullable = true, length = 2)
    public String getOtherSettings() {
        return otherSettings;
    }

    public void setOtherSettings(String otherSettings) {
        this.otherSettings = otherSettings;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sign_qrcode", nullable = true, length = 255)
    public String getSignQrcode() {
        return signQrcode;
    }

    public void setSignQrcode(String signQrcode) {
        this.signQrcode = signQrcode;
    }

    @Basic
    @Column(name = "release_terminal_type", nullable = true, length = 2)
    public String getReleaseTerminalType() {
        return releaseTerminalType;
    }

    public void setReleaseTerminalType(String releaseTerminalType) {
        this.releaseTerminalType = releaseTerminalType;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 32)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "county", nullable = true, length = 32)
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "detail_address", nullable = true, length = 128)
    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Basic
    @Column(name = "full_address", nullable = true, length = 255)
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
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
        Meeting meeting = (Meeting) o;
        return id == meeting.id &&
                companyId == meeting.companyId &&
                meetingTypeId == meeting.meetingTypeId &&
                Objects.equals(theme, meeting.theme) &&
                Objects.equals(descri, meeting.descri) &&
                Objects.equals(mode, meeting.mode) &&
                Objects.equals(initiatorUserId, meeting.initiatorUserId) &&
                Objects.equals(beginTime, meeting.beginTime) &&
                Objects.equals(sessionLength, meeting.sessionLength) &&
                Objects.equals(hostUserId, meeting.hostUserId) &&
                Objects.equals(recorderUserId, meeting.recorderUserId) &&
                Objects.equals(data, meeting.data) &&
                Objects.equals(requirement, meeting.requirement) &&
                Objects.equals(partyOrganizationId, meeting.partyOrganizationId) &&
                Objects.equals(isSynchronousLive, meeting.isSynchronousLive) &&
                Objects.equals(otherSettings, meeting.otherSettings) &&
                Objects.equals(password, meeting.password) &&
                Objects.equals(signQrcode, meeting.signQrcode) &&
                Objects.equals(releaseTerminalType, meeting.releaseTerminalType) &&
                Objects.equals(province, meeting.province) &&
                Objects.equals(city, meeting.city) &&
                Objects.equals(county, meeting.county) &&
                Objects.equals(detailAddress, meeting.detailAddress) &&
                Objects.equals(fullAddress, meeting.fullAddress) &&
                Objects.equals(status, meeting.status) &&
                Objects.equals(statusTime, meeting.statusTime) &&
                Objects.equals(createTime, meeting.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, companyId, meetingTypeId, theme, descri, mode, initiatorUserId, beginTime, sessionLength, hostUserId, recorderUserId, data, requirement, partyOrganizationId, isSynchronousLive, otherSettings, password, signQrcode, releaseTerminalType, province, city, county, detailAddress, fullAddress, status, statusTime, createTime);
    }
}
