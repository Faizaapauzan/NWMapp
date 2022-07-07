package com.example.nwmapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Activity activity;
    ArrayList<String> arrayList;

    public MainAdapter(Activity activity,ArrayList<String> arrayList){
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.item_drawer_main,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));

        holder.textView.setOnClickListener(view -> {
            int position1 = holder.getAdapterPosition();
            switch (position1){
                case 0:
                    activity.startActivity(new Intent(activity,HomeActivity.class).
                            setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                    break;

                case 4:
                    activity.startActivity(new Intent(activity,AssignedJob.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;

                case 5:
                    activity.startActivity(new Intent(activity,UnassignJob.class)
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

                    break;

                case 9:
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Logout");
                    builder.setMessage("Are you sure ?");
                    builder.setPositiveButton("YES", (dialogInterface, i) -> {
                            activity.finishAffinity();
                            System.exit(0);

                    });

                    builder.setNegativeButton("CANCEL", (dialogInterface, i) -> dialogInterface.dismiss());

                    builder.show();
                    break;

            }

        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
