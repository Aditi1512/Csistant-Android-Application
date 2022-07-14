package com.example.csistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ViewHolder>{
    private Context context;
    private List<Model> reminderList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    ReminderAdapter(Context context, List<Model> data) {
        this.mInflater = LayoutInflater.from(context);
        this.reminderList = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = reminderList.get(position);

        holder.eName.setText(model.getTitle());
        holder.eDate.setText(model.getDate());
        holder.eTime.setText(model.getTime());
        holder.buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Add functionality to Button ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return reminderList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView eName, eDate, eTime;
        Button buttonMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eName = itemView.findViewById(R.id.eventNameText);
            eDate = itemView.findViewById(R.id.eventDateText);
            eTime = itemView.findViewById(R.id.eventTimeText);
            buttonMore = itemView.findViewById(R.id.moreBut);
        }
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}




