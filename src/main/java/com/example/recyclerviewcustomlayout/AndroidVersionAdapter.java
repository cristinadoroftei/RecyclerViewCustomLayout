package com.example.recyclerviewcustomlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AndroidVersionAdapter extends RecyclerView.Adapter<AndroidVersionAdapter.AndroidVersionViewHolder> {

    private List<AndroidVersion> androidVersionList;
    private Context context;

    public AndroidVersionAdapter(List<AndroidVersion> androidVersionsList, Context context){
        this.androidVersionList = androidVersionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public AndroidVersionAdapter.AndroidVersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //linking the recycler view item with the adapter class
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_android_version, parent, false);
        return new AndroidVersionAdapter.AndroidVersionViewHolder(itemView);
    }

    @Override
    //this item sets the values to our list object using the layout
    public void onBindViewHolder(@NonNull AndroidVersionViewHolder holder, int position) {
        holder.versionIcon.setImageResource(androidVersionList.get(position).getIcon());
        holder.versionName.setText(androidVersionList.get(position).getName());
        holder.releaseDate.setText(androidVersionList.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return androidVersionList.size();
    }

    public class AndroidVersionViewHolder extends RecyclerView.ViewHolder{
        //inside this class we add the layout items
        ImageView versionIcon;
        TextView versionName, releaseDate;

        //method that initialize the views and link them to the layout file
        public AndroidVersionViewHolder(View view){
            super(view);
            versionIcon = view.findViewById(R.id.versionIcon);
            versionName = view.findViewById(R.id.versionName);
            releaseDate = view.findViewById(R.id.versionDate);
        }


    }

}
