/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datadiri;

import com.mycompany.transaksi.*;

//import java.util.Arrays;
/**
 *
 * @author hp
 */
public class UserPelajar extends Datadiri {

    private String sekolah;
    private String course;
    private String tutor;

    public UserPelajar(
        String nama,
        String dataLahir,
        String alamat,
        String jenisKelamin,
        int umur,
        String sekolah,
        String course,
        String tutor
    ) {
        super(nama, dataLahir, alamat, jenisKelamin, umur);
        this.sekolah = sekolah;
        this.course = course;
        this.tutor = tutor;
    }

    public String getSekolah() {
        return sekolah;
    }

    public String getCourse() {
        return course;
    }

    public String getTutor() {
        return tutor;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void memilihTutor(String tutor) {
        this.tutor = tutor;
        System.out.println("Tutor chosen: " + tutor);
    }

    public void menghubungiViaChat() {
        System.out.println("Chatting with tutor");
    }

    public void melakukanPembayaran(int uang, String pelajar, String tutor) {
        try {
            Pembayaran pr = new Pembayaran(
                uang,
                "belum",
                pelajar,
                tutor,
                "Bukti"
            );
            pr.melakukanPembayaran();
            if (
                pr.prosesTransaksi() == true &&
                pr.lihatStatus().equals("Sukses")
            ) {
                pr.pembayaranDiterima();
                pr.memesanDosen();
                pr.mendapatBuktiBayar();
            }
        } catch (Exception e) {
            //System.err.println(e.fillInStackTrace());
            //System.err.println(Arrays.toString(e.getStackTrace()));
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void mengisiBioData(
        String nama,
        String dataLahir,
        String alamat,
        String jenisKelamin,
        int umur,
        String sekolah,
        String course,
        String tutor
    ) {
        try {
            setNama(nama);
            setDataLahir(dataLahir);
            setAlamat(alamat);
            setJenisKelamin(jenisKelamin);
            setUmur(umur);
            setSekolah(sekolah);
            setCourse(course);
            setTutor(tutor);
        } catch (Exception e) {
            //System.err.println(e.fillInStackTrace());
            //System.err.println(Arrays.toString(e.getStackTrace()));
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
        }
        System.out.println("Biodata filled");
    }
}
