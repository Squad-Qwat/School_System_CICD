/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pembelajaran;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Pembelajaran {

    private static final Logger logger = Logger.getLogger(
        Pembelajaran.class.getName()
    );

    private String kodeMataPelajaran;
    private String namaMataPelajaran;
    private String jenjangPendidikan;

    public String getKodeMataPelajaran() {
        return kodeMataPelajaran;
    }

    public void setKodeMataPelajaran(String kode) {
        this.kodeMataPelajaran = kode;
    }

    public String getNamaMataPelajaran() {
        return namaMataPelajaran;
    }

    public void setNamaMataPelajaran(String nama) {
        this.namaMataPelajaran = nama;
    }

    public String getJenjangPendidikan() {
        return jenjangPendidikan;
    }

    public void setJenjangPendidikan(String pendidikan) {
        this.jenjangPendidikan = pendidikan;
    }

    public void tampilkanInfo() {
        try {
            logger.log(
                Level.INFO,
                "Kode Mata Pelajaran: {0}",
                kodeMataPelajaran
            );
            logger.log(
                Level.INFO,
                "Nama Mata Pelajaran: {0}",
                namaMataPelajaran
            );
            logger.log(
                Level.INFO,
                "Jenjang Pendidikan: {0}",
                jenjangPendidikan
            );
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
        }
    }
}
