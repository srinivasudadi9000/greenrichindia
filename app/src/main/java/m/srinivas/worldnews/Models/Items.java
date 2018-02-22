package m.srinivas.worldnews.Models;

/**
 * Created by srinivas on 05/02/18.
 */

public class Items {
    int image;
    String title,description,type,old_price,new_price;
    public Items(String title, String description, String type, String old_price, String new_price, int image){
        this.title = title;this.description = description;this.type = type;this.old_price= old_price;this.new_price = new_price;this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getNew_price() {
        return new_price;
    }

    public String getOld_price() {
        return old_price;
    }

    public String getType() {
        return type;
    }

    public int getImage() {
        return image;
    }
}
