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
public class JadwalPelajar extends Jadwal implements IfaceJadwal {

    private static final Logger logger = Logger.getLogger(
        JadwalPelajar.class.getName()
    );

    private int idPelajar;
    private String namaPelajar;
    private List<String> schedule;

    public JadwalPelajar(
        DateInfo dateInfo,
        String kelas,
        String mataPelajaran,
        int idPelajar,
        String namaPelajar
    ) {
        super(dateInfo, kelas, mataPelajaran);
        this.idPelajar = idPelajar;
        this.namaPelajar = namaPelajar;
        this.schedule = new ArrayList<>();
    }

    public void initializeSchedule() {
        // Sementara, agak bingung buat yang ini
        schedule.add(4, "Senin");
        schedule.add(0, "Selasa");
        schedule.add(3, "Rabu");
        schedule.add(5, "Kamis");
        schedule.add(2, "Jumat");
        schedule.add(1, "Sabtu");
    }

    public String getPelajarInfo() {
        return "ID Pelajar: " + idPelajar + ", Nama: " + namaPelajar;
    }

    @Override
    public void cekKetersediaan() {
        Scanner scan = InputUtils.getScanner();
        logger.info("Masukan nama: ");
        String inputNamaPelajar = scan.nextLine();
        logger.info("Masukan tanggal lahir spasi dengan (-): ");
        String dataLahirPelajar = scan.nextLine();
        logger.info("Tempat tinggal: ");
        String alamatPelajar = scan.nextLine();
        logger.info("Umur: ");
        int umurPelajar = -1;
        if (scan.hasNextInt()) {
            umurPelajar = scan.nextInt();
            scan.nextLine(); // consume newline
        }
        logger.info("Masukan Sekolah: ");
        String sekolah = scan.nextLine();
        logger.info("Masukan pelajaran: ");
        String course = scan.nextLine();
        logger.info("Masukan tutor: ");
        String tutor = scan.nextLine();
        logger.info("Masukan email: ");
        String email = scan.nextLine();
        UserPelajar up = new UserPelajar(
            inputNamaPelajar,
            dataLahirPelajar,
            alamatPelajar,
            email,
            umurPelajar,
            sekolah,
            course,
            tutor
        );
        logger.info("Memeriksa ketersediaan pelajar...");
        logger.info("Pilih tutor: ");
        up.memilihTutor(scan.nextLine());
        if (schedule.isEmpty()) {
            up.menghubungiViaChat();
            up.melakukanPembayaran(20000, inputNamaPelajar, tutor);
            konfirmasiPesanan();
        } else {
            logger.info("Tutor tidak tersedia");
        }
    }

    @Override
    public void konfirmasiPesanan() {
        try {
            logger.info("Pesanan pelajar dikonfirmasi.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            logger.info("Proses selesai!");
        }
    }
}
