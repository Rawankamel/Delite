package com.fci.delite.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fci.delite.Interface.ItemClickListener;
import com.fci.delite.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

   // public TextView txtMenuName;
    public ImageView imageView;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public MenuViewHolder(View itemView) {
        super(itemView);
        //txtMenuName=(TextView)itemView.findViewById(R.id.)
        imageView=(ImageView)itemView.findViewById(R.id.menu_image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
itemClickListener.onClick(view,getAdapterPosition(),false);


    }

}