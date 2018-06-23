package model;

/**
 * Created by admin on 6/18/2018.
 */

public class SoldBookModel {
    int bookimage;
    String bookname;
    String writer;
    String deductprice;
    String actualprice;
    String savedpercent;
    float rating;

    public SoldBookModel(int bookimage, String bookname, String writer, String deductprice, String actualprice, String savedpercent, float rating) {
        this.bookimage = bookimage;
        this.bookname = bookname;
        this.writer = writer;
        this.deductprice = deductprice;
        this.actualprice = actualprice;
        this.savedpercent = savedpercent;
        this.rating = rating;
    }

    public int getBookimage() {
        return bookimage;
    }

    public void setBookimage(int bookimage) {
        this.bookimage = bookimage;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDeductprice() {
        return deductprice;
    }

    public void setDeductprice(String deductprice) {
        this.deductprice = deductprice;
    }

    public String getActualprice() {
        return actualprice;
    }

    public void setActualprice(String actualprice) {
        this.actualprice = actualprice;
    }

    public String getSavedpercent() {
        return savedpercent;
    }

    public void setSavedpercent(String savedpercent) {
        this.savedpercent = savedpercent;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
