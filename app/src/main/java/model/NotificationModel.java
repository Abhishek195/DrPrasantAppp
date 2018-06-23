package model;

/**
 * Created by admin on 6/20/2018.
 */

public class NotificationModel {
    String name;
    String subject;
    String date;

    public NotificationModel(String name, String subject, String date) {
        this.name = name;
        this.subject = subject;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
