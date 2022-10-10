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

public class PendingJobListAdapter extends RecyclerView.Adapter<PendingJobListAdapter.myviewholder> {
    List<JobAssign> assignData;

    public PendingJobListAdapter(List<JobAssign> assignData) {
        this.assignData = assignData;
    }

    @NonNull
    @Override
    public PendingJobListAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_joblist,parent,false);
        return new PendingJobListAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingJobListAdapter.myviewholder holder, int position) {
        holder.jobregister_id.setText(assignData.get(position).getJobregister_id());
        holder.job_priority.setText(assignData.get(position).getJob_priority());
        holder.job_order_number.setText(assignData.get(position).getJob_order_number());
        holder.customer_name.setText(assignData.get(position).getCustomer_name());
        holder.job_description.setText(assignData.get(position).getJob_description());
        holder.machine_name.setText(assignData.get(position).getMachine_name());
        holder.machine_type.setText(assignData.get(position).getMachine_type());
        holder.serialnumber.setText(assignData.get(position).getSerial_number());
        holder.reason.setText(assignData.get(position).getReason());
        holder.job_assign.setText(assignData.get(position).getJob_assign());
    }

    @Override
    public int getItemCount() {
        return assignData.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView jobregister_id,
                job_priority,
                job_order_number,
                customer_name,
                job_description,
                machine_name,
                machine_type,
                serialnumber,
                reason,
                job_assign;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            jobregister_id = itemView.findViewById(R.id.PendingJobRegister_id);
            job_priority = itemView.findViewById(R.id.pendingJob_priority);
            job_order_number = itemView.findViewById(R.id.pendingJob_order_number);
            customer_name = itemView.findViewById(R.id.pendingCustomer_name);
            job_description = itemView.findViewById(R.id.pendingJob_description);
            machine_name = itemView.findViewById(R.id.pendingMachine_name);
            machine_type =itemView.findViewById(R.id.pendingMachine_type);
            serialnumber = itemView.findViewById(R.id.pendingSerialnumber);
            reason = itemView.findViewById(R.id.pendingReason);
            job_assign =itemView.findViewById(R.id.pendingJob_assign);
        }
    }
}
