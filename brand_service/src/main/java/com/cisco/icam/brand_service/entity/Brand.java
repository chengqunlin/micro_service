package com.cisco.icam.brand_service.entity;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tb_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="first_char")
    private String firstChar;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

}
