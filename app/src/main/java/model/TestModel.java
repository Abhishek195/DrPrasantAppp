package model;

/**
 * Created by admin on 6/20/2018.
 */

public class TestModel {
    String testname;
    String sylabus;
    String cover;
    String question;
    String minute;

    public TestModel(String testname, String sylabus, String cover, String question, String minute) {
        this.testname = testname;
        this.sylabus = sylabus;
        this.cover = cover;
        this.question = question;
        this.minute = minute;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getSylabus() {
        return sylabus;
    }

    public void setSylabus(String sylabus) {
        this.sylabus = sylabus;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
