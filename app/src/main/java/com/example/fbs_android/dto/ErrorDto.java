package com.example.fbs_android.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "error")
public class ErrorDto {
@Element(name = "info")
    private String msg;

    public ErrorDto() {
    }

    public ErrorDto(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
