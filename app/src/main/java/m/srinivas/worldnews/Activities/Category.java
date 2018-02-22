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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import m.srinivas.worldnews.Adapters.Category_Adapter;
import m.srinivas.worldnews.Adapters.homeAdapter;
import m.srinivas.worldnews.Constants.Cat;
import m.srinivas.worldnews.Constants.menulist;
import m.srinivas.worldnews.Models.Home_Items;
import m.srinivas.worldnews.R;


public class Category extends Activity implements View.OnClickListener{
    LinearLayout home_img, cat_img, search_img, offer_img, basket_img;
    RelativeLayout pager_rl;
    RecyclerView recyclerview,item_recyler_view;
    ArrayList<Home_Items> data;
    ArrayList<Cat> cats;
    ImageView cat_ll;
    DrawerLayout drawble_ll;
    LinearLayout mll;
    ImageView menu_img;
    TextView glheader_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        pager_rl = (RelativeLayout) findViewById(R.id.pager_rl);
        pager_rl.setVisibility(View.GONE);
        glheader_txt = (TextView) findViewById(R.id.glheader_txt);
        cat_ll = (ImageView) findViewById(R.id.cat_ll);
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
        glheader_txt.setText("Shop By Category");

        recyclerview = (RecyclerView) findViewById(R.id.left_drawer);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<Home_Items>();
        data = new menulist().sendhome();
        recyclerview.setAdapter(new homeAdapter(data, this, R.layout.homeadapter));

        cat_ll.setImageDrawable(getResources().getDrawable(R.drawable.category_red));

        item_recyler_view = (RecyclerView) findViewById(R.id.item_recyler_view);
        item_recyler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cats = new ArrayList<Cat>();
        cats = new menulist().sendcats();
        item_recyler_view.setAdapter(new Category_Adapter(cats, R.layout.cat, this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_img:
                drawble_ll.openDrawer(mll);
                break;
            case R.id.home_img:
                Intent cat = new Intent(Category.this,Home.class);
                startActivity(cat);
                finish();
                break;
            case R.id.cat_img:
                cat_ll.setImageDrawable(getResources().getDrawable(R.drawable.category_red));
                break;
            case R.id.search_img:
                Intent search = new Intent(Category.this,Ads.class);
                startActivity(search);
                finish();
                break;
            case R.id.offer_img:
                Intent offer = new Intent(Category.this,Offers.class);
                startActivity(offer);
                finish();
                break;
            case R.id.basket_img:
                Intent basket = new Intent(Category.this,Basket.class);
                startActivity(basket);
                finish();
                break;

        }
    }
}
