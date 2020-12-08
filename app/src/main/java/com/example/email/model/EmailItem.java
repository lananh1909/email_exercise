package com.example.email.model;

import android.graphics.Color;

import java.util.Random;

public class EmailItem {
    char text;
    String fromName;
    String fromEmail;
    String content;
    String time;
    boolean checkImportant;
    int color;
    Random random = new Random();

    public EmailItem(String fromName, String content, String time, String fromEmail) {
        this.text = fromName.charAt(0);
        this.fromName = fromName;
        this.content = content;
        this.time = time;
        this.fromEmail = fromEmail;
        checkImportant = false;

        this.color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getText() {
        return String.valueOf(text);
    }

    public void setText(char text) {
        this.text = text;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCheckImportant() {
        return checkImportant;
    }

    public void setCheckImportant(boolean checkImportant) {
        this.checkImportant = checkImportant;
    }
}

