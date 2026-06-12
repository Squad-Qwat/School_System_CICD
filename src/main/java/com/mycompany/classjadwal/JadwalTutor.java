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
            idTutor +
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
            // Format: nama, lahir, alamat, golongan darah, jenis kelamin, umur, tempat kerja, pengalaman, kemampuan
            logger.info("Masukan nama: ");
            String inputNamaTutor = scan.nextLine();
            logger.info("Masukan tanggal lahir spasi dengan (-): ");
            String dataLahirTutor = scan.nextLine();
            logger.info("Tempat tinggal: ");
            String alamatTutor = scan.nextLine();
            logger.info("Umur: ");
            int umurTutor = -1;
            if (scan.hasNextInt()) {
                umurTutor = scan.nextInt();
                scan.nextLine(); // consume newline
            }
            logger.info("Tempat berkerja saat ini: ");
            String tempatBekerja = scan.nextLine();
            logger.info("Pengalaman: ");
            String pengalaman = scan.nextLine();
            logger.info("Kemampuan: ");
            String kemampuan = scan.nextLine();
            UserTutor ut = new UserTutor(
                inputNamaTutor,
                dataLahirTutor,
                alamatTutor,
                scan.hasNextLine() ? scan.nextLine() : "",
                umurTutor,
                tempatBekerja,
                pengalaman,
                kemampuan
            );
            logger.info("Memeriksa ketersediaan tutor...");
            if (schedule.isEmpty()) {
                ut.menerimaPesanan(inputNamaTutor);
                konfirmasiPesanan();
                ut.menjalankanTutoring();
            } else {
                ut.menolakPesanan(inputNamaTutor);
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
