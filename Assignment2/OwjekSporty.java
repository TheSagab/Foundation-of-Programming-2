/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.Locale;

/**
 * Class untuk merepresentasikan Owjek tipe Sporty
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class OwjekSporty extends Owjek {
    public OwjekSporty(int tahunMotor, int topSpeed, int ccMotor) {
        super(tahunMotor, topSpeed, ccMotor);
    }

    /**
     * Menghitung biaya dengan ketentuan 20000 pada 5 km pertama ditambah
     * 3000 per km selanjutnya
     * @param jarak jarak yang ditempuh per 100m
     * @return biaya
     */
    @Override
    public int getCost(int jarak){
        return jarak < 51 ? 20000 : 20000 + (jarak - 50) * 300;
    }

    /**
     * Menghitung promo dengan ketentuan 60% biaya, maksimal 8km pertama
     * @param jarak jarak yang ditempuh per 100m
     * @param harga harga awal
     * @return biaya promo
     */
    @Override
    public int getPromo(int jarak, int harga){
        int promo = harga * 6 / 10;
        return jarak < 81 ? promo : 17400; //17400 adalah promo maksimal
    }
    /**
     * Menghitung biaya proteksi dengan ketentuan 10% harga
     * setelah dikurangi promo
     * @param totalHarga harga setelah dikurangi promo
     * @return biaya proteksi
     */
    @Override
    public int getProtectionCost(int totalHarga) {
        return totalHarga / 10;
    }

    /**
     * Mencetak informasi pembayaran
     * @param jarak jarak yang ditempuh
     */
    @Override
    public void printBiaya(int jarak) {
        int harga = getCost(jarak);
        int promo = getPromo(jarak, harga);
        int protectionCost = getProtectionCost(harga - promo);
        int hargaTotal = harga - promo + protectionCost;
        // Penggunaan locale dari Jerman agar format output desimal
        // menggunakan titik sebagai pemisah
        Locale.setDefault(Locale.GERMANY);
        System.out.println("Terimakasih telah melakukan perjalanan dengan OW-JEK.");
        System.out.printf("[Jarak] %d,%d KM%n", jarak / 10, jarak % 10);
        System.out.println("[TipeO] Sporty");
        System.out.println("[5KMPe] Rp 20.000,00 (+)");
        System.out.printf("[KMSel] " + (jarak < 51 ? "-%n" : "Rp %,d.00 (+)%n"), harga-20000);
        System.out.printf("[Promo] Rp %,d,00 (-)%n", promo);
        System.out.printf("[Prtks] Rp %,d,00 (+)%n", protectionCost);
        System.out.printf("[TOTAL] Rp %,d,00%n", hargaTotal);
    }
}
