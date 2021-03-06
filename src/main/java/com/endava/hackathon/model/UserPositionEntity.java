package com.endava.hackathon.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER_POSITION")
public class UserPositionEntity extends AbstractPersistable implements NamedEntity, Serializable {

    public static final String NAME = "name";
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
