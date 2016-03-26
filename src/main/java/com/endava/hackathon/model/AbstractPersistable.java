package com.endava.hackathon.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractPersistable implements Serializable {

    @Version
    @Column(name="VERSION")
    private int version;

    @Column(name = "CREATED")
    private Date created;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
