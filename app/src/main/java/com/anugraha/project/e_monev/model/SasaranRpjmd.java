package com.anugraha.project.e_monev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SasaranRpjmd {

    @SerializedName("id_sasaran_rpjmd")
    @Expose
    private String idSasaranRpjmd;
    @SerializedName("nama_sasaran_rpjmd")
    @Expose
    private String namaSasaranRpjmd;
    @SerializedName("total_belanja_rpjmd")
    @Expose
    private Object totalBelanjaRpjmd;
    @SerializedName("indikator_sasaran_rpjmd")
    @Expose
    private ArrayList<Object> indikatorSasaranRpjmd = null;

    public String getIdSasaranRpjmd() {
        return idSasaranRpjmd;
    }

    public void setIdSasaranRpjmd(String idSasaranRpjmd) {
        this.idSasaranRpjmd = idSasaranRpjmd;
    }

    public String getNamaSasaranRpjmd() {
        return namaSasaranRpjmd;
    }

    public void setNamaSasaranRpjmd(String namaSasaranRpjmd) {
        this.namaSasaranRpjmd = namaSasaranRpjmd;
    }

    public Object getTotalBelanjaRpjmd() {
        return totalBelanjaRpjmd;
    }

    public void setTotalBelanjaRpjmd(Object totalBelanjaRpjmd) {
        this.totalBelanjaRpjmd = totalBelanjaRpjmd;
    }

    public ArrayList<Object> getIndikatorSasaranRpjmd() {
        return indikatorSasaranRpjmd;
    }

    public void setIndikatorSasaranRpjmd(ArrayList<Object> indikatorSasaranRpjmd) {
        this.indikatorSasaranRpjmd = indikatorSasaranRpjmd;
    }

}