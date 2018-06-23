package model;

/**
 * Created by admin on 6/16/2018.
 */

public class ImageModel {
    int Image;
    String name;

    public ImageModel(int image, String name) {
        Image = image;
        this.name = name;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
