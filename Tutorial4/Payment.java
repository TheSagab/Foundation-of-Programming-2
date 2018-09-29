/**
 * Created by ASUS on 3/7/2017.
 */
public class Payment {
    public static int calculateBerries(Sprite peri) {
        // @TODO
        // hitung bonus sesuai dengan instruksi di soal
        int berry;
        if (peri.getTotalHarga() < 100) berry = 10;
        else berry = peri.getTotalHarga() - 90;
        if (berry < 0) return 0;
        return berry;
    }

    public static int calculateTruffles(Sprite peri) {
        // @TODO
        // hitung bonus sesuai dengan instruksi di soal
        int truffles;
        if (peri.getHeart() < 5) truffles = 5 - peri.getHeart();
        else truffles = (10 - peri.getHeart()) * 2;
        if (truffles < 0) return 0;
        return truffles;
    }

    public static void paySprite(Sprite peri) {
        // @TODO
        // Cetak: "[nama karyawan] telah menerima gaji sebesar [gaji] dengan bonus sebesar [jumlah bonus]".
        if (peri.getTotalHarga() > 0){
            System.out.printf("Atas jasa %s dalam memanen sejumlah %d G, %s telah menerima %d buah berry dan %d buah truffle%n",
                    peri.getNama(), peri.getTotalHarga(), peri.getNama(), calculateBerries(peri), calculateTruffles(peri));
            }
        else{
            System.out.printf("Karena %s tidak memanen satu buah pun, %s tidak diberikan bayaran apapun%n",
                    peri.getNama(), peri.getNama());
        }
    }
}
