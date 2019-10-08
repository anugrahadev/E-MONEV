package com.anugraha.project.e_monev.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Realisasi {
    @SerializedName("bulan")
    @Expose
    private String bulan;
    @SerializedName("b_langsung")
    @Expose
    private Integer bLangsung;
    @SerializedName("b_tlangsung")
    @Expose
    private Integer bTlangsung;

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public Integer getBLangsung() {
        return bLangsung;
    }

    public void setBLangsung(Integer bLangsung) {
        this.bLangsung = bLangsung;
    }

    public Integer getBTlangsung() {
        return bTlangsung;
    }

    public void setBTlangsung(Integer bTlangsung) {
        this.bTlangsung = bTlangsung;
    }
}
