package com.hitest.app.entities;

import com.hitest.app.enums.StatusAction;

import javax.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String text;
    private StatusAction statusAction;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public StatusAction getStatusAction() {
        return statusAction;
    }

    public void setStatusAction(StatusAction statusAction) {
        this.statusAction = statusAction;
    }
}
