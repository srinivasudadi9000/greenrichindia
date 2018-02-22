package m.srinivas.worldnews.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import m.srinivas.worldnews.Adapters.AgriItemsAdapter;
import m.srinivas.worldnews.Adapters.ExpandableListAdapter;
import m.srinivas.worldnews.Adapters.ItemsAdapter;
import m.srinivas.worldnews.Adapters.SliderPagerAdapter;
import m.srinivas.worldnews.Adapters.homeAdapter;
import m.srinivas.worldnews.Constants.menulist;
import m.srinivas.worldnews.Models.Agri_Items;
import m.srinivas.worldnews.Models.Home_Items;
import m.srinivas.worldnews.Models.Items;
import m.srinivas.worldnews.R;


public class Home extends Activity implements View.OnClickListener {
    LinearLayout mll;
    ImageView menu_img;
    RecyclerView recyclerview;
    ArrayList<ExpandableListAdapter.Item> data;
    ArrayList<Agri_Items> items;
    DrawerLayout drawble_ll;
    int spanCount = 3;
    Animation move;
    // this are for slider in andorid

    ViewPager vp_slider;
    LinearLayout ll_dots;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list;
    private TextView[] dots;
    int page_position = 0;

    //Home Adapter
    ArrayList<Home_Items> home_items;
    // Recylerview mention
    RecyclerView recyler_view, item_recyler_view;

    //footer icon id's
    LinearLayout home_img, cat_img, search_img, offer_img, basket_img;
    ImageView home_ll;
    TextView glheader_txt;

    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        glheader_txt = (TextView) findViewById(R.id.glheader_txt);
        home_ll = (ImageView) findViewById(R.id.home_ll);
        home_img = (LinearLayout) findViewById(R.id.home_img);
        cat_img = (LinearLayout) findViewById(R.id.cat_img);
        search_img = (LinearLayout) findViewById(R.id.search_img);
        offer_img = (LinearLayout) findViewById(R.id.offer_img);
        basket_img = (LinearLayout) findViewById(R.id.basket_img);
        drawble_ll = (DrawerLayout) findViewById(R.id.drawble_ll);
        mll = (LinearLayout) findViewById(R.id.mll);
        menu_img = (ImageView) findViewById(R.id.menu_img);
        recyclerview = (RecyclerView) findViewById(R.id.left_drawer);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        item_recyler_view = (RecyclerView) findViewById(R.id.item_recyler_view);
       // item_recyler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
       // item_recyler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        home_items = new ArrayList<Home_Items>();
        home_items = new menulist().sendhome();
        // recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        // recyclerview.setLayoutManager(new GridLayoutManager(this, spanCount, LinearLayoutManager.HORIZONTAL, false));
        //  recyclerview.setLayoutManager(new GridLayoutManager(this, spanCount));
        //  recyclerview.setLayoutManager(new GridLayoutManager(this, spanCount, LinearLayoutManager.HORIZONTAL, false));
        item_recyler_view.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));
        // recyclerview.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL));
        //recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        data = new ArrayList<ExpandableListAdapter.Item>();
        data = new menulist().senddata();
        //   recyclerview.setAdapter(new ExpandableListAdapter(data, this));
        recyclerview.setAdapter(new homeAdapter(home_items, this, R.layout.homeadapter));
        move = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.grow_from_left_bottom);
        items = new ArrayList<Agri_Items>();
        items = new menulist().sendagri();
        item_recyler_view.setAdapter(new AgriItemsAdapter(items, R.layout.agri_items, this));

      /*  // for set scrolling position starting here..
        RecyclerView.SmoothScroller smoothScroller = new
                LinearSmoothScroller(Home.this) {
                    @Override
                    protected int getVerticalSnapPreference() {
                        return LinearSmoothScroller.SNAP_TO_START;
                    }
                };
        int count = items.size();
        System.out.println("hellsd................." + count);
        smoothScroller.setTargetPosition(count);
        item_recyler_view.getLayoutManager().startSmoothScroll(smoothScroller);

        // here end
        // this two lines for swipe one cell on recyler
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(item_recyler_view);*/


        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                item_recyler_view.getContext(),
                DividerItemDecoration.VERTICAL
        );
       // item_recyler_view.addItemDecoration(mDividerItemDecoration);

        // onclick's for footer
        menu_img.setOnClickListener(this);
        home_img.setOnClickListener(this);
        cat_img.setOnClickListener(this);
        search_img.setOnClickListener(this);
        offer_img.setOnClickListener(this);
        basket_img.setOnClickListener(this);
        // this is for slider in andorid studio
        glheader_txt.setText("Green Rich India");
        init();
        addBottomDots(0);
        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }

                vp_slider.setCurrentItem(page_position, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);

    }

    private void init() {
        home_ll.setImageDrawable(getResources().getDrawable(R.drawable.home_red));
        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        //getSupportActionBar().hide();

        vp_slider = (ViewPager) findViewById(R.id.vp_slider);
        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);
        slider_image_list = new ArrayList<>();

        //Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
        // here i am adding few sample image links, you cand add your own

       /* slider_image_list.add("https://static0.tiendeo.in/images/tiendas/7057/cupones/57360/mid2/portada.jpg");
        slider_image_list.add("https://fthmb.tqn.com/ciuCwHnZVuWEgCZ-9N31BLyGOq0=/768x0/filters:no_upscale()/50percentoffGettyImages-165868406-5a32b9cdc7822d0037fa64b2.jpg");
        slider_image_list.add("https://fthmb.tqn.com/GMwHGfS81nlTXaJmkvhZWdHrBYA=/768x0/filters:no_upscale()/giftcardsGettyImages-182836553-5a32b386eb4d520037591543.jpg");
        slider_image_list.add("http://www.offersbiz.com/wp-content/uploads/2015/03/Laurels-Original-Men-Watch-online-shopping-in-Amazon-Inida.jpg");

*/
        slider_image_list.add(R.drawable.freelisting);
        slider_image_list.add(R.drawable.landscaping);
        slider_image_list.add(R.drawable.skilledlabour);
        slider_image_list.add(R.drawable.marketworld);
        sliderPagerAdapter = new SliderPagerAdapter(Home.this, slider_image_list);
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_img:
                drawble_ll.openDrawer(mll);
                break;
            case R.id.home_img:
                home_ll.setImageDrawable(getResources().getDrawable(R.drawable.home_red));
                break;
            case R.id.cat_img:
                Intent cat = new Intent(Home.this, Category.class);
                startActivity(cat);
                finish();
                break;
            case R.id.search_img:
                Intent search = new Intent(Home.this, Ads.class);
                startActivity(search);
                finish();
                break;
            case R.id.offer_img:
                Intent offer = new Intent(Home.this, Offers.class);
                startActivity(offer);
                finish();
                break;
            case R.id.basket_img:
                Intent basket = new Intent(Home.this, Basket.class);
                startActivity(basket);
                finish();
                break;
        }
    }
}
