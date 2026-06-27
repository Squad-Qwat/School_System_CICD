/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datadiri;

import com.mycompany.pembelajaran.*;
import com.mycompany.utils.InputUtils;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class UserTutor extends Datadiri {

    private static final Logger logger = Logger.getLogger(
        UserTutor.class.getName()
    );

    private String tempatBekerja;
    private String pengalaman;
    private String kemampuan;
    private List<String> schedule;

    public UserTutor(
        String nama,
        String dataLahir,
        String alamat,
        String jenisKelamin,
        int umur,
        String tempatBekerja,
        String pengalaman,
        String kemampuan
    ) {
        super(nama, dataLahir, alamat, jenisKelamin, umur);
        this.tempatBekerja = tempatBekerja;
        this.pengalaman = pengalaman;
        this.kemampuan = kemampuan;
        this.schedule = new ArrayList<>();
    }

    public String getTempatBekerja() {
        return tempatBekerja;
    }

    public void setTempatBekerja(String tempatBekerja) {
        this.tempatBekerja = tempatBekerja;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public String getKemampuan() {
        return kemampuan;
    }

    public void setKemampuan(String kemampuan) {
        this.kemampuan = kemampuan;
    }

    public void menerimaPesanan(String pesan) {
        // Logic to receive order
        logger.log(Level.INFO, "Order received: {0}", pesan);
        melakukanPenjadwalan();
    }

    public void menolakPesanan(String pesan) {
        // Logic to reject order
        logger.log(Level.INFO, "Order rejected: {0}", pesan);
    }

    public void melakukanPenjadwalan() {
        // Logic to schedule
        logger.info("Scheduling...");
        if (schedule.isEmpty()) {
            Scanner scan = InputUtils.getScanner();
            try {
                logger.info("Enter subject for the appointment: ");
                String subject = "";
                if (scan.hasNextLine()) {
                    subject = scan.nextLine();
                }
                schedule.add(subject);
                logger.log(
                    Level.INFO,
                    "Appointment scheduled with subject: {0}",
                    subject
                );
            } catch (Exception e) {
                logger.log(
                    Level.SEVERE,
                    "An error occurred while reading input: {0}",
                    e.getMessage()
                );
            }
        } else {
            logger.info("Schedule is not empty. Cannot make an appointment.");
        }
    }

    public void menjalankanTutoring() {
        // Logic to start tutoring
        logger.info("Tutoring started...");
        Scanner scan = InputUtils.getScanner();
        try {
            logger.info("Enter duration of the tutoring session in seconds: ");
            int durationSecond = 0;
            if (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (!line.isEmpty()) {
                    durationSecond = Integer.parseInt(line);
                }
            }
            LocalTime startTime = LocalTime.now(ZoneId.systemDefault());
            LocalTime endTime = startTime.plusSeconds(durationSecond);
            logger.log(
                Level.INFO,
                "Tutoring session started at {0} and will end at {1}",
                new Object[] { formatTime(startTime), formatTime(endTime) }
            );
            while (LocalTime.now(ZoneId.systemDefault()).isBefore(endTime)) {
                // Simulate tutoring session
                Thread.sleep(Duration.ofSeconds(durationSecond).toMillis());
            }

            // Sleep for 1 second to simulate time passing
            logger.log(
                Level.INFO,
                "Tutoring session ended at {0}",
                formatTime(LocalTime.now(ZoneId.systemDefault()))
            );
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Tutoring session interrupted", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: {0}", e.getMessage());
        }
    }

    public void membuatLatihanSoal() {
        try {
            // Logic to create exercises
            logger.info("Creating exercises...");
            LatihanSoal ls = new LatihanSoal();
            ls.setBobot(70);
            ls.setKodeSoal("CCK131");
            ls.setKunciJawaban("Awam");
            ls.setDeadline(20);
            logger.info("Latihan soal sudah dibuat!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e.getCause());
        }
    }

    public void menilaiLatihanSoal() {
        try {
            // Logic to evaluate exercises
            logger.info("Evaluating exercises...");
            LatihanSoal ls = new LatihanSoal();
            logger.log(
                Level.INFO,
                "{0}, {1}, {2}, {3}, {4}, {5}, {6}%n",
                new Object[] {
                    ls.getKodeSoal(),
                    ls.getPertanyaan(),
                    ls.getPilihanJawaban(),
                    ls.getKunciJawaban(),
                    ls.getWaktuPengerjaan(),
                    ls.getBobot(),
                    ls.getDeadline(),
                }
            );
            ls.periksaJawaban("Abah");
            logger.info("Jawaban sudah diperiksa!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public void menguploadMateri() {
        try {
            // Logic to upload material
            logger.info("Uploading material...");
            Materi m = new Materi();
            m.setJudulMateri("Elektromagnetik");
            m.setIsiMateri(
                "Apa itu elektromagnetik? Elektromagnetik adalah...."
            );
            m.setSumberReferensi("https://www.listrik.co.id");
            logger.info("Material uploaded!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e.getCause());
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
            setTempatBekerja(data.extra1());
            setPengalaman(data.extra2());
            setKemampuan(data.extra3());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e.getCause());
        }
        logger.log(
            Level.INFO,
            "BioData Filled for tutor at {0}",
            tempatBekerja
        );
    }

    private String formatTime(LocalTime time) {
        return String.format(
            "%02d:%02d:%02d",
            time.getHour(),
            time.getMinute(),
            time.getSecond()
        );
    }
}
