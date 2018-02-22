package m.srinivas.worldnews.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import m.srinivas.worldnews.R;

/**
 * Created by srinivas on 01/02/18.
 */

public class SliderPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    Activity activity;
    ArrayList<Integer> image_arraylist;
    ArrayList<String> names= new ArrayList<>();
    Animation move;

    public SliderPagerAdapter(Activity activity, ArrayList<Integer> image_arraylist) {
        this.activity = activity;
        this.image_arraylist = image_arraylist;
        names.add("Free Listing");
        names.add("Land Scaping");
        names.add("Agri Skilled Labour");
        names.add("Market World");
        move = AnimationUtils.loadAnimation(activity.getApplicationContext(),
                R.anim.move);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.layout_slide, container, false);
        ImageView im_slider = (ImageView) view.findViewById(R.id.im_slider);
        TextView mytext = (TextView) view.findViewById(R.id.mytext);
        im_slider.setImageDrawable(activity.getResources().getDrawable(image_arraylist.get(position)));
        /*Picasso.with(activity.getApplicationContext())
                .load(image_arraylist.get(position))
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher)         // optional
                .into(im_slider);*/
        im_slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getBaseContext(), " " + image_arraylist.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mytext.setText(names.get(position));
        mytext.startAnimation(move);
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
