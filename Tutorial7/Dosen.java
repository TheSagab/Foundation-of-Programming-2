/**
 * Created by ASUS on 4/21/2017.
 */
public class Dosen extends Staf{
    private String matkul;

    public Dosen(int umur, String nama, String gender, String matkul) {
        super(umur, nama, gender);
        this.matkul = matkul;
        System.out.println(nama + " diterima bekerja sebagai Dosen " + matkul);
    }

    public String getMatkul() {
        return matkul;
    }
}
