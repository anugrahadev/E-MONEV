package com.anugraha.project.e_monev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data2 {

    @SerializedName("id_opd")
    @Expose
    private Integer idOpd;
    @SerializedName("opd")
    @Expose
    private String opd;
    @SerializedName("anggaran")
    @Expose
    private Integer anggaran;
    @SerializedName("realisasi")
    @Expose
    private Integer realisasi;

    public Integer getIdOpd() {
        return idOpd;
    }

    public void setIdOpd(Integer idOpd) {
        this.idOpd = idOpd;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public Integer getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(Integer anggaran) {
        this.anggaran = anggaran;
    }

    public Integer getRealisasi() {
        return realisasi;
    }

    public void setRealisasi(Integer realisasi) {
        this.realisasi = realisasi;
    }

}