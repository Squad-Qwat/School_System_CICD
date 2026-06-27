package com.mycompany.pembelajaran;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Materi {

    private static final Logger logger = Logger.getLogger(
        Materi.class.getName()
    );
    private String judulMateri;
    private String isiMateri;
    private String sumberReferensi;

    public String getJudulMateri() {
        return judulMateri;
    }

    public void setJudulMateri(String judul) {
        this.judulMateri = judul;
    }

    public String getIsiMateri() {
        return isiMateri;
    }

    public void setIsiMateri(String isi) {
        this.isiMateri = isi;
    }

    public String getSumberReferensi() {
        return sumberReferensi;
    }

    public void setSumberReferensi(String sumber) {
        this.sumberReferensi = sumber;
    }

    public void tampilkanMateri() {
        try {
            logger.log(Level.INFO, "Judul Materi: {0}", judulMateri);
            logger.log(Level.INFO, "Isi Materi: {0}", isiMateri);
            logger.log(Level.INFO, "Sumber Referensi: {0}", sumberReferensi);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
        }
    }
}
