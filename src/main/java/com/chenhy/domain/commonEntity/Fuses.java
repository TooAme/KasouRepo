package com.chenhy.domain.commonEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Fuses.
 */
@Entity
@Table(name = "fuses")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Fuses implements Serializable {

    @Id
    @NotNull
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @NotNull
    @Column(name = "part_number", nullable = false)
    private String partNumber;

    @Column(name = "part_type")
    private String partType;

    @Column(name = "value")
    private String value;

    @Column(name = "schematic_part")
    private String schematicPart;

    @Column(name = "rating_voltage")
    private String ratingVoltage;

    @Column(name = "rating_electricity")
    private String ratingElectricity;

    @Column(name = "characteristics")
    private String characteristics;

    @Column(name = "tolerance")
    private String tolerance;

    @Column(name = "manufacture")
    private String manufacture;

    @Column(name = "b_code")
    private String bCode;

    @Column(name = "parts_name")
    private String partsName;

    @Column(name = "item_registration_classification")
    private String itemRegistrationClassification;

    @Column(name = "spice_model")
    private String spiceModel;

    @Column(name = "pcb_footprint")
    private String pcbFootPrint;

    @Column(name = "del_flag")
    private Boolean delFlag;

    @Column(name = "remark")
    private String remark;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_time")
    private Instant updateTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Fuses id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    // 删除 id 字段相关定义
    // 原有的 @Id 注解、@GeneratedValue 注解和 id 字段定义会被删除

    // 删除原有的 uuid 相关方法
    // public UUID getUuid() { ... }
    // public Fuses uuid(UUID uuid) { ... }
    // public void setUuid(UUID uuid) { ... }
    public String getPartNumber() {
        return this.partNumber;
    }

    public Fuses partNumber(String partNumber) {
        this.setPartNumber(partNumber);
        return this;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartType() {
        return this.partType;
    }

    public Fuses partType(String partType) {
        this.setPartType(partType);
        return this;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public String getValue() {
        return this.value;
    }

    public Fuses value(String value) {
        this.setValue(value);
        return this;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSchematicPart() {
        return this.schematicPart;
    }

    public Fuses schematicPart(String schematicPart) {
        this.setSchematicPart(schematicPart);
        return this;
    }

    public void setSchematicPart(String schematicPart) {
        this.schematicPart = schematicPart;
    }

    public String getRatingVoltage() {
        return this.ratingVoltage;
    }

    public Fuses ratingVoltage(String ratingVoltage) {
        this.setRatingVoltage(ratingVoltage);
        return this;
    }

    public void setRatingVoltage(String ratingVoltage) {
        this.ratingVoltage = ratingVoltage;
    }

    public String getRatingElectricity() {
        return this.ratingElectricity;
    }

    public Fuses ratingElectricity(String ratingElectricity) {
        this.setRatingElectricity(ratingElectricity);
        return this;
    }

    public void setRatingElectricity(String ratingElectricity) {
        this.ratingElectricity = ratingElectricity;
    }

    public String getCharacteristics() {
        return this.characteristics;
    }

    public Fuses characteristics(String characteristics) {
        this.setCharacteristics(characteristics);
        return this;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getTolerance() {
        return this.tolerance;
    }

    public Fuses tolerance(String tolerance) {
        this.setTolerance(tolerance);
        return this;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }

    public String getManufacture() {
        return this.manufacture;
    }

    public Fuses manufacture(String manufacture) {
        this.setManufacture(manufacture);
        return this;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getbCode() {
        return this.bCode;
    }

    public Fuses bCode(String bCode) {
        this.setbCode(bCode);
        return this;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getPartsName() {
        return this.partsName;
    }

    public Fuses partsName(String partsName) {
        this.setPartsName(partsName);
        return this;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getItemRegistrationClassification() {
        return this.itemRegistrationClassification;
    }

    public Fuses itemRegistrationClassification(String itemRegistrationClassification) {
        this.setItemRegistrationClassification(itemRegistrationClassification);
        return this;
    }

    public void setItemRegistrationClassification(String itemRegistrationClassification) {
        this.itemRegistrationClassification = itemRegistrationClassification;
    }

    public String getSpiceModel() {
        return this.spiceModel;
    }

    public Fuses spiceModel(String spiceModel) {
        this.setSpiceModel(spiceModel);
        return this;
    }

    public void setSpiceModel(String spiceModel) {
        this.spiceModel = spiceModel;
    }

    public String getPcbFootPrint() {
        return this.pcbFootPrint;
    }

    public Fuses pcbFootPrint(String pcbFootPrint) {
        this.setPcbFootPrint(pcbFootPrint);
        return this;
    }

    public void setPcbFootPrint(String pcbFootPrint) {
        this.pcbFootPrint = pcbFootPrint;
    }

    public Boolean getDelFlag() {
        return this.delFlag;
    }

    public Fuses delFlag(Boolean delFlag) {
        this.setDelFlag(delFlag);
        return this;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return this.remark;
    }

    public Fuses remark(String remark) {
        this.setRemark(remark);
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public Fuses createBy(String createBy) {
        this.setCreateBy(createBy);
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Instant getCreateTime() {
        return this.createTime;
    }

    public Fuses createTime(Instant createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public Fuses updateBy(String updateBy) {
        this.setUpdateBy(updateBy);
        return this;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Instant getUpdateTime() {
        return this.updateTime;
    }

    public Fuses updateTime(Instant updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fuses)) {
            return false;
        }
        return getId() != null && getId().equals(((Fuses) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Fuses{" +
            "id=" + getId() +
            ", partNumber='" + getPartNumber() + "'" +
            ", partType='" + getPartType() + "'" +
            ", value='" + getValue() + "'" +
            ", schematicPart='" + getSchematicPart() + "'" +
            ", ratingVoltage='" + getRatingVoltage() + "'" +
            ", ratingElectricity='" + getRatingElectricity() + "'" +
            ", characteristics='" + getCharacteristics() + "'" +
            ", tolerance='" + getTolerance() + "'" +
            ", manufacture='" + getManufacture() + "'" +
            ", bCode='" + getbCode() + "'" +
            ", partsName='" + getPartsName() + "'" +
            ", itemRegistrationClassification=" + getItemRegistrationClassification() +
            ", spiceModel='" + getSpiceModel() + "'" +
            ", pcbFootPrint='" + getPcbFootPrint() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
