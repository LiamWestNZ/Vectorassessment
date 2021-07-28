package com.vectortest.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ERROR")

public class ErrorEntity {

    @Id
    @Column(name="CODE", nullable = false)
    private String code;

    @Column(name = "MESSAGE", nullable = false)
    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
