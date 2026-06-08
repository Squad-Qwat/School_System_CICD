# School_System_CICD

## Deskripsi Proyek
Aplikasi School System ini merupakan sebuah aplikasi Java berbasis CLI (Command Line Interface) yang menyediakan platform pembelajaran dan tutoring interaktif. Aplikasi ini mencakup fitur pengelolaan identitas pelajar dan tutor, registrasi dan login, penjadwalan kelas, modul materi pembelajaran, aktivitas sesi tutoring, diskusi, konsultasi, serta sistem transaksi dan refund. Proyek ini dibangun dengan bahasa pemrograman Java dan manajemen dependency menggunakan Maven.

**Arsitektur Pipeline CI/CD:**
1. **Continuous Integration (CI)**: Pipeline akan melakukan checkout kode, mengatur environment JDK 21, dan memverifikasi kompilasi aplikasi (`mvn clean compile`) setiap kali terdapat push atau pull request.
2. **Continuous Testing (CT)**: Menjalankan *unit testing* (`mvn -B test`) menggunakan JUnit dan Surefire secara otomatis lintas OS (Ubuntu dan Windows), dan mengumpulkan hasil *coverage* dengan Jacoco.
3. **Continuous Inspection**: Terintegrasi dengan SonarCloud untuk melakukan *static code analysis* dan memastikan kualitas kode terjaga, bebas dari kerentanan (*vulnerability*) maupun *code smells*.
4. **Continuous Delivery (CD)**: Kode yang telah lolos di branch utama siap untuk didistribusikan atau dirilis dalam bentuk *artifact* JAR ke platform tujuan.

**Strategi Branching:**
- Branch `feat/*` dan `dev`: Digunakan untuk pengembangan fitur baru. Memicu proses CI, CT, dan Continuous Inspection (SonarCloud) untuk validasi awal.
- Branch `main`: Branch *production-ready* yang menjadi target *deployment* otomatis (CD).

**Pilihan CD dan Alasannya:**
- **Pilihan CD**: Continuous Delivery
- **Alasan**: Aplikasi berbasis CLI biasanya didistribusikan dalam bentuk *executable* atau *artifact* JAR kepada pengguna akhir, bukan di-deploy langsung secara berjalan terus-menerus (seperti web server). Oleh karena itu, pengiriman versi yang tervalidasi secara manual (Continuous Delivery) lebih sesuai agar pengguna dapat mengunduh versi rilis yang stabil.
- **Platform deploy**: VPS / GitHub Releases.

## Fungsionalitas Utama
Sistem ini memfasilitasi kebutuhan esensial *e-learning* dalam bentuk aplikasi terminal:
1. **Sistem Autentikasi**: Fitur registrasi dan login yang aman untuk mengidentifikasi *user*.
2. **Manajemen Profil**: Pengelolaan data diri (biodata) secara terpisah untuk *role* Pelajar dan Tutor.
3. **Penjadwalan Kelas**: Fitur untuk melihat, membuat, dan memvalidasi ketersediaan jadwal bagi Pelajar maupun Tutor.
4. **Modul Pembelajaran**: Menyediakan penyampaian materi pelajaran serta evaluasi berupa Latihan Soal yang terstruktur berdasarkan jenjang pendidikan (SD hingga Kuliah).
5. **Manajemen Aktivitas Interaktif**: Meliputi ruang forum (Diskusi), pengajuan bimbingan (Konsultasi), serta pengelolaan tugas dan catatan pembelajaran dalam Sesi Tutoring.
6. **Sistem Finansial**: Transaksi pembayaran sesi *course*/tutor beserta fitur pengajuan pengembalian dana (*Refund*).

## Gambaran Arsitektur
Proyek ini mengadopsi arsitektur **Monolitik Modular** (*Package-by-Feature*) yang kental dengan prinsip Object-Oriented Programming (OOP) menggunakan bahasa Java. Sistem memisahkan logika ke dalam beberapa modul domain utama (`com.mycompany`):
- `regis.login`: Modul pengelolaan identitas dasar dan sesi masuk.
- `datadiri`: Domain entitas terkait profil mendetail *user* (Pelajar & Tutor).
- `pembelajaran`: Logika inti untuk representasi kursus, materi, dan instrumen penilaian.
- `classjadwal`: Manajemen waktu dan alokasi sesi mengajar.
- `Aktivitas`: Kumpulan *class* yang mengimplementasikan polimorfisme (*inheritance* dari *base class* Aktivitas) untuk berbagai metode belajar seperti Diskusi, Konsultasi, dan Tutoring.
- `transaksi`: Domain *billing* yang menangani siklus hidup pesanan, validasi pembayaran, dan refund.
Eksekusi utama diatur secara sentral oleh sebuah *orchestrator class* CLI yaitu `ProjectMain`.

## Pembagian Tugas
| No | Nama | Komponen | Tanggung Jawab |
|---|---|---|---|
| 1 | Muhammad Abiyu Al-Ghiffari | Continuous Integration | Mengatur pipeline GitHub Actions untuk tahapan *build* Maven dan manajemen *environment* |
| 2 | Afriza Gilleon Ginting | Continuous Testing | Membuat *unit test* menggunakan JUnit 5 dan mengkonfigurasi laporan *coverage* Jacoco |
| 3 | Timotius Darrel Putra Arma | Continuous Inspection | Menghubungkan *repository* dan menjalankan pemindaian SonarCloud via Maven plugin |
| 4 | Fa Ai Nama Caldera Sudibyo | Continuous Deployment | Mempersiapkan otomatisasi rilis *artifact* ke *environment* akhir (VPS/Releases) |

## Tools dan Teknologi
| Tahap Pipeline | Tools | Keterangan |
|---|---|---|
| CI | GitHub Actions, Maven, JDK 21 | Mengelola *workflow* otomatis dan *build tool* (Maven compiler plugin) |
| CT | JUnit 5, Jacoco, Maven Surefire | Digunakan untuk melakukan *unit testing* lintas OS (Windows, Ubuntu) dan pelaporan uji |
| Inspection | SonarCloud | Plugin Maven (`sonar-maven-plugin`) untuk menganalisa kualitas kode |
| CD | GitHub Actions / VPS | Rilis *artifact* atau pengiriman aplikasi otomatis |

## Cara Menjalankan Proyek

### Prerequisites
- **Java**: Versi 21.0.9 (LTS)
- **Maven**: Versi 3.9.16
- **Git**

### Instalasi dan Build
```bash
git clone https://github.com/Squad-Qwat/School_System_CICD.git
cd School_System_CICD
mvn clean install
```

### Menjalankan Aplikasi
Aplikasi dieksekusi dengan mendefinisikan *main class*:
```bash
mvn exec:java -Dexec.mainClass="com.mycompany.Aktivitas.ProjectMain"
```

**Contoh Input/Output Aplikasi CLI:**

**Skenario 1: Registrasi dan Login**
```
===== Registrasi =====
Masukkan Username: budi
Masukkan Password: 123
Masukkan Email: budi@gmail.com
======== Login =======
Masukkan Username: budi
Masukkan Password: 123
Login berhasil! Selamat datang, budi
```

**Skenario 2: Melihat Jadwal Pelajar (Menu 3)**
```
======== Menu ========
...
Masukkan input >> 3
Jadwal: 5 Desember 2024, Kamis pukul 12A
Mata Pelajaran: Matematika
Ruangan: 201
Nama Pelajar: Andi
Memeriksa ketersediaan pelajar...
```

**Skenario 3: Melihat Jadwal Tutor (Menu 4)**
```
======== Menu ========
...
Masukkan input >> 4
Jadwal: 5 Desember 2024, Kamis pukul 12A
Mata Pelajaran: Matematika
Ruangan: 101
Nama Tutor: Budi
Rating Tutor: 4.5
Memeriksa ketersediaan tutor...
```

**Skenario 4: Proses Transaksi (Menu 6)**
```
======== Menu ========
...
Masukkan input >> 6
Tutor berhasil dipesan.
Pembayaran sedang diproses...
Pembayaran dilakukan oleh Nadya
Pembayaran diterima oleh Tutor A
Bukti pembayaran: bukti123.png
Status Pembayaran: lunas
```

**Skenario 5: Pengajuan Refund (Menu 7)**
```
======== Menu ========
...
Masukkan input >> 7
Surat pengajuan refund dibuat oleh: Nadya
Isi surat: Pengajuan refund karena kelas batal.
sukses
Uang sejumlah 500000 telah dikembalikan kepada Nadya
```

### Menjalankan Unit Test
```bash
mvn test
```

**Ringkasan Hasil Test:**
```
[INFO] Results:
[INFO]
[INFO] Tests run: 29, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
