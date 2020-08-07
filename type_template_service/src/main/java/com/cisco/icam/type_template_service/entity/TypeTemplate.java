package com.cisco.icam.type_template_service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "tb_type_template")
@Data
public class TypeTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "spec_ids")
    private String specIds;

    @Column(name = "brand_ids")
    private String brandIds;

    @Column(name = "custom_attribute_items")
    private String customAttributeItems;

    public TypeTemplate(){}
    public TypeTemplate(long id) {
        this.id =id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecIds() {
        return specIds;
    }

    public void setSpecIds(String specIds) {
        this.specIds = specIds;
    }

    public String getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }
}
