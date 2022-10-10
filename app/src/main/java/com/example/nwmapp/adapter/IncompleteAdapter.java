package com.example.nwmapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nwmapp.R;
import com.example.nwmapp.models.JobAssign;

import java.util.List;


public class IncompleteAdapter extends RecyclerView.Adapter<IncompleteAdapter.myviewholder> {

    List<JobAssign> assignData;

    public IncompleteAdapter(List<JobAssign> assignData) {
        this.assignData = assignData;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incomplete_list,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.job_priority.setText(assignData.get(position).getJob_priority());
        holder.job_order_number.setText(assignData.get(position).getJob_order_number());
        holder.customer_name.setText(assignData.get(position).getCustomer_name());
        holder.job_description.setText(assignData.get(position).getJob_description());
        holder.machine_name.setText(assignData.get(position).getMachine_name());
        holder.machine_type.setText(assignData.get(position).getMachine_type());
        holder.serial_number.setText(assignData.get(position).getSerial_number());
        holder.job_assign.setText(assignData.get(position).getAssign());
        holder.reason.setText(assignData.get(position).getReason());


    }

    @Override
    public int getItemCount() {
        return assignData.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView job_priority, job_order_number,customer_name,job_description,machine_name,machine_type,serial_number,job_assign,reason;


        public myviewholder(@NonNull View itemView) {
            super(itemView);

            job_priority = itemView.findViewById(R.id.incompleteJob_priority);
            job_order_number = itemView.findViewById(R.id.IncompleteJob_order_number);
            customer_name = itemView.findViewById(R.id.IncompleteCustomer_name);
            job_description = itemView.findViewById(R.id.IncompleteJob_description);
            machine_name = itemView.findViewById(R.id.IncompleteMachine_name);
            machine_type = itemView.findViewById(R.id.IncompleteMachine_type);
            serial_number =itemView.findViewById(R.id.IncompleteSerialnumber);
            job_assign =itemView.findViewById(R.id.IncompleteJob_assign);
            reason =itemView.findViewById(R.id.incompleteReason);

        }
    }

}
