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

public class UnassignedJobAdapter extends RecyclerView.Adapter<UnassignedJobAdapter.myviewholder> {

    List<JobAssign> assignData;

    public UnassignedJobAdapter(List<JobAssign> assignData) {
        this.assignData = assignData;
    }

    @NonNull
    @Override
    public UnassignedJobAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unassigned_joblist,parent,false);
        return new UnassignedJobAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnassignedJobAdapter.myviewholder holder, int position) {
        holder.jobregister_id.setText(assignData.get(position).getJobregister_id());
        holder.job_priority.setText(assignData.get(position).getJob_priority());
        holder.job_order_number.setText(assignData.get(position).getJob_order_number());
        holder.customer_name.setText(assignData.get(position).getCustomer_name());
        holder.job_description.setText(assignData.get(position).getJob_description());
        holder.machine_name.setText(assignData.get(position).getMachine_name());
        holder.machine_type.setText(assignData.get(position).getMachine_type());
        holder.serialnumber.setText(assignData.get(position).getSerial_number());
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
                 job_assign;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            jobregister_id = itemView.findViewById(R.id.Unassignedjobregister_id);
            job_priority = itemView.findViewById(R.id.Unassignedjob_priority);
            job_order_number = itemView.findViewById(R.id.Unassignedjob_order_number);
            customer_name = itemView.findViewById(R.id.Unassignedcustomer_name);
            job_description = itemView.findViewById(R.id.Unassignedjob_description);
            machine_name = itemView.findViewById(R.id.Unassignedmachine_name);
            machine_type =itemView.findViewById(R.id.Unassignedmachine_type);
            serialnumber = itemView.findViewById(R.id.Unassignedserialnumber);
            job_assign =itemView.findViewById(R.id.Unassignedjob_assign);
        }
    }
}
