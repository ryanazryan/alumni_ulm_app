package com.naufalazryan.alumnimipaulm.pekerjaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naufalazryan.alumnimipaulm.ModelResponse.PekerjaanModelResponse.PekerjaanDataModel;
import com.naufalazryan.alumnimipaulm.R;
import com.naufalazryan.alumnimipaulm.pendidikan.UpdatePendidikanActivity;

import java.util.List;

public class PekerjaanAdapter extends RecyclerView.Adapter<PekerjaanAdapter.MyViewHolder> {

    private List<PekerjaanDataModel> listPekerjaan;

    public PekerjaanAdapter(List<PekerjaanDataModel> pekerjaanDataModelAdapter){
        this.listPekerjaan = pekerjaanDataModelAdapter;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pekerjaan, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvPekerjaan.setText(listPekerjaan.get(position).getKjPekerjaan());
        holder.tvInstansi.setText(listPekerjaan.get(position).getKjInstansi());
        holder.tvTahunMulai.setText(listPekerjaan.get(position).getKjTahunMulai());
        holder.tvNamaAtasan.setText(listPekerjaan.get(position).getKjNamaAtasan());
        holder.tvEmailAtasan.setText(listPekerjaan.get(position).getKjEmailAtasan());
        holder.tvHpAtasan.setText(listPekerjaan.get(position).getKjHpAtasan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UpdatePekerjaanActivity.class);
                intent.putExtra("kjPekerjaan", listPekerjaan.get(position).getKjPekerjaan());
                intent.putExtra("kjInstansi", listPekerjaan.get(position).getKjInstansi());
                intent.putExtra("kjTahunMulai", listPekerjaan.get(position).getKjTahunMulai());
                intent.putExtra("kjNamaAtasan", listPekerjaan.get(position).getKjNamaAtasan());
                intent.putExtra("kjEmailAtasan", listPekerjaan.get(position).getKjEmailAtasan());
                intent.putExtra("kjHpAtasan", listPekerjaan.get(position).getKjHpAtasan());
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listPekerjaan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPekerjaan, tvInstansi, tvTahunMulai, tvNamaAtasan, tvEmailAtasan, tvHpAtasan;
        public ImageView edit, delete;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvPekerjaan = itemView.findViewById(R.id.tampilPekerjaan);
            tvInstansi =  itemView.findViewById(R.id.tampilInstansi);
            tvTahunMulai = itemView.findViewById(R.id.tampilTahun);
            tvNamaAtasan = itemView.findViewById(R.id.namaAtasan);
            tvEmailAtasan = itemView.findViewById(R.id.emailAtasan);
            tvHpAtasan = itemView.findViewById(R.id.hpAtasan);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);
        }
    }

}
