package com.anugraha.project.e_monev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("id_sasaran_rpjmd")
    @Expose
    private String idSasaranRpjmd;
    @SerializedName("nama_sasaran_rpjmd")
    @Expose
    private String namaSasaranRpjmd;
    @SerializedName("indikator_sasaran_rpjmd")
    @Expose
    private List<Object> indikatorSasaranRpjmd = null;

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

    public List<Object> getIndikatorSasaranRpjmd() {
        return indikatorSasaranRpjmd;
    }

    public void setIndikatorSasaranRpjmd(List<Object> indikatorSasaranRpjmd) {
        this.indikatorSasaranRpjmd = indikatorSasaranRpjmd;
    }

}