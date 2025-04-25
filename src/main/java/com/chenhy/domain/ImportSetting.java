package com.chenhy.domain;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * A ImportSetting.
 */
@Entity
@Table(name = "import_setting")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ImportSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tcis_code")
    private String tcisCode;

    @Column(name = "tcis_type")
    private String tcisType;

    @Column(name = "tcis_incol")
    private String tcisIncol;

    @Column(name = "tcis_editrule")
    private String tcisEditrule;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ImportSetting id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTcisCode() {
        return this.tcisCode;
    }

    public ImportSetting tcisCode(String tcisCode) {
        this.setTcisCode(tcisCode);
        return this;
    }

    public void setTcisCode(String tcisCode) {
        this.tcisCode = tcisCode;
    }

    public String getTcisType() {
        return this.tcisType;
    }

    public ImportSetting tcisType(String tcisType) {
        this.setTcisType(tcisType);
        return this;
    }

    public void setTcisType(String tcisType) {
        this.tcisType = tcisType;
    }

    public String getTcisIncol() {
        return this.tcisIncol;
    }

    public ImportSetting tcisIncol(String tcisIncol) {
        this.setTcisIncol(tcisIncol);
        return this;
    }

    public void setTcisIncol(String tcisIncol) {
        this.tcisIncol = tcisIncol;
    }

    public String getTcisEditrule() {
        return this.tcisEditrule;
    }

    public ImportSetting tcisEditrule(String tcisEditrule) {
        this.setTcisEditrule(tcisEditrule);
        return this;
    }

    public void setTcisEditrule(String tcisEditrule) {
        this.tcisEditrule = tcisEditrule;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImportSetting)) {
            return false;
        }
        return getId() != null && getId().equals(((ImportSetting) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImportSetting{" +
            "id=" + getId() +
            ", tcisCode='" + getTcisCode() + "'" +
            ", tcisType='" + getTcisType() + "'" +
            ", tcisIncol='" + getTcisIncol() + "'" +
            ", tcisEditrule='" + getTcisEditrule() + "'" +
            "}";
    }
}
