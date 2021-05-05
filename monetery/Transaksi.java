package monetery;

import java.util.ArrayList;

public class Transaksi {
    private String namaPelanggan;
    private String nomorTelepon;
    private String mataUangDitukarkan;
    private double jumlahUangDitukarkan;
    private String mataUangDidapatkan;
    private double jumlahUangDidapatkan;
    private String tanggalTransaksi;

    public Transaksi(String namaPelanggan, String nomorTelepon, String mataUangDitukarkan, double jumlahUangDitukarkan,
                     String mataUangDidapatkan, double jumlahUangDidapatkan, String tanggalTransaksi) {
        this.namaPelanggan = namaPelanggan;
        this.nomorTelepon = nomorTelepon;
        this.mataUangDitukarkan = mataUangDitukarkan;
        this.jumlahUangDitukarkan = jumlahUangDitukarkan;
        this.mataUangDidapatkan = mataUangDidapatkan;
        this.jumlahUangDidapatkan = jumlahUangDidapatkan;
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getMataUangDitukarkan() {
        return mataUangDitukarkan;
    }

    public void setMataUangDitukarkan(String mataUangDitukarkan) {
        this.mataUangDitukarkan = mataUangDitukarkan;
    }

    public double getJumlahUangDitukarkan() {
        return jumlahUangDitukarkan;
    }

    public void setJumlahUangDitukarkan(double jumlahUangDitukarkan) {
        this.jumlahUangDitukarkan = jumlahUangDitukarkan;
    }

    public String getMataUangDidapatkan() {
        return mataUangDidapatkan;
    }

    public void setMataUangDidapatkan(String mataUangDidapatkan) {
        this.mataUangDidapatkan = mataUangDidapatkan;
    }

    public double getJumlahUangDidapatkan() {
        return jumlahUangDidapatkan;
    }

    public void setJumlahUangDidapatkan(double jumlahUangDidapatkan) {
        this.jumlahUangDidapatkan = jumlahUangDidapatkan;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public void cetak() {
        String format =     "%-30s %5s %s\n";
        System.out.format(format, "Tanggal", " :  ", this.tanggalTransaksi);
        System.out.format(format, "Mata Uang Jual", " :  ", this.mataUangDitukarkan);
        System.out.format(format, "Jumlah Kurs Jual", " :  ", this.jumlahUangDitukarkan);
        System.out.format(format, "Mata Uang Beli", " :  ", this.mataUangDidapatkan);
        System.out.format(format, "Jumlah Kurs Beli", " :  ", this.jumlahUangDidapatkan);
    }

    public static void cetakDaftarTransaksi(ArrayList<Transaksi> daftarTransaksi) {
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.println("===============================================================");
            String format = "%-30s %5s %s\n";
            System.out.format(format, "Nomor", " :  ", i + 1);
            daftarTransaksi.get(i).cetak();
            System.out.println("===============================================================");
        }
    }
}