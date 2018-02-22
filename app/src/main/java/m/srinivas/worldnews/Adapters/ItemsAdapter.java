package m.srinivas.worldnews.Adapters;

import android.content.Context;
import android.graphics.Paint;
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

import m.srinivas.worldnews.Models.Items;
import m.srinivas.worldnews.R;


/**
 * Created by srinivas on 05/02/18.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemHolder> {
    ArrayList<Items> items;
    Context context;
    private int rowLayout;
    Animation move;
    public ItemsAdapter(ArrayList<Items> items, int rowLayout, Context context) {
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
        holder.item_title.setText(items.get(position).getTitle().toString());
        holder.item_description.setText(items.get(position).getDescription().toString());
        holder.item_image.setImageDrawable(context.getDrawable(items.get(position).getImage()));
       /* holder.item_type.setText(items.get(position).getType().toString());
        holder.item_old_price.setText(items.get(position).getOld_price().toString());
        holder.item_new_price.setText(items.get(position).getNew_price().toString());
        holder.item_image.setImageDrawable(context.getDrawable(items.get(position).getImage()));
        holder.item_old_price.setPaintFlags(holder.item_old_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);*/
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
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
            item_description = (TextView) itemView.findViewById(R.id.item_description);
            item_type = (TextView) itemView.findViewById(R.id.item_type);
            item_add = (TextView) itemView.findViewById(R.id.item_add);
            item_old_price = (TextView) itemView.findViewById(R.id.item_old_price);
            item_new_price = (TextView) itemView.findViewById(R.id.item_new_price);
        }
    }
}
