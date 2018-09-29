/**
 * Created by ASUS on 4/21/2017.
 */
public class Karyawan extends Staf{
    private String bidang;

    public Karyawan(int umur, String nama, String gender, String bidang) {
        super(umur, nama, gender);
        this.bidang = bidang;
        System.out.println(nama + " diterima bekerja sebagai Karyawan " + bidang);
    }
}
