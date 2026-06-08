/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datadiri;

import com.mycompany.transaksi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class UserPelajar extends Datadiri {

    private static final Logger logger = Logger.getLogger(
        UserPelajar.class.getName()
    );

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
        logger.log(Level.INFO, "Tutor chosen: {0}", tutor);
    }

    public void menghubungiViaChat() {
        logger.info("Chatting with tutor");
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
            if (pr.prosesTransaksi() && pr.lihatStatus().equals("Sukses")) {
                pr.pembayaranDiterima();
                pr.memesanDosen();
                pr.mendapatBuktiBayar();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void mengisiBioData(BioData data) {
        try {
            setNama(data.nama());
            setDataLahir(data.dataLahir());
            setAlamat(data.alamat());
            setJenisKelamin(data.jenisKelamin());
            setUmur(data.umur());
            setSekolah(data.extra1());
            setCourse(data.extra2());
            setTutor(data.extra3());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        logger.info("Biodata filled");
    }
}
