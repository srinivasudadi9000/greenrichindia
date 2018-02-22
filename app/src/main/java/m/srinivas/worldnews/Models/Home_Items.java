package m.srinivas.worldnews.Models;

/**
 * Created by srinivas on 16/02/18.
 */

public class Home_Items {
    int drawable;
    String name;
    public Home_Items(int drawable, String name){
        this.drawable = drawable;
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getName() {
        return name;
    }
}
