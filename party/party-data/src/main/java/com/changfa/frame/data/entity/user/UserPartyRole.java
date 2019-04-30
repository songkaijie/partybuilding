package com.changfa.frame.data.entity.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
@Entity
@Table(name = "user_party_role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class UserPartyRole {
    private Integer id;
    private Integer userId;
    private Integer companyId;
    private Integer partyRoleId;
    private Integer partyOrganizationId;
    private Integer seq;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "party_role_id")
    public Integer getPartyRoleId() {
        return partyRoleId;
    }

    public void setPartyRoleId(Integer partyRoleId) {
        this.partyRoleId = partyRoleId;
    }

    @Basic
    @Column(name = "party_organization_id")
    public Integer getPartyOrganizationId() {
        return partyOrganizationId;
    }

    public void setPartyOrganizationId(Integer partyOrganizationId) {
        this.partyOrganizationId = partyOrganizationId;
    }

    @Basic
    @Column(name = "seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPartyRole that = (UserPartyRole) o;
        return id == that.id &&
                userId == that.userId &&
                companyId == that.companyId &&
                Objects.equals(partyRoleId, that.partyRoleId) &&
                Objects.equals(partyOrganizationId, that.partyOrganizationId) &&
                Objects.equals(seq, that.seq);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, companyId, partyRoleId, partyOrganizationId, seq);
    }
}
