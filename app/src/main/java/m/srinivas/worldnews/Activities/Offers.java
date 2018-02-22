package m.srinivas.worldnews.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import m.srinivas.worldnews.Adapters.homeAdapter;
import m.srinivas.worldnews.Constants.menulist;
import m.srinivas.worldnews.Models.Home_Items;
import m.srinivas.worldnews.R;

public class Offers extends Activity implements View.OnClickListener {
    LinearLayout home_img, cat_img, search_img, offer_img, basket_img;
    RecyclerView recyclerview;
    ArrayList<Home_Items> data;
    ImageView offer_ll;
    DrawerLayout drawble_ll;
    LinearLayout mll;
    ImageView menu_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers);
        offer_ll = (ImageView) findViewById(R.id.offer_ll);
        home_img = (LinearLayout) findViewById(R.id.home_img);
        cat_img = (LinearLayout) findViewById(R.id.cat_img);
        search_img = (LinearLayout) findViewById(R.id.search_img);
        offer_img = (LinearLayout) findViewById(R.id.offer_img);
        basket_img = (LinearLayout) findViewById(R.id.basket_img);
        menu_img = (ImageView) findViewById(R.id.menu_img);
        drawble_ll = (DrawerLayout) findViewById(R.id.drawble_ll);
        mll = (LinearLayout) findViewById(R.id.mll);
        // onclick's for footer
        home_img.setOnClickListener(this);
        cat_img.setOnClickListener(this);
        search_img.setOnClickListener(this);
        offer_img.setOnClickListener(this);
        basket_img.setOnClickListener(this);
        drawble_ll.setOnClickListener(this);
        menu_img.setOnClickListener(this);

        offer_ll.setImageDrawable(getResources().getDrawable(R.drawable.offer_red));

        recyclerview = (RecyclerView) findViewById(R.id.left_drawer);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
       /* data = new ArrayList<ExpandableListAdapter.Item>();
        data = new menulist().senddata();
        recyclerview.setAdapter(new ExpandableListAdapter(data, this));
*/
        data = new ArrayList<Home_Items>();
        data = new menulist().sendhome();
        recyclerview.setAdapter(new homeAdapter(data, this, R.layout.homeadapter));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_img:
                drawble_ll.openDrawer(mll);
                break;
            case R.id.home_img:
                Intent offer = new Intent(Offers.this, Home.class);
                startActivity(offer);
                finish();
                break;
            case R.id.cat_img:
                Intent cat = new Intent(Offers.this, Category.class);
                startActivity(cat);
                finish();
                break;
            case R.id.search_img:
                Intent search = new Intent(Offers.this, Ads.class);
                startActivity(search);
                finish();
                break;
            case R.id.offer_img:
                offer_ll.setImageDrawable(getResources().getDrawable(R.drawable.offer_red));
                break;
            case R.id.basket_img:
                Intent basket = new Intent(Offers.this, Basket.class);
                startActivity(basket);
                finish();
                break;

        }
    }
}
