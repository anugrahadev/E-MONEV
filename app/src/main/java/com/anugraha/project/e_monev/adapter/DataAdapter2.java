package com.anugraha.project.e_monev.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anugraha.project.e_monev.R;
import com.anugraha.project.e_monev.model.Data;
import com.anugraha.project.e_monev.model.Data2;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataAdapter2 extends RecyclerView.Adapter<DataAdapter2.MyViewHolder> {
    private Context mContext;
    private List<Data2> dataList;

    public DataAdapter2(Context mContext, List<Data2> dataList){
        this.mContext = mContext;
        this.dataList = dataList;

    }

    @Override
    public DataAdapter2.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.data_list2, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.opd.setText(dataList.get(i).getOpd());
        myViewHolder.anggaran.setText(dataList.get(i).getAnggaran());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView opd, anggaran;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            anggaran = (TextView) itemView.findViewById(R.id.anggaran);
            opd = (TextView) itemView.findViewById(R.id.opd);

        }
    }

    public static int[] convertListToArray(List<Integer> listResult) {
        int[] result = new int[listResult.size()];
        int i= 0;
        for (int num : listResult) {
            result[i++] = num;
        }
        return result;
    }
}
