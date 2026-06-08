/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.classjadwal;
import com.mycompany.datadiri.*;
import com.mycompany.utils.InputUtils;
import java.util.*;
// import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Akfarizi
 */

 public class JadwalPelajar extends Jadwal implements IfaceJadwal {
    private int idPelajar;
    private String namaPelajar;
    private List<String> schedule;

    private static final Logger logger = Logger.getLogger(
        JadwalPelajar.class.getName()
    );

    public JadwalPelajar(int tanggal, String bulan, int tahun, String hari, String kelas, String mataPelajaran, int idPelajar, String namaPelajar) {
        super(tanggal, bulan, tahun, hari, kelas, mataPelajaran);
        this.idPelajar = idPelajar;
        this.namaPelajar = namaPelajar;
        this.schedule = new ArrayList<String>();
    }
    
    public void initializeSchedule()
    {
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
    public void cekKetersediaan() 
    {
        /* 
            Scanner pelajarS = new Scanner(System.in); 
            System.out.print("Masukan nama: ");
            String namaPelajar = pelajarS.nextLine();
            System.out.print("Masukan tanggal lahir spasi dengan (-): ");
            String dataLahirPelajar = pelajarS.nextLine();
            System.out.print("Tempat tinggal: ");
            String alamatPelajar = pelajarS.nextLine();
            System.out.print("Umur: ");
            int umurPelajar = pelajarS.nextInt();
            Scanner pelajarSS = new Scanner(System.in); 
            System.out.print("Masukan Sekolah: ");
            String sekolah = pelajarSS.nextLine();
            System.out.print("Masukan pelajaran: ");
            String course = pelajarSS.nextLine();
            System.out.print("Masukan tutor: ");
            String Tutor = pelajarSS.nextLine();
            UserPelajar up = new UserPelajar(namaPelajar, dataLahirPelajar, alamatPelajar, pelajarSS.nextLine(),umurPelajar, sekolah, course, Tutor);
            System.out.println("Memeriksa ketersediaan pelajar...");
            System.out.print("Pilih tutor: ");
            up.memilihTutor(pelajarSS.nextLine());
            if(schedule.isEmpty())
            {
                up.menghubungiViaChat();
                up.melakukanPembayaran(20000, namaPelajar,Tutor);
                konfirmasiPesanan();
            }
            else
            {
                System.out.println("Tutor tidak tersedia");
            }
            pelajarSS.close();
            pelajarS.close(); 
        */
        Scanner scan = InputUtils.getScanner();
        BioData data = InputUtils.readBioData(
            scan,
            logger,
            "Masukan email",
            "Masukan Sekolah",
            "Masukan pelajaran",
            "Masukan tutor"
        );

        UserPelajar up = new UserPelajar(
            data.nama(),
            data.dataLahir(),
            data.alamat(),
            data.jenisKelamin(),
            data.umur(),
            data.extra1(),
            data.extra2(),
            data.extra3()
        );
        logger.info("Memeriksa ketersediaan pelajar...");
        logger.info("Pilih tutor: ");
        up.memilihTutor(scan.nextLine());
        if (!schedule.isEmpty()) {
            logger.info("Tutor tidak tersedia");
            return;
        }
        
        up.menghubungiViaChat();
        up.melakukanPembayaran(20000, data.nama(), data.extra3());
        konfirmasiPesanan();
    }

    @Override
    public void konfirmasiPesanan() 
    {
        try 
        {
            System.out.println("Pesanan pelajar dikonfirmasi.");
        } 
        catch (Exception e) 
        {
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
        }
        finally
        {
            System.out.println("Proses selesai!");
        }
    }
}