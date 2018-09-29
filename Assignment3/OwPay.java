/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

/**
 * Interface yang mengatur biaya ojek
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public interface OwPay {
    int getCost(int jarak);
    int getPromo(int jarak, int harga);
    int getProtectionCost(int totalHarga);
    void printBiaya(int jarak);
    String stringBiaya(int jarak);
}
