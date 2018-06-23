package model;

/**
 * Created by admin on 6/13/2018.
 */

public class HorizotalitemsMenu {
    int image;
    String catname;

    public HorizotalitemsMenu(int image, String catname) {
        this.image = image;
        this.catname = catname;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }


}
