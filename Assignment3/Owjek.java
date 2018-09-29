/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.Locale;

/**
 * Class abstract untuk merepresentasikan Owjek secara umum
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public abstract class Owjek implements OwPay{
    private int tahunMotor;
    private int topSpeed;
    private int ccMotor;

    public Owjek(int tahunMotor, int topSpeed, int ccMotor) {
        this.tahunMotor = tahunMotor;
        this.topSpeed = topSpeed;
        this.ccMotor = ccMotor;
    }

}

/**
 * Class untuk merepresentasikan Owjek tipe Regular
 * @author Anindito Bhagawanta
 * @version 1.0
 */
class OwjekRegular extends Owjek  {
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

    /**
     * Mencetak informasi pembayaran
     * @param jarak jarak yang ditempuh
     * @return string informasi
     */
    @Override
    public String stringBiaya(int jarak){
        String s = "";
        int harga = getCost(jarak);
        int promo = getPromo(jarak, harga);
        int hargaTotal = harga - promo;
        // Penggunaan locale dari Jerman agar format output desimal
        // menggunakan titik sebagai pemisah
        Locale.setDefault(Locale.GERMANY);

        s += "Terimakasih telah melakukan perjalanan dengan OW-JEK.\n";
        s += String.format("[Jarak] %d,%d KM%n", jarak / 10, jarak % 10);
        s += "[TipeO] Regular\n";
        s += "[2KMPe] Rp 3.000,00 (+)\n";
        s += String.format("[KMSel] Rp " + (jarak < 21 ? "-%n" : "%,d,00 (+)%n"), harga-3000);
        s += String.format("[Promo] Rp %,d,00 (-)%n", promo);
        s += String.format("[TOTAL] Rp %,d,0%n", hargaTotal);
        return s;
    }

}

/**
 * Class untuk merepresentasikan Owjek tipe Sporty
 * @author Anindito Bhagawanta
 * @version 1.0
 */
class OwjekSporty extends Owjek {
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

    /**
     * Mencetak informasi pembayaran
     * @param jarak jarak yang ditempuh
     * @return string informasi
     */
    @Override
    public String stringBiaya(int jarak) {
        String s = "";
        int harga = getCost(jarak);
        int promo = getPromo(jarak, harga);
        int protectionCost = getProtectionCost(harga - promo);
        int hargaTotal = harga - promo + protectionCost;
        // Penggunaan locale dari Jerman agar format output desimal
        // menggunakan titik sebagai pemisah
        Locale.setDefault(Locale.GERMANY);

        s += "Terimakasih telah melakukan perjalanan dengan OW-JEK.\n";
        s += String.format("[Jarak] %d,%d KM%n", jarak / 10, jarak % 10);
        s += "[TipeO] Sporty\n";
        s += "[5KMPe] Rp 20.000,00 (+)\n";
        s += String.format("[KMSel] " + (jarak < 51 ? "-%n" : "Rp %,d.00 (+)%n"), harga-20000);
        s += String.format("[Promo] Rp %,d,00 (-)%n", promo);
        s += String.format("[Prtks] Rp %,d,00 (+)%n", protectionCost);
        s += String.format("[TOTAL] Rp %,d,00", hargaTotal);
        return s;
    }
}

/**
 * Class untuk merepresentasikan Owjek tipe Exclusive
 * @author Anindito Bhagawanta
 * @version 1.0
 */
class OwjekExclusive extends Owjek {
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

    /**
     * Mencetak informasi pembayaran
     * @param jarak jarak yang ditempuh
     * @return string informasi
     */
    @Override
    public String stringBiaya(int jarak) {
        String s = "";
        int harga = getCost(jarak);
        int promo = getPromo(jarak, harga);
        int protectionCost = getProtectionCost(harga - promo);
        int hargaTotal = harga - promo + protectionCost;
        // Penggunaan locale dari Jerman agar format output desimal
        // menggunakan titik sebagai pemisah
        Locale.setDefault(Locale.GERMANY);

        s += "Terimakasih telah melakukan perjalanan dengan OW-JEK.\n";
        s += String.format("[Jarak] %d,%d KM%n", jarak / 10, jarak % 10);
        s += "[TipeO] Exclusive\n";
        s += "[Fixed] Rp 10.000,00 (+)\n";
        s += String.format("[KMSel] Rp %,d.00 (+)%n", harga - 10000);
        s += String.format("[Promo] Rp %,d,00 (-)%n", promo);
        s += String.format("[Prtks] Rp %,d,00 (+)%n", protectionCost);
        s += String.format("[TOTAL] Rp %,d,00", hargaTotal);
        return s;
    }

}

