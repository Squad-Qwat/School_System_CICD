package com.mycompany.pembelajaran;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LatihanSoal {

    private static final Logger logger = Logger.getLogger(
        LatihanSoal.class.getName()
    );
    private String kodeSoal;
    private String pertanyaan;
    private String pilihanJawaban;
    private String kunciJawaban;
    private int waktuPengerjaan;
    private int bobot;
    private int deadline;

    public String getKodeSoal() {
        return kodeSoal;
    }

    public void setKodeSoal(String kode) {
        this.kodeSoal = kode;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String soal) {
        this.pertanyaan = soal;
    }

    public String getPilihanJawaban() {
        return pilihanJawaban;
    }

    public void setPilihanJawaban(String pilihan) {
        this.pilihanJawaban = pilihan;
    }

    public String getKunciJawaban() {
        return kunciJawaban;
    }

    public void setKunciJawaban(String jawaban) {
        this.kunciJawaban = jawaban;
    }

    public int getWaktuPengerjaan() {
        return waktuPengerjaan;
    }

    public void setWaktuPengerjaan(int waktu) {
        this.waktuPengerjaan = waktu;
    }

    public int getBobot() {
        return bobot;
    }

    public void setBobot(int nilai) {
        this.bobot = nilai;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int tenggat) {
        this.deadline = tenggat;
    }

    public void periksaJawaban(String jawaban) {
        try {
            if (jawaban.equals(kunciJawaban)) {
                logger.info("Jawaban Benar!");
            } else {
                logger.info("Jawaban Salah!");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
        }
    }
}
