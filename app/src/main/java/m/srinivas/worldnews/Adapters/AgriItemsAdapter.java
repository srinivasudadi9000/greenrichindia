package m.srinivas.worldnews.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import m.srinivas.worldnews.Activities.Home;
import m.srinivas.worldnews.Models.Agri_Items;
import m.srinivas.worldnews.Models.Items;
import m.srinivas.worldnews.R;


/**
 * Created by srinivas on 05/02/18.
 */

public class AgriItemsAdapter extends RecyclerView.Adapter<AgriItemsAdapter.ItemHolder> {
    ArrayList<Agri_Items> items;
    Context context;
    private int rowLayout;
    Animation move;

    public AgriItemsAdapter(ArrayList<Agri_Items> items, int rowLayout, Home context) {
        this.items = items;
        this.context = context;
        this.rowLayout = rowLayout;
        move = AnimationUtils.loadAnimation(context, R.anim.grow_from_left_bottom);
    }



    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        view.setAnimation(move);
        return new ItemHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.item_title.setText(items.get(position).getAgri_title().toString());
        //holder.item_image.setImageDrawable(context.getDrawable(items.get(position).getAgri_img()));
        holder.item_image.setBackground(context.getDrawable(items.get(position).getAgri_img()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView item_title, item_description, item_type, item_add, item_old_price, item_new_price;
        ImageView item_image;

        public ItemHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.agri_img);
            item_title = (TextView) itemView.findViewById(R.id.agri_txt);

        }
    }
}
