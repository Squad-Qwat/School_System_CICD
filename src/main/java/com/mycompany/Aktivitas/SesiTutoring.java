/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Aktivitas;

import com.mycompany.utils.InputUtils;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timot
 */
public class SesiTutoring extends Aktivitas {

    private static final Logger logger = Logger.getLogger(
        SesiTutoring.class.getName()
    );

    public record TutoringDetails(
        String idMurid,
        String idTutor,
        String tugas,
        String namaCourse,
        String catatanPembelajaran
    ) {}

    private String idMurid;
    private String idTutor;
    private String tugas;
    private String namaCourse;
    private String catatanPembelajaran;

    public SesiTutoring(
        String jadwal,
        int durasi,
        String status,
        TutoringDetails details
    ) {
        super(jadwal, durasi, status);
        this.idMurid = details.idMurid();
        this.idTutor = details.idTutor();
        this.tugas = details.tugas();
        this.namaCourse = details.namaCourse();
        this.catatanPembelajaran = details.catatanPembelajaran();
    }

    public String getIdMurid() {
        return idMurid;
    }

    public void setIdMurid(String idMurid) {
        this.idMurid = idMurid;
    }

    public String getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(String idTutor) {
        this.idTutor = idTutor;
    }

    public String getTugas() {
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getNamaCourse() {
        return namaCourse;
    }

    public void setNamaCourse(String namaCourse) {
        this.namaCourse = namaCourse;
    }

    public String getCatatanPembelajaran() {
        return catatanPembelajaran;
    }

    public void setCatatanPembelajaran(String catatanPembelajaran) {
        this.catatanPembelajaran = catatanPembelajaran;
    }

    public void postTugas() {
        try {
            logger.log(Level.INFO, "Post Tugas: {0}%n", getTugas());
            logger.info("Tugas telah diposting");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public void postCatatanPembelajaran() {
        try {
            logger.log(
                Level.INFO,
                "Post Catatan Pembelajaran: {0}%n",
                getCatatanPembelajaran()
            );
            logger.info("Catatan telah dipost");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public void selesaikanTugas() {
        try {
            logger.log(Level.INFO, "Menyelesaikan tugas: {0}%n", getTugas());
            logger.info("Tugas telah diselesaikan");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public void tambahCatatanPembelajaran() {
        Scanner scan = InputUtils.getScanner();
        try {
            if (scan.hasNextLine()) {
                setCatatanPembelajaran(scan.nextLine());
            }
            logger.log(
                Level.INFO,
                "Tambah Catatan Pembelajaran: {0}%n",
                getCatatanPembelajaran()
            );
            logger.info("Catatan telah ditambah");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
