package m.srinivas.worldnews.Models;

/**
 * Created by srinivas on 18/02/18.
 */

public class Agri_Items {
    int agri_img;
    String agri_title;
    public Agri_Items(int agri_img, String agri_title){
        this.agri_img = agri_img;this.agri_title = agri_title;
    }

    public String getAgri_title() {
        return agri_title;
    }

    public int getAgri_img() {
        return agri_img;
    }
}
