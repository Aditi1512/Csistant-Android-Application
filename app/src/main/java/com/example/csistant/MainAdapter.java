package com.example.csistant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    // initialize variable
    Activity activity;
    ArrayList<ContactModel> arrayList ;
    private DBHandler dbhandler;
    private static final String TAG = "MyActivity";

    Context context;


    private int selectedPos = RecyclerView.NO_POSITION;

    // create constructor
//    public MainAdapter (Activity activity, ArrayList<ContactModel> arrayList){
    public MainAdapter (ArrayList<ContactModel> arrayList, Context context){
//        this.activity = activity;
        this.arrayList = arrayList;
        this.context=context;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent
                , false);
        // return view


        return new ViewHolder(view);
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        // initialize contact model
//        ContactModel model = arrayList.get(position);
//
//        // set name and number
//        holder.tvName.setText(model.getName());
//        holder.tvNumber.setText(model.getNumber());
//    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // initialize contact model
        ContactModel model = arrayList.get(position);


        // set name and number
        holder.tvName.setText(model.getName());
        holder.tvNumber.setText(model.getNumber());



//        holder.itemView.setBackgroundColor(model.isSelected() ? Color.GRAY : Color.WHITE);
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                model.setSelected(!model.isSelected());
//                holder.itemView.setBackgroundColor(model.isSelected() ? Color.GRAY : Color.WHITE);
                Intent intent = new Intent( context , SelectAttendees.class);
                intent.putExtra("attendee_contact", model.getNumber());
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        // return arraylist size
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.iv_name);
            tvNumber= itemView.findViewById(R.id.iv_number);
        }
    }


}