package com.anugraha.project.e_monev.modelprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Editprofilemodel {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}