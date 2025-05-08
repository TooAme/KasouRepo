package com.chenhy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A SSImport.
 */
@Entity
@Table(name = "t_ss_import")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SSImport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "uuid", length = 36, nullable = false)
    private UUID uuid;

    @Column(name = "ss_create_by")
    private String ssCreateBy;

    @Column(name = "ss_filename")
    private String ssFilename;

    @Column(name = "ss_b_code")
    private String ssBCode;

    @Column(name = "ss_sub_b_code")
    private String ssSubBCode;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_time")
    private Instant updateTime;

    @Column(name = "del_flag")
    private Boolean delFlag;

    @Column(name = "remark")
    private String remark;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public SSImport id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public SSImport uuid(UUID uuid) {
        this.setUuid(uuid);
        return this;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSsCreateBy() {
        return this.ssCreateBy;
    }

    public SSImport ssCreateBy(String ssCreateBy) {
        this.setSsCreateBy(ssCreateBy);
        return this;
    }

    public void setSsCreateBy(String ssCreateBy) {
        this.ssCreateBy = ssCreateBy;
    }

    public String getSsFilename() {
        return this.ssFilename;
    }

    public SSImport ssFilename(String ssFilename) {
        this.setSsFilename(ssFilename);
        return this;
    }

    public void setSsFilename(String ssFilename) {
        this.ssFilename = ssFilename;
    }

    public String getSsBCode() {
        return this.ssBCode;
    }

    public SSImport ssBCode(String ssBCode) {
        this.setSsBCode(ssBCode);
        return this;
    }

    public void setSsBCode(String ssBCode) {
        this.ssBCode = ssBCode;
    }

    public String getSsSubBCode() {
        return this.ssSubBCode;
    }

    public SSImport ssSubBCode(String ssSubBCode) {
        this.setSsSubBCode(ssSubBCode);
        return this;
    }

    public void setSsSubBCode(String ssSubBCode) {
        this.ssSubBCode = ssSubBCode;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public SSImport createBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Instant getCreateTime() {
        return this.createTime;
    }

    public SSImport createTime(Instant createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public SSImport updateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Instant getUpdateTime() {
        return this.updateTime;
    }

    public SSImport updateTime(Instant updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return this.delFlag;
    }

    public SSImport delFlag(Boolean delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return this.remark;
    }

    public SSImport remark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SSImport)) {
            return false;
        }
        return getId() != null && getId().equals(((SSImport) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SSImport{" +
            "id=" + getId() +
            ", uuid='" + getUuid() + "'" +
            ", ssCreateBy='" + getSsCreateBy() + "'" +
            ", ssFilename='" + getSsFilename() + "'" +
            ", ssBCode='" + getSsBCode() + "'" +
            ", ssSubBCode='" + getSsSubBCode() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
