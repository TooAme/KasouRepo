package com.chenhy.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A ImportHistory.
 */
@Entity
@Table(name = "import_history")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ImportHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "uuid", length = 36, nullable = false)
    private UUID uuid;

    @Column(name = "tcih_code")
    private String tcihCode;

    @Column(name = "tcih_filename")
    private String tcihFilename;

    @Column(name = "tcih_importtime")
    private Instant tcihImporttime;

    @Column(name = "tcih_status")
    private Boolean tcihStatus;

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

    public ImportHistory id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public ImportHistory uuid(UUID uuid) {
        this.setUuid(uuid);
        return this;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTcihCode() {
        return this.tcihCode;
    }

    public ImportHistory tcihCode(String tcihCode) {
        this.setTcihCode(tcihCode);
        return this;
    }

    public void setTcihCode(String tcihCode) {
        this.tcihCode = tcihCode;
    }

    public String getTcihFilename() {
        return this.tcihFilename;
    }

    public ImportHistory tcihFilename(String tcihFilename) {
        this.setTcihFilename(tcihFilename);
        return this;
    }

    public void setTcihFilename(String tcihFilename) {
        this.tcihFilename = tcihFilename;
    }

    public Instant getTcihImporttime() {
        return this.tcihImporttime;
    }

    public ImportHistory tcihImporttime(Instant tcihImporttime) {
        this.setTcihImporttime(tcihImporttime);
        return this;
    }

    public void setTcihImporttime(Instant tcihImporttime) {
        this.tcihImporttime = tcihImporttime;
    }

    public Boolean getTcihStatus() {
        return this.tcihStatus;
    }

    public ImportHistory tcihStatus(Boolean tcihStatus) {
        this.setTcihStatus(tcihStatus);
        return this;
    }

    public void setTcihStatus(Boolean tcihStatus) {
        this.tcihStatus = tcihStatus;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public ImportHistory createBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Instant getCreateTime() {
        return this.createTime;
    }

    public ImportHistory createTime(Instant createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public ImportHistory updateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Instant getUpdateTime() {
        return this.updateTime;
    }

    public ImportHistory updateTime(Instant updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return this.delFlag;
    }

    public ImportHistory delFlag(Boolean delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return this.remark;
    }

    public ImportHistory remark(String remark) {
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
        if (!(o instanceof ImportHistory)) {
            return false;
        }
        return getId() != null && getId().equals(((ImportHistory) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImportHistory{" +
            "id=" + getId() +
            ", uuid='" + getUuid() + "'" +
            ", tcihCode='" + getTcihCode() + "'" +
            ", tcihFilename='" + getTcihFilename() + "'" +
            ", tcihImporttime='" + getTcihImporttime() + "'" +
            ", tcihStatus='" + getTcihStatus() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
