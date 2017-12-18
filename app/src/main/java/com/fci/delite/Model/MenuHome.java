package com.fci.delite.Model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;


import com.fci.delite.Interface.ItemClickListener;
import com.fci.delite.R;
import com.fci.delite.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MenuHome extends AppCompatActivity
{
    FirebaseDatabase database;
    DatabaseReference DBmenu;
    RecyclerView recyclerMenu;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
                toolbar.setTitle("Menu");
          //      setSupportActionBar(toolbar);

        database =FirebaseDatabase.getInstance();
        DBmenu=database.getReference();

        recyclerMenu=(RecyclerView)findViewById(R.id.recycler_menu);
        recyclerMenu.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerMenu.setLayoutManager(layoutManager);
        loadMenu();

    }

    private void loadMenu() {
        FirebaseRecyclerAdapter<catagory,MenuViewHolder> adapter=new FirebaseRecyclerAdapter<catagory, MenuViewHolder>(catagory.class,R.layout.menu_item,MenuViewHolder.class,DBmenu) {
            @Override
            public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
                MenuViewHolder holder =new MenuViewHolder(view);
                return holder;
            }

            @Override
            protected void onBindViewHolder( MenuViewHolder holder,  int position,catagory model) {
                Picasso.with(getBaseContext()).load(model.getImageOfCat()).into(holder.imageView);
                final catagory ClickItem=model;
                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(MenuHome.this,""+ClickItem.getNameOfCat(), Toast.LENGTH_SHORT);

                    }
                });
            }


        };
        recyclerMenu.setAdapter(adapter);
    }
}