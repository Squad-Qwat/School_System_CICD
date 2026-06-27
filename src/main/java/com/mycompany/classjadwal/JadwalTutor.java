/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classjadwal;

import com.mycompany.datadiri.*;
import com.mycompany.utils.InputUtils;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akfarizi
 */
public class JadwalTutor extends Jadwal implements IfaceJadwal {

    private static final Logger logger = Logger.getLogger(
        JadwalTutor.class.getName()
    );

    private int idTutor;
    private String namaTutor;
    private float rating;
    private List<String> schedule;

    public JadwalTutor(
        DateInfo dateInfo,
        String kelas,
        String mataPelajaran,
        int idTutor,
        String namaTutor,
        float rating
    ) {
        super(dateInfo, kelas, mataPelajaran);
        this.idTutor = idTutor;
        this.namaTutor = namaTutor;
        this.rating = rating;
        this.schedule = new ArrayList<>();
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTutorInfo() {
        return (
            "ID Tutor: " +
             getIdTutor() +
            ", Nama: " +
            namaTutor +
            ", Rating: " +
            rating
        );
    }

    public void initializeSchedule() {
        // Sementara, agak bingung yang ini
        schedule.add(4, "Senin");
        schedule.add(3, "Rabu");
        schedule.add(5, "Kamis");
        schedule.add(1, "Sabtu");
    }

    @Override
    public void cekKetersediaan() {
        Scanner scan = InputUtils.getScanner();
        try {
            BioData data = InputUtils.readBioData(
                scan,
                logger,
                null,
                "Tempat berkerja saat ini",
                "Pengalaman",
                "Kemampuan"
            );

            UserTutor ut = new UserTutor(
                data.nama(),
                data.dataLahir(),
                data.alamat(),
                data.jenisKelamin(),
                data.umur(),
                data.extra1(),
                data.extra2(),
                data.extra3()
            );
            logger.info("Memeriksa ketersediaan tutor...");
            if (schedule.isEmpty()) {
                ut.menerimaPesanan(data.nama());
                konfirmasiPesanan();
                ut.menjalankanTutoring();
            } else {
                ut.menolakPesanan(data.nama());
            }
        } catch (InputMismatchException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } finally {
            konfirmasiPesanan();
        }
    }

    @Override
    public void konfirmasiPesanan() {
        try {
            logger.info("Pesanan diterima.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        } finally {
            logger.info("Proses selesai!");
        }
    }
}
