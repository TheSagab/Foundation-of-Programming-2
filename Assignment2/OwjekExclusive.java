/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.Locale;

/**
 * Class untuk merepresentasikan Owjek tipe Exclusive
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class OwjekExclusive extends Owjek {
    public OwjekExclusive(int tahunMotor, int topSpeed, int ccMotor) {
        super(tahunMotor, topSpeed, ccMotor);
    }

    /**
     * Menghitung biaya dengan ketentuan fixed cost 10000 ditambah
     * 5000 per km
     * @param jarak jarak yang ditempuh per 100m
     * @return biaya
     */
    @Override
    public int getCost(int jarak){
        return 10000 + jarak * 500;
    }

    /**
     * Menghitung promo dengan ketentuan 50% biaya
     * @param jarak jarak yang ditempuh per 100m
     * @param harga harga awal
     * @return biaya promo
     */
    @Override
    public int getPromo(int jarak, int harga){
        return harga / 2;
    }

    /**
     * Menghitung biaya proteksi dengan ketentuan 5% harga
     * setelah dikurangi promo
     * @param totalHarga harga setelah dikurangi promo
     * @return biaya proteksi
     */
    @Override
    public int getProtectionCost(int totalHarga) {
        return totalHarga / 20;
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
        System.out.println("[TipeO] Exclusive");
        System.out.println("[Fixed] Rp 10.000,00 (+)");
        System.out.printf("[KMSel] Rp %,d.00 (+)%n", harga - 10000);
        System.out.printf("[Promo] Rp %,d,00 (-)%n", promo);
        System.out.printf("[Prtks] Rp %,d,00 (+)%n", protectionCost);
        System.out.printf("[TOTAL] Rp %,d,00%n", hargaTotal);
    }

}
