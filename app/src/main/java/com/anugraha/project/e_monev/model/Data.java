package com.anugraha.project.e_monev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("id_kegiatan")
    @Expose
    private Integer idKegiatan;
    @SerializedName("nama_kegiatan")
    @Expose
    private String namaKegiatan;
    @SerializedName("anggaran")
    @Expose
    private Integer anggaran;
    @SerializedName("progress_fisik")
    @Expose
    private List<Integer> progressFisik = null;

    public Integer getIdKegiatan() {
        return idKegiatan;
    }

    public void setIdKegiatan(Integer idKegiatan) {
        this.idKegiatan = idKegiatan;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public Integer getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(Integer anggaran) {
        this.anggaran = anggaran;
    }

    public List<Integer> getProgressFisik() {
        return progressFisik;
    }

    public void setProgressFisik(List<Integer> progressFisik) {
        this.progressFisik = progressFisik;
    }

}