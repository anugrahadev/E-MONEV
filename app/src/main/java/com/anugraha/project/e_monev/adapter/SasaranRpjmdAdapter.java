package com.anugraha.project.e_monev.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anugraha.project.e_monev.R;
import com.anugraha.project.e_monev.model.Data;
import com.anugraha.project.e_monev.model.SasaranRpjmd;

import java.util.List;

public class SasaranRpjmdAdapter extends RecyclerView.Adapter<SasaranRpjmdAdapter.CustomViewHolder> {
    private List<SasaranRpjmd> sasaran_rpjmd;
    public SasaranRpjmdAdapter(List<SasaranRpjmd> sasaran_rpjmd) {
        this.sasaran_rpjmd = sasaran_rpjmd;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        SasaranRpjmd datas = sasaran_rpjmd.get(position);
        holder.id.setText(datas.getIdSasaranRpjmd());
        holder.nama.setText(datas.getNamaSasaranRpjmd());
//        holder.sasaran.setText(datas.getIndikatorSasaranRpjmd());

    }

    @Override
    public int getItemCount() {
        return sasaran_rpjmd.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView id, nama, sasaran;

        public CustomViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.id);
            nama = (TextView) view.findViewById(R.id.nama);
            sasaran = (TextView) view.findViewById(R.id.sasaran);
        }
    }
}