package com.anugraha.project.e_monev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("id_root")
    @Expose
    private String idRoot;
    @SerializedName("nama_root")
    @Expose
    private String namaRoot;
    @SerializedName("total_belanja")
    @Expose
    private Object totalBelanja;
    @SerializedName("sasaran_rpjmd")
    @Expose
    private ArrayList<SasaranRpjmd> sasaranRpjmd = null;

    public String getIdRoot() {
        return idRoot;
    }

    public void setIdRoot(String idRoot) {
        this.idRoot = idRoot;
    }

    public String getNamaRoot() {
        return namaRoot;
    }

    public void setNamaRoot(String namaRoot) {
        this.namaRoot = namaRoot;
    }

    public Object getTotalBelanja() {
        return totalBelanja;
    }

    public void setTotalBelanja(Object totalBelanja) {
        this.totalBelanja = totalBelanja;
    }

    public ArrayList<SasaranRpjmd> getSasaranRpjmd() {
        return sasaranRpjmd;
    }

    public void setSasaranRpjmd(ArrayList<SasaranRpjmd> sasaranRpjmd) {
        this.sasaranRpjmd = sasaranRpjmd;
    }

}