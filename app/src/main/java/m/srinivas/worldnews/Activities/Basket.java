package m.srinivas.worldnews.Activities;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import m.srinivas.worldnews.Adapters.homeAdapter;
import m.srinivas.worldnews.Constants.menulist;
import m.srinivas.worldnews.Models.Home_Items;
import m.srinivas.worldnews.R;


public class Basket extends Activity implements View.OnClickListener {
    LinearLayout home_img, cat_img, search_img, offer_img, basket_img;
    RecyclerView recyclerview;
    ArrayList<Home_Items> data;
    ImageView basket_ll;
    LinearLayout mll;
    TextView login, signup;
    DrawerLayout drawble_ll;
    ImageView menu_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket);
        menu_img = (ImageView) findViewById(R.id.menu_img);
        signup = (TextView) findViewById(R.id.signup);
        login = (TextView) findViewById(R.id.login);
        basket_ll = (ImageView) findViewById(R.id.basket_ll);
        home_img = (LinearLayout) findViewById(R.id.home_img);
        cat_img = (LinearLayout) findViewById(R.id.cat_img);
        search_img = (LinearLayout) findViewById(R.id.search_img);
        offer_img = (LinearLayout) findViewById(R.id.offer_img);
        basket_img = (LinearLayout) findViewById(R.id.basket_img);
        drawble_ll = (DrawerLayout) findViewById(R.id.drawble_ll);
        mll = (LinearLayout) findViewById(R.id.mll);

        // onclick's for footer
        menu_img.setOnClickListener(this);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
        home_img.setOnClickListener(this);
        cat_img.setOnClickListener(this);
        search_img.setOnClickListener(this);
        offer_img.setOnClickListener(this);
        basket_img.setOnClickListener(this);
        recyclerview = (RecyclerView) findViewById(R.id.left_drawer);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        /*data = new ArrayList<ExpandableListAdapter.Item>();
        data = new menulist().senddata();
        recyclerview.setAdapter(new ExpandableListAdapter(data, this));
*/
        data = new ArrayList<Home_Items>();
        data = new menulist().sendhome();
        recyclerview.setAdapter(new homeAdapter(data, this, R.layout.homeadapter));
        basket_ll.setImageDrawable(getResources().getDrawable(R.drawable.basket_red));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_img:
                drawble_ll.openDrawer(mll);
                break;
            case R.id.signup:
                callanim(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.brown), signup);
                break;
            case R.id.login:
                callanim(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.brown), login);
                break;
            case R.id.home_img:
                Intent home = new Intent(Basket.this, Home.class);
                startActivity(home);
                finish();
                break;
            case R.id.cat_img:
                Intent cat = new Intent(Basket.this, Category.class);
                startActivity(cat);
                finish();
                break;
            case R.id.search_img:
                Intent search = new Intent(Basket.this, Ads.class);
                startActivity(search);
                finish();
                break;
            case R.id.offer_img:
                Intent offer = new Intent(Basket.this, Offers.class);
                startActivity(offer);
                finish();
                break;
            case R.id.basket_img:
                basket_ll.setImageDrawable(getResources().getDrawable(R.drawable.basket_red));

                break;

        }
    }

    public void callanim(final int colorcode, final int fullcolor, final TextView cardView) {
        int x = cardView.getTop();
        int y = cardView.getLeft();

        int startRadius = Math.max(cardView.getWidth(), cardView.getHeight());
        int endRadius = 30;

        Animator anim = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(cardView, x, y, startRadius, endRadius);
        }
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                cardView.setBackgroundColor(colorcode);
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onAnimationEnd(Animator animator) {
                cardView.setBackgroundColor(fullcolor);
                 Intent intent = new Intent(Basket.this, Login.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                cardView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            }
        });
        anim.start();
    }

}
