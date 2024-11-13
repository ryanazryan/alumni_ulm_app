package com.naufalazryan.alumnimipaulm.sosmed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naufalazryan.alumnimipaulm.ModelResponse.SosmedModelResponse.SosmedDataModel;
import com.naufalazryan.alumnimipaulm.R;

import java.util.List;

public class SosmedAdapter extends RecyclerView.Adapter<SosmedAdapter.MyViewHolder> {

    private List<SosmedDataModel> listDataSosmed;

    public SosmedAdapter(List<SosmedDataModel> sosmedDataModel) {
        this.listDataSosmed = sosmedDataModel;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sosmed, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvNamaSosmed.setText(listDataSosmed.get(position).getSosmedNama());
        holder.tvUrl.setText(listDataSosmed.get(position).getSmURL());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UpdateSosialMediaActivity.class);
                intent.putExtra("NamaSosmed", listDataSosmed.get(position).getSosmedNama());
                intent.putExtra("URL", listDataSosmed.get(position).getSmURL());
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listDataSosmed.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaSosmed, tvUrl, tvId;
        public ImageView edit, delete;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNamaSosmed = itemView.findViewById(R.id.namaSosmed);
            tvId = itemView.findViewById(R.id.id);
            tvUrl = itemView.findViewById(R.id.url);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}
