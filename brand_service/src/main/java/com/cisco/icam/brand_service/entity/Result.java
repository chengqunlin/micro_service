package com.cisco.icam.brand_service.entity;

import lombok.Data;

@Data
public class Result {
    private Boolean flag;	// 是否成功
    private String message;	// 操作信息
    public Result(Boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }
    public Boolean getFlag() {
        return flag;
    }
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
