/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

/**
 * Kelas yang berisi method bantuan
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Utility {
    // referensi Selection Sort
    // semua sort dibawah menggunakan Selection Sort
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Mengurutkan array pemain berdasarkan nomor pemain secara ascending
     * @param pemain array pemain
     */
    public static void sortNomorPemain(Pemain[] pemain){
        for (int i = 0; i < pemain.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < pemain.length; j++){
                if (pemain[j].getNomorPemain() < pemain[index].getNomorPemain()){
                    index = j;
                }
            }
            Pemain temp = pemain[index];
            pemain[index] = pemain[i];
            pemain[i] = temp;
        }
    }

    /**
     * Mengurutkan array pemain berdasarkan jumlah gol secara descending
     * @param pemain array pemain
     */
    public static void sortGolPemain(Pemain[] pemain){
        for (int i = 0; i < pemain.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < pemain.length; j++){
                if (pemain[j].getJumlahGolPemain() > pemain[index].getJumlahGolPemain()){
                    index = j;
                }
            }
            Pemain temp = pemain[index];
            pemain[index] = pemain[i];
            pemain[i] = temp;
        }
    }

    /**
     * Mengurutkan klasemen berdasarkan jumlah poin tim secara descending.
     * Jika sama maka urutkan berdasarkan selisih jumlah gol dan kebobolan
     * @param tim array tim
     */
    public static void sortKlasemen(Tim[] tim){
        for (int i = 0; i < tim.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < tim.length; j++){
                if (tim[j].getJumlahPoin() > tim[index].getJumlahPoin()){
                    index = j;
                }
                else if (tim[j].getJumlahPoin() == tim[index].getJumlahPoin()
                        && tim[j].getJumlahGolTim() - tim[j].getJumlahKebobolan() > tim[index].getJumlahGolTim() - tim[index].getJumlahKebobolan()){
                    index = j;
                }
            }
            Tim temp = tim[index];
            tim[index] = tim[i];
            tim[i] = temp;
        }
    }

    /**
     * Mengecek apakah suatu string dapat diparse menjadi integer
     * @param str String yang dicek
     * @return true jika bisa, false jika tidak
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
