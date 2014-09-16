package com.devbian.domain;

import java.util.Date;

/**
 * Created by phnix on 2014/9/10.
 */
public class Event {
    private Long id;
    private Date date;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
