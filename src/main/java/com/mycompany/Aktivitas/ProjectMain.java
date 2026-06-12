/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Aktivitas;

import com.mycompany.classjadwal.*;
import com.mycompany.datadiri.*;
import com.mycompany.pembelajaran.*;
import com.mycompany.transaksi.*;
import com.mycompany.utils.InputUtils;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import regis.login.*;

/**
 *
 * @author timot
 */
public class ProjectMain {

    private static final Logger logger = Logger.getLogger(
        ProjectMain.class.getName()
    );

    public static void main(String[] args) {
        Scanner scan = InputUtils.getScanner();
        int input = -1;

        logger.info("===== Registrasi =====");
        logger.info("Masukkan Username: ");
        String username = scan.nextLine();
        logger.info("Masukkan Password: ");
        String password = scan.nextLine();
        logger.info("Masukkan Email: ");
        String email = scan.nextLine();

        // Registrasi dengan ID otomatis
        Registrasi regUser = new Registrasi(username, password, email);
        regUser.register(username, password, email);

        logger.info("======== Login =======");
        Login loginUser = new Login(
            regUser.getUsername(),
            regUser.getPassword()
        );
        int attempts = 3; // Batas percobaan login

        while (attempts > 0) {
            logger.info("Masukkan Username: ");
            String inputUsername = scan.nextLine();
            logger.info("Masukkan Password: ");
            String inputPassword = scan.nextLine();
            try {
                if (loginUser.login(inputUsername, inputPassword)) {
                    break; // Berhenti jika login berhasil
                } else {
                    attempts--;
                    if (attempts > 0) {
                        logger.log(Level.INFO, "Sisa percobaan: {0}", attempts);
                    } else {
                        throw new Exception(
                            "Anda telah melebihi batas percobaan login."
                        );
                    }
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error: {0}", e.getMessage());
            }
        }
        logger.info("======== Menu ========");
        do {
            printHeader();
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                scan.nextLine(); // consume newline
            } else {
                scan.next(); // consume invalid input
                continue;
            }
            switch (input) {
                case 1:
                    try {
                        UserPelajar userPelajar = new UserPelajar(
                            "Guest",
                            "xx-xxxx",
                            "NULL",
                            "L/P",
                            0,
                            "Sekolah",
                            "Course",
                            "tutor"
                        );
                        logger.info("Masukan nama: ");
                        String namaPelajar = scan.nextLine();
                        logger.info("Masukan tanggal lahir spasi dengan (-): ");
                        String dataLahirPelajar = scan.nextLine();
                        logger.info("Tempat tinggal: ");
                        String alamatPelajar = scan.nextLine();
                        logger.info("Umur: ");
                        int umurPelajar = -1;
                        if (scan.hasNextInt()) {
                            umurPelajar = scan.nextInt();
                            scan.nextLine();
                        }
                        logger.info("Masukan Sekolah: ");
                        String sekolah = scan.nextLine();
                        logger.info("Masukan pelajaran: ");
                        String course = scan.nextLine();
                        logger.info("Masukan tutor: ");
                        String tutor = scan.nextLine();

                        userPelajar.mengisiBioData(
                            new BioData(
                                namaPelajar,
                                dataLahirPelajar,
                                alamatPelajar,
                                "L/P",
                                umurPelajar,
                                sekolah,
                                course,
                                tutor
                            )
                        );
                        userPelajar.memilihTutor(tutor);
                        userPelajar.menghubungiViaChat();
                        userPelajar.melakukanPembayaran(
                            1000,
                            namaPelajar,
                            tutor
                        );
                    } catch (InputMismatchException e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        UserTutor userTutor = new UserTutor(
                            "Guest",
                            "xx-xxxx",
                            "NULL",
                            "L/P",
                            0,
                            "TempatKerja",
                            "Pengalaman",
                            "kemampuan"
                        );
                        // Untuk menginput biodata yang ada
                        logger.info("Masukan nama: ");
                        String namaTutor = scan.nextLine();
                        logger.info("Masukan tanggal lahir spasi dengan (-): ");
                        String dataLahirTutor = scan.nextLine();
                        logger.info("Tempat tinggal: ");
                        String alamatTutor = scan.nextLine();
                        logger.info("Umur: ");
                        int umurTutor = -1;
                        if (scan.hasNextInt()) {
                            umurTutor = scan.nextInt();
                            scan.nextLine();
                        }
                        logger.info("Tempat berkerja saat ini: ");
                        String tempatBekerja = scan.nextLine();
                        logger.info("Pengalaman: ");
                        String pengalaman = scan.nextLine();
                        logger.info("Kemampuan: ");
                        String kemampuan = scan.nextLine();
                        userTutor.mengisiBioData(
                            new BioData(
                                namaTutor,
                                dataLahirTutor,
                                alamatTutor,
                                "L/P",
                                umurTutor,
                                tempatBekerja,
                                pengalaman,
                                kemampuan
                            )
                        );

                        logger.info("Apakah menerima pesanan? (ya/tidak): ");
                        String approval = scan.nextLine();
                        if ("ya".equalsIgnoreCase(approval)) {
                            userTutor.menerimaPesanan("Pesan");
                        } else if ("tidak".equalsIgnoreCase(approval)) {
                            userTutor.menolakPesanan("Pesan");
                        } else {
                            logger.info(
                                "Bukan jawaban valid, masukkan respon yang benar"
                            );
                        }
                    } catch (InputMismatchException e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }
                    break;
                case 3:
                    JadwalPelajar pelajar = new JadwalPelajar(
                        new DateInfo(5, "Desember", 2024, "Kamis"),
                        "12A",
                        "Matematika",
                        201,
                        "Andi"
                    );
                    logger.info(pelajar.getPelajarInfo());
                    pelajar.cekKetersediaan();
                    break;
                case 4:
                    JadwalTutor tutor = new JadwalTutor(
                        new DateInfo(5, "Desember", 2024, "Kamis"),
                        "12A",
                        "Matematika",
                        101,
                        "Budi",
                        4.5f
                    );

                    logger.info(tutor.getTutorInfo());
                    tutor.cekKetersediaan();
                    break;
                case 5:
                    try {
                        logger.info(
                            "Masukkan Jenjang Pendidikan (SD/SMP/SMA/SMK/Kuliah): "
                        );
                        String jenjang = scan.nextLine().toUpperCase();

                        Pembelajaran pembelajaran = new Pembelajaran();
                        pembelajaran.setJenjangPendidikan(jenjang);

                        LatihanSoal latihanSoal = new LatihanSoal();
                        Materi materi = new Materi();

                        if (jenjang.equals("SD")) {
                            pembelajaran.setNamaMataPelajaran(
                                "Matematika Dasar"
                            );
                            pembelajaran.setKodeMataPelajaran("MATH-SD");
                            materi.setJudulMateri(
                                "Penjumlahan dan Pengurangan"
                            );
                            materi.setIsiMateri(
                                "Dasar penjumlahan dan pengurangan untuk kelas SD."
                            );
                            materi.setSumberReferensi(
                                "Buku SD Matematika Dasar"
                            );

                            latihanSoal.setKodeSoal("SOAL-SD-01");
                            latihanSoal.setPertanyaan("Berapakah 2 + 2?");
                            latihanSoal.setPilihanJawaban("A. 3\nB. 4\nC. 5");
                            latihanSoal.setKunciJawaban("B");
                        } else if (jenjang.equals("SMP")) {
                            pembelajaran.setNamaMataPelajaran("Fisika Dasar");
                            pembelajaran.setKodeMataPelajaran("PHYS-SMP");
                            materi.setJudulMateri("Hukum Newton");
                            materi.setIsiMateri(
                                "Penjelasan dasar tentang hukum Newton 1, 2, dan 3."
                            );
                            materi.setSumberReferensi("Buku SMP Fisika Dasar");

                            latihanSoal.setKodeSoal("SOAL-SMP-01");
                            latihanSoal.setPertanyaan("Apa hukum Newton 1?");
                            latihanSoal.setPilihanJawaban(
                                "A. Gaya = Massa x Percepatan\nB. Benda diam akan tetap diam\nC. Setiap aksi ada reaksi"
                            );
                            latihanSoal.setKunciJawaban("B");
                        } else if (jenjang.equals("SMA")) {
                            pembelajaran.setNamaMataPelajaran("Kimia");
                            pembelajaran.setKodeMataPelajaran("CHEM-SMA");
                            materi.setJudulMateri("Ikatan Kimia");
                            materi.setIsiMateri(
                                "Penjelasan tentang ikatan ionik dan kovalen."
                            );
                            materi.setSumberReferensi("Buku SMA Kimia");

                            latihanSoal.setKodeSoal("SOAL-SMA-01");
                            latihanSoal.setPertanyaan(
                                "Ikatan ionik terjadi karena?"
                            );
                            latihanSoal.setPilihanJawaban(
                                "A. Transfer elektron\nB. Berbagi elektron\nC. Tidak ada elektron"
                            );
                            latihanSoal.setKunciJawaban("A");
                        } else if (jenjang.equals("SMK")) {
                            pembelajaran.setNamaMataPelajaran(
                                "Pemrograman Dasar"
                            );
                            pembelajaran.setKodeMataPelajaran("CS-SMK");
                            materi.setJudulMateri("Algoritma dan Flowchart");
                            materi.setIsiMateri(
                                "Penjelasan tentang cara membuat algoritma dan flowchart."
                            );
                            materi.setSumberReferensi(
                                "Buku SMK Pemrograman Dasar"
                            );

                            latihanSoal.setKodeSoal("SOAL-SMK-01");
                            latihanSoal.setPertanyaan(
                                "Apa simbol untuk proses dalam flowchart?"
                            );
                            latihanSoal.setPilihanJawaban(
                                "A. Persegi Panjang\nB. Lingkaran\nC. Belah Ketupat"
                            );
                            latihanSoal.setKunciJawaban("A");
                        } else if (jenjang.equals("KULIAH")) {
                            pembelajaran.setNamaMataPelajaran(
                                "Pemrograman Berorientasi Objek"
                            );
                            pembelajaran.setKodeMataPelajaran("CS-UNI");
                            materi.setJudulMateri("Konsep Dasar OOP");
                            materi.setIsiMateri(
                                "Penjelasan tentang class, object, inheritance, dan polymorphism."
                            );
                            materi.setSumberReferensi("Buku Java Programming");

                            latihanSoal.setKodeSoal("SOAL-UNI-01");
                            latihanSoal.setPertanyaan("Apa itu Polymorphism?");
                            latihanSoal.setPilihanJawaban(
                                "A. Kemampuan objek berubah bentuk\nB. Pewarisan sifat\nC. Pengkapsulan data"
                            );
                            latihanSoal.setKunciJawaban("A");
                        } else {
                            logger.info("Jenjang pendidikan tidak dikenali.");
                        }
                        logger.info("\n--- Informasi Pembelajaran ---");
                        pembelajaran.tampilkanInfo();

                        logger.info("\n--- Materi ---");
                        materi.tampilkanMateri();

                        logger.info("\n--- Latihan Soal ---");
                        logger.log(
                            Level.INFO,
                            "Pertanyaan: {0}",
                            latihanSoal.getPertanyaan()
                        );
                        logger.log(
                            Level.INFO,
                            "Pilihan Jawaban:\n{0}",
                            latihanSoal.getPilihanJawaban()
                        );
                        logger.info("Masukkan Jawaban Anda: ");
                        String jawabanUser = scan.nextLine();
                        latihanSoal.periksaJawaban(jawabanUser);
                    } catch (Exception e) {
                        logger.log(
                            Level.SEVERE,
                            "Terjadi error: {0}",
                            e.getMessage()
                        );
                    }
                    break;
                case 6:
                    Pembayaran pembayaran = new Pembayaran(
                        500000,
                        "pending",
                        "Nadya",
                        "Tutor A",
                        "bukti123.png"
                    );
                    pembayaran.memesanDosen();
                    pembayaran.melakukanPembayaran();
                    pembayaran.mendapatBuktiBayar();
                    logger.log(
                        Level.INFO,
                        "Status Pembayaran: {0}",
                        pembayaran.lihatStatus()
                    );
                    break;
                case 7:
                    // Contoh transaksi refund
                    Refund refund = new Refund(
                        500000,
                        "sukses",
                        "Pengajuan refund karena kelas batal.",
                        "Nadya"
                    );
                    refund.membuatSuratPengajuanRefund();
                    refund.dapatUangKembali();
                    break;
                case 8:
                    try {
                        Diskusi diskusi = new Diskusi(
                            "Kapan aja",
                            60,
                            "diam",
                            "Forum B",
                            120
                        );
                        diskusi.MulaiDiskusi();
                        logger.info(diskusi.cekStatus());
                        logger.log(Level.INFO, "{0}", diskusi.getDurasi());
                        diskusi.TutupDiskusi();
                        diskusi.MenjawabPertanyaan();
                        logger.info(diskusi.cekStatus());
                    } catch (Exception e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        Konsultasi konsul = new Konsultasi(
                            "11-04-2025",
                            100,
                            "diam",
                            "TutorA",
                            "Ruangan B"
                        );
                        konsul.setAktivitas("Mulai");
                        logger.info(konsul.getJadwal());
                        logger.info(konsul.cekStatus());
                        logger.info("Pilih tutor: ");
                        konsul.MenentukanTutor();
                        logger.info("Tentukan jadwal konsultasi: ");
                        konsul.MelakukanPenjadwalan();
                        logger.info("Pilih topik konsultasi: ");
                        konsul.MenentukanTopik();
                        logger.info("Pilih tempat konsultasi: ");
                        konsul.MengaturTempat();
                        konsul.setAktivitas("Selesai");
                        logger.info(konsul.cekStatus());
                    } catch (Exception e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        SesiTutoring sesiTutoring = new SesiTutoring(
                            "01-04-2025",
                            180,
                            "diam",
                            "Murid1",
                            "Tutor1",
                            "Tugas1",
                            "Math",
                            "Notes"
                        );
                        sesiTutoring.setAktivitas("Mulai");
                        logger.info(sesiTutoring.getJadwal());
                        logger.info(sesiTutoring.cekStatus());
                        sesiTutoring.setNamaCourse("Biologi");
                        logger.info(sesiTutoring.getNamaCourse());
                        sesiTutoring.setIDMurid("Budi");
                        logger.info(sesiTutoring.getIDMurid());
                        sesiTutoring.setIDTutor("Anto");
                        logger.info(sesiTutoring.getIDTutor());
                        logger.info("Masukkan tugas sesi tutoring: ");
                        sesiTutoring.setTugas(scan.nextLine());
                        logger.info(sesiTutoring.getTugas());
                        sesiTutoring.selesaikanTugas();
                        logger.info("Buat catatan: ");
                        sesiTutoring.tambahCatatanPembelajaran();
                        sesiTutoring.setAktivitas("Selesai");
                        sesiTutoring.postTugas();
                        sesiTutoring.postCatatanPembelajaran();
                        logger.info(sesiTutoring.cekStatus());
                    } catch (Exception e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }
                    break;
                case 0:
                    logger.info("Terimakasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    logger.info(
                        "[Error] Salah memasukkan angka, masukkan angka yang valid"
                    );
                    break;
            }
        } while (input != 0);
    }

    public static void printHeader() {
        logger.info("1. Identitas pelajar");
        logger.info("2. Identitas tutor");
        logger.info("3. Jadwal pelajar");
        logger.info("4. Jadwal tutor");
        logger.info("5. materi");
        logger.info("6. Transaksi");
        logger.info("7. Refund");
        logger.info("8. Diskusi");
        logger.info("9. Konsultasi");
        logger.info("10. Tutoring");
        logger.info("0. Keluar");
        logger.info("Masukkan input >>");
    }
}
