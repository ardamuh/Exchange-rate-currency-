package monetery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DuaKertas {
    private ArrayList<Kurs> daftarKurs = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    boolean isRunning = true;
    boolean isLoggedIn = false;
    private String username;
    private String password;

    public void runProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================================");
        System.out.println("==================Selamat datang di Dua Kertas=================");
        System.out.println("===============================================================");

        do {
            System.out.println("===============================================================");
            System.out.println("Menu: ");
            System.out.println("1. Login");
            System.out.println("2. Pendataan Nilai Tukar Mata Uang");
            System.out.println("3. Pendataan Transaksi Penukaran");
            System.out.println("4. Menampilkan Data Transaksi Penukaran");
            System.out.println("5. Logout");
            System.out.print("Masukkan pilihan: ");

            int selected = scanner.nextInt();
            switch (selected) {
                case 1:
                    System.out.println("===============================================================");
                    System.out.println("Login");
                    System.out.print("Username: ");
                    scanner.nextLine();
                    username = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    isLoggedIn = true;

                    System.out.println("Selamat datang, " + username);
                    break;
                case 2:
                    if (isLoggedIn) {
                        System.out.println("===============================================================");
                        System.out.println("Pendataan Nilai Tukar Mata Uang");
                        System.out.print("Masukkan Mata Uang: ");
                        scanner.nextLine();
                        String mataUang = scanner.nextLine();
                        System.out.print("Masukkan Kurs Jual: ");
                        double kursJual = scanner.nextDouble();
                        System.out.print("Masukkan Kurs Beli: ");
                        double kursBeli = scanner.nextDouble();

                        Kurs kurs = new Kurs(mataUang, kursJual, kursBeli);
                        daftarKurs.add(kurs);

                        System.out.println("Berhasil menambah nilai tukar mata uang.");
                        System.out.println("===============================================================");
                        Kurs.cetakDaftarKurs(daftarKurs);
                        System.out.println("===============================================================");
                    } else {
                        System.out.println("Anda harus login terlebih dahulu.");
                    }
                    break;
                case 3:
                    if (isLoggedIn) {
                        System.out.println("===============================================================");
                        System.out.println("Pendataan Transaksi Penukaran");
                        System.out.print("Masukkan Nama Pelanggan: ");
                        scanner.nextLine();
                        String namaPelanggan = scanner.nextLine();
                        System.out.print("Nomor Telp Pelanggan: ");
                        String nomorTelepon = scanner.nextLine();
                        System.out.print("Mata uang yang ditukarkan: ");
                        String mataUangDitukarkan = scanner.nextLine();
                        System.out.print("Jumlah uang yang ditukarkan: ");
                        double jumlahUangDitukarkan = scanner.nextDouble();
                        System.out.print("Mata uang yang didapatkan: ");
                        scanner.nextLine();
                        String mataUangDidapatkan = scanner.nextLine();

                        double jumlahUangDidapatkan = 0L;
                        if (mataUangDitukarkan.equalsIgnoreCase("IDR")) {
                            Kurs dicari = Kurs.cariKurs(mataUangDidapatkan, daftarKurs);
                            if (dicari != null) {
                                jumlahUangDidapatkan = Kurs.jumlahDidapatkan(true, dicari, jumlahUangDitukarkan);
                            } else {
                                System.out.println("Mata uang tidak ditemukan.");
                                break;
                            }
                        } else {
                            Kurs dicari = Kurs.cariKurs(mataUangDitukarkan, daftarKurs);
                            if (dicari != null) {
                                jumlahUangDidapatkan = Kurs.jumlahDidapatkan(false, dicari, jumlahUangDitukarkan);
                            } else {
                                System.out.println("Mata uang tidak ditemukan.");
                                break;
                            }
                        }

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                        LocalDateTime now = LocalDateTime.now();
                        String tanggal = dtf.format(now);

                        Transaksi transaksi = new Transaksi(namaPelanggan, nomorTelepon, mataUangDitukarkan,
                                jumlahUangDitukarkan, mataUangDidapatkan, jumlahUangDidapatkan, tanggal);
                        daftarTransaksi.add(transaksi);

                        System.out.println("Berhasil menambahkan transaksi.");
                        System.out.println("===============================================================");
                    } else {
                        System.out.println("Anda harus login terlebih dahulu.");
                    }
                    break;
                case 4:
                    if (isLoggedIn) {
                        System.out.println("===============================================================");
                        System.out.println("Menampilkan Data Transaksi Penukaran");
                        Transaksi.cetakDaftarTransaksi(daftarTransaksi);
                        System.out.println("===============================================================");
                    } else {
                        System.out.println("Anda harus login terlebih dahulu.");
                    }
                    break;
                case 5:
                    System.out.println("===============================================================");
                    System.out.println("Anda akan keluar dari program, sampai jumpa kembali!");
                    System.out.println("===============================================================");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opsi tidak tersedia");
            }
        } while (isRunning);
    }

    public static void main(String[] args) {
        DuaKertas duaKertas = new DuaKertas();
        duaKertas.runProgram();
    }
}
