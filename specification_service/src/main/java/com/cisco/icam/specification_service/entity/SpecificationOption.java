package com.cisco.icam.specification_service.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tb_specification_option")
public class SpecificationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "option_name")
    private String optionName;

    @Column(name = "spec_id")
    private long specId;

    @Column(name = "orders")
    private int orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public long getSpecId() {
        return specId;
    }

    public void setSpecId(long specId) {
        this.specId = specId;
    }

    public int getOrder() {
        return orders;
    }

    public void setOrder(int orders) {
        this.orders = orders;
    }
}
