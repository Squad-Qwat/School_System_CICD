/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classjadwal;

/**
 *
 * @author Akfarizi
 */
public class Jadwal {

    private int tanggal;
    private String bulan;
    private int tahun;
    private String hari;
    private String kelas;
    private String mataPelajaran;

    public Jadwal(DateInfo dateInfo, String kelas, String mataPelajaran) {
        this.tanggal = dateInfo.tanggal();
        this.bulan = dateInfo.bulan();
        this.tahun = dateInfo.tahun();
        this.hari = dateInfo.hari();
        this.kelas = kelas;
        this.mataPelajaran = mataPelajaran;
    }

    public int getTanggal() {
        return tanggal;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }
}
