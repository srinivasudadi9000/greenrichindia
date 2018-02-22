package m.srinivas.worldnews.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import m.srinivas.worldnews.Activities.Category;
import m.srinivas.worldnews.Constants.Cat;
import m.srinivas.worldnews.R;

/**
 * Created by srinivas on 17/02/18.
 */

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.Holder> {
    ArrayList<Cat> cats;
    int rowLayout;
    Category category;
    public Category_Adapter(ArrayList<Cat> cats, int rowLayout, Category category) {
         this.category = category;
         this.cats = cats;
         this.rowLayout = rowLayout;
     }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
         return new Category_Adapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mycat_txt.setText(cats.get(position).getCat_name());

    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView mycat_txt;
        ImageView mycat_img;
        public Holder(View itemView) {
            super(itemView);
            mycat_txt = (TextView) itemView.findViewById(R.id.mycat_name);
            mycat_img = (ImageView) itemView.findViewById(R.id.mycat_img);
        }
    }
}
