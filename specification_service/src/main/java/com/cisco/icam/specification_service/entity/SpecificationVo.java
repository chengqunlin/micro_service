package com.cisco.icam.specification_service.entity;

import java.util.List;

public class SpecificationVo {

    private Specification specification;						// 规格
    private List<SpecificationOption> specificationOptionList;	// 规格属性

    public Specification getSpecification() {
        return specification;
    }
    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
    public List<SpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }
    public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }
}
