package m.srinivas.worldnews.Adapters;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;

import m.srinivas.worldnews.Activities.Basket;
import m.srinivas.worldnews.Activities.Home;
import m.srinivas.worldnews.Activities.Login;
import m.srinivas.worldnews.Models.Home_Items;
import m.srinivas.worldnews.R;

/**
 * Created by srinivas on 16/02/18.
 */

public class homeAdapter  extends RecyclerView.Adapter<homeAdapter.Holder> {
    int rowlayout;
    ArrayList<Home_Items> homes;
    Context context;
    public homeAdapter(ArrayList<Home_Items> homes, Context context, int rowlayout){
        this.context = context;this.homes = homes;this.rowlayout = rowlayout;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowlayout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.mytext.setText(homes.get(position).getName());
        holder.myimage.setImageDrawable(context.getResources().getDrawable(homes.get(position).getDrawable()));
        holder.homeadap_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callanim(context.getResources().getColor(R.color.colorPrimary), context.getResources().getColor(R.color.white),
                        holder.homeadap_ll);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView mytext;
        ImageView myimage;
        LinearLayout homeadap_ll;
        public Holder(View itemView) {
            super(itemView);
            myimage = (ImageView) itemView.findViewById(R.id.myhome);
            mytext = (TextView) itemView.findViewById(R.id.mytext);
            homeadap_ll = (LinearLayout) itemView.findViewById(R.id.homeadap_ll);
        }
    }
    public void callanim(final int colorcode, final int fullcolor, final LinearLayout cardView) {
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

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                cardView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));

            }
        });
        anim.start();
    }

}
