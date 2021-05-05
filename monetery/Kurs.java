package monetery;

import java.util.ArrayList;

public class Kurs {
    private String mataUang;
    private double kursJual;
    private double kursBeli;

    public Kurs(String mataUang, double kursJual, double kursBeli) {
        this.mataUang = mataUang;
        this.kursJual = kursJual;
        this.kursBeli = kursBeli;
    }

    public String getMataUang() {
        return mataUang;
    }

    public void setMataUang(String mataUang) {
        this.mataUang = mataUang;
    }

    public double getKursJual() {
        return kursJual;
    }

    public void setKursJual(double kursJual) {
        this.kursJual = kursJual;
    }

    public double getKursBeli() {
        return kursBeli;
    }

    public void setKursBeli(double kursBeli) {
        this.kursBeli = kursBeli;
    }

    public static double jumlahDidapatkan(boolean isFromIdr, Kurs kursDidapatkan, double nominal) {
        double didapatkan;
        if (isFromIdr) {
            didapatkan = nominal * kursDidapatkan.kursJual;
        } else {
            didapatkan = nominal * kursDidapatkan.kursBeli;
        }
        return didapatkan;
    }

    public static Kurs cariKurs(String mataUang, ArrayList<Kurs> daftarKurs) {
        Kurs dicari = null;
        for (Kurs kurs : daftarKurs) {
            if (kurs.mataUang.equalsIgnoreCase(mataUang)) {
                dicari = kurs;
                break;
            }
        }
        return dicari;
    }

    public static void cetakDaftarKurs(ArrayList<Kurs> daftarKurs) {
        final Object[][] table = new String[daftarKurs.size() + 1][];
        table[0] = new String[]{"Mata Uang", "Kurs Jual", "Kurs Beli"};
        for (int i = 0; i < daftarKurs.size(); i++) {
            table[i + 1] = new String[]{daftarKurs.get(i).getMataUang(), String.valueOf(daftarKurs.get(i).getKursJual()), String.valueOf(daftarKurs.get(i).getKursBeli())};
        }

        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%n", row);
        }
    }
}