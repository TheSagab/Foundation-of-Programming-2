/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.Locale;

/**
 * Class untuk merepresentasikan Owjek tipe Regular
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class OwjekRegular extends Owjek  {
    public OwjekRegular(int tahunMotor, int topSpeed, int ccMotor) {
        super(tahunMotor, topSpeed, ccMotor);
    }

    /**
     * Menghitung biaya dengan ketentuan 3000 pada 2 km pertama ditambah
     * 1000 per km selanjutnya
     * @param jarak jarak yang ditempuh per 100m
     * @return biaya
     */
    @Override
    public int getCost(int jarak){
        return jarak < 21 ? 3000 : 3000 + (jarak - 20) * 100;
    }

    /**
     * Menghitung promo dengan ketentuan 40% biaya, maksimal 6km pertama
     * @param jarak jarak yang ditempuh per 100m
     * @param harga harga awal
     * @return biaya promo
     */
    @Override
    public int getPromo(int jarak, int harga){
        int promo = harga * 4 / 10;
        return jarak < 61 ? promo : 2800; // 2800 adalah promo maksimal
    }
    /**
     * Menghitung biaya proteksi dengan biaya 0
     * @param totalHarga harga setelah dikurangi promo
     * @return biaya proteksi
     */
    @Override
    public int getProtectionCost(int totalHarga) {
        return 0;
    }

    /**
     * Mencetak informasi pembayaran
     * @param jarak jarak yang ditempuh
     */
    @Override
    public void printBiaya(int jarak) {
        int harga = getCost(jarak);
        int promo = getPromo(jarak, harga);
        int hargaTotal = harga - promo;
        // Penggunaan locale dari Jerman agar format output desimal
        // menggunakan titik sebagai pemisah
        Locale.setDefault(Locale.GERMANY);
        System.out.println("Terimakasih telah melakukan perjalanan dengan OW-JEK.");
        System.out.printf("[Jarak] %d,%d KM%n", jarak / 10, jarak % 10);
        System.out.println("[TipeO] Regular");
        System.out.println("[2KMPe] Rp 3.000,00 (+)");
        System.out.printf("[KMSel] Rp " + (jarak < 21 ? "-%n" : "%,d,00 (+)%n"), harga-3000);
        System.out.printf("[Promo] Rp %,d,00 (-)%n", promo);
        System.out.printf("[TOTAL] Rp %,d,00%n", hargaTotal);
    }
}
