package com.anugraha.project.e_monev;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class ProgressKeuanganAct extends AppCompatActivity {
    Spinner tahun;
    LineChartView lineChartView;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    int[] yAxisData = {400, 500, 580, 590, 595,610,590,600,700,675,670,800};
    int[] yAxisData2 = {200, 220, 300, 320, 200,300,320,275,350,300,400,380};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_keuangan);
        Toolbar toolbar = findViewById(R.id.toolbar); //Inisialisasi dan Implementasi id Toolbar

        setSupportActionBar(toolbar); // Memasang Toolbar pada Aplikasi
        getSupportActionBar().setTitle("Progress Keuangan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tahun = findViewById(R.id.listtahun);
        lineChartView = findViewById(R.id.chart);

        List yAxisValues2 = new ArrayList();
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));
        Line line2 = new Line(yAxisValues2).setColor(Color.parseColor("#1657A8"));

        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        for (int i = 0; i < yAxisData2.length; i++){
            yAxisValues2.add(new PointValue(i, yAxisData2[i]));
        }
        List lines = new ArrayList();
        lines.add(line);
        lines.add(line2);

        LineChartData data = new LineChartData();
        data.setLines(lines);


//        lineChartView.setLineChartData(data2);
        lineChartView.setLineChartData(data);
        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);


        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
