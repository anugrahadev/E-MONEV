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
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private Context mContext;
    private List<Data> dataList;

    public DataAdapter(Context mContext, List<Data> dataList){
        this.mContext = mContext;
        this.dataList = dataList;

    }

    @Override
    public DataAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.data_list, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_kegiatan.setText(dataList.get(i).getNamaKegiatan());
        String anggaran = dataList.get(i).getAnggaran().toString();
        myViewHolder.tv_anggaran.setText(anggaran);
        List<Integer> progress = dataList.get(i).getProgressFisik();
        int array[] = convertListToArray(progress);
        String[] a= Arrays.toString(array).split("[\\[\\]]")[1].split(", ");

        myViewHolder.tv_progress1.setText(a[0]+"%");
        myViewHolder.tv_progress2.setText(a[1]+"%");
        myViewHolder.tv_progress3.setText(a[2]+"%");
        myViewHolder.tv_progress4.setText(a[3]+"%");
        myViewHolder.tv_progress5.setText(a[4]+"%");

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(Float.parseFloat(a[0]), 0));
        entries.add(new BarEntry(Float.parseFloat(a[1]), 1));
        entries.add(new BarEntry(Float.parseFloat(a[2]), 2));
        entries.add(new BarEntry(Float.parseFloat(a[3]), 3));
        entries.add(new BarEntry(Float.parseFloat(a[4]), 4));
        entries.add(new BarEntry(0, 5));
        entries.add(new BarEntry(0, 6));
        entries.add(new BarEntry(0, 7));
        entries.add(new BarEntry(0, 8));
        entries.add(new BarEntry(0, 9));
        entries.add(new BarEntry(0, 10));
        entries.add(new BarEntry(0, 11));


        BarDataSet bardataset = new BarDataSet(entries, "Cells");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Januari");
        labels.add("Februari");
        labels.add("Maret");
        labels.add("April");
        labels.add("Mei");
        labels.add("Juni");
        labels.add("Juli");
        labels.add("Agustus");
        labels.add("September");
        labels.add("Oktober");
        labels.add("November");
        labels.add("Desember");

        BarData data = new BarData(labels, bardataset);
        myViewHolder.mBarChart.setData(data); // set the data and list of labels into chart
        myViewHolder.mBarChart.setDescription("Progress");  // set the description
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        myViewHolder.mBarChart.animateY(5000);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_kegiatan, tv_anggaran, tv_progress1,tv_progress2,tv_progress3,tv_progress4,tv_progress5;
        public BarChart mBarChart;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mBarChart = (BarChart) itemView.findViewById(R.id.chart);
            tv_kegiatan = (TextView) itemView.findViewById(R.id.tv_kegiatan);
            tv_anggaran = (TextView) itemView.findViewById(R.id.tv_anggaran);
            tv_progress1 = (TextView) itemView.findViewById(R.id.tv_progress1);
            tv_progress2 = (TextView) itemView.findViewById(R.id.tv_progress2);
            tv_progress3 = (TextView) itemView.findViewById(R.id.tv_progress3);
            tv_progress4 = (TextView) itemView.findViewById(R.id.tv_progress4);
            tv_progress5 = (TextView) itemView.findViewById(R.id.tv_progress5);
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
