package com.softaria.quiz.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Identifiable, Serializable, Comparable<BaseEntity> {

    public static final String ID = "id";

    @Id
    @Column(name = "id", updatable = false)
    @JsonProperty
    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (getId() == null) {
            return false;
        }
        if (object instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) object;
            if (entity.getId() == null) {
                return false;
            }
            return entity.getId().equals(getId());
        }
        return false;
    }

    @Override
    public int compareTo(BaseEntity baseEntity) {
        if (getId() == null) {
            return -1;
        }
        if (baseEntity.getId() == null) {
            return 1;
        }
        return getId().compareTo(baseEntity.getId());
    }
}
