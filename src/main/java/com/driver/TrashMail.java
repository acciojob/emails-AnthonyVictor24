package com.driver;

import java.util.Date;

public class TrashMail {
    private Date date;
    private String Sender_T;
    private String message_T;

    public TrashMail(Date date, String sender_T, String message_T) {
        this.date = date;
        Sender_T = sender_T;
        this.message_T = message_T;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSender_T() {
        return Sender_T;
    }

    public void setSender_T(String sender_T) {
        Sender_T = sender_T;
    }

    public String getMessage_T() {
        return message_T;
    }

    public void setMessage_T(String message_T) {
        this.message_T = message_T;
    }

    @Override
    public String toString() {
        return "TrashMail{" +
                "date=" + date +
                ", Sender_T='" + Sender_T + '\'' +
                ", message_T='" + message_T + '\'' +
                '}';
    }
}
