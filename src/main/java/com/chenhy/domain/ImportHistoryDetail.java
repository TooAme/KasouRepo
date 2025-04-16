package com.chenhy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A ImportHistoryDetail.
 */
@Entity
@Table(name = "import_history_detail")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ImportHistoryDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "uuid", length = 36, nullable = false)
    private UUID uuid;

    @Column(name = "tcihd_pid")
    private String tcihdPid;

    @Column(name = "tcihd_line")
    private String tcihdLine;

    @Column(name = "tcihd_error")
    private String tcihdError;

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

    public ImportHistoryDetail id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public ImportHistoryDetail uuid(UUID uuid) {
        this.setUuid(uuid);
        return this;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTcihdPid() {
        return this.tcihdPid;
    }

    public ImportHistoryDetail tcihdPid(String tcihdPid) {
        this.setTcihdPid(tcihdPid);
        return this;
    }

    public void setTcihdPid(String tcihdPid) {
        this.tcihdPid = tcihdPid;
    }

    public String getTcihdLine() {
        return this.tcihdLine;
    }

    public ImportHistoryDetail tcihdLine(String tcihdLine) {
        this.setTcihdLine(tcihdLine);
        return this;
    }

    public void setTcihdLine(String tcihdLine) {
        this.tcihdLine = tcihdLine;
    }

    public String getTcihdError() {
        return this.tcihdError;
    }

    public ImportHistoryDetail tcihdError(String tcihdError) {
        this.setTcihdError(tcihdError);
        return this;
    }

    public void setTcihdError(String tcihdError) {
        this.tcihdError = tcihdError;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public ImportHistoryDetail createBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Instant getCreateTime() {
        return this.createTime;
    }

    public ImportHistoryDetail createTime(Instant createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public ImportHistoryDetail updateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Instant getUpdateTime() {
        return this.updateTime;
    }

    public ImportHistoryDetail updateTime(Instant updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return this.delFlag;
    }

    public ImportHistoryDetail delFlag(Boolean delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return this.remark;
    }

    public ImportHistoryDetail remark(String remark) {
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
        if (!(o instanceof ImportHistoryDetail)) {
            return false;
        }
        return getId() != null && getId().equals(((ImportHistoryDetail) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImportHistoryDetail{" +
            "id=" + getId() +
            ", uuid='" + getUuid() + "'" +
            ", tcihdPid='" + getTcihdPid() + "'" +
            ", tcihdLine='" + getTcihdLine() + "'" +
            ", tcihdError='" + getTcihdError() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
