package com.anugraha.project.e_monev.modelprofile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("id_role")
    @Expose
    private String idRole;
    @SerializedName("title_role")
    @Expose
    private String titleRole;
    @SerializedName("nama_role")
    @Expose
    private String namaRole;
    @SerializedName("nama_controller")
    @Expose
    private String namaController;
    @SerializedName("id_opd")
    @Expose
    private Object idOpd;
    @SerializedName("nama_opd")
    @Expose
    private Object namaOpd;
    @SerializedName("s_id_opd")
    @Expose
    private Object sIdOpd;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getTitleRole() {
        return titleRole;
    }

    public void setTitleRole(String titleRole) {
        this.titleRole = titleRole;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    public String getNamaController() {
        return namaController;
    }

    public void setNamaController(String namaController) {
        this.namaController = namaController;
    }

    public Object getIdOpd() {
        return idOpd;
    }

    public void setIdOpd(Object idOpd) {
        this.idOpd = idOpd;
    }

    public Object getNamaOpd() {
        return namaOpd;
    }

    public void setNamaOpd(Object namaOpd) {
        this.namaOpd = namaOpd;
    }

    public Object getSIdOpd() {
        return sIdOpd;
    }

    public void setSIdOpd(Object sIdOpd) {
        this.sIdOpd = sIdOpd;
    }

}