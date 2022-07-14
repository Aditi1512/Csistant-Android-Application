package com.example.csistant;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ListIterator;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ViewHolder> {

    private List<Model> l;
    private Context context;

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model ls = l.get(position);

        holder.name.setText(ls.getTitle());
        holder.date.setText(ls.getDate());
        holder.time.setText(ls.getTime());
    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,date,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.eventNameText);
            date = (TextView) itemView.findViewById(R.id.eventDateText);
            time = (TextView) itemView.findViewById(R.id.eventTimeText);
        }
    }
}

