/**
 * Created by ASUS on 3/14/2017.
 */
public class Penumpang {
    private String nama;
    private int noIdentitas;
    private String jenisKelamin;

    public Penumpang(String nama, int noIdentitas, String jenisKelamin) {
        this.nama = nama;
        this.noIdentitas = noIdentitas;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public int getNoIdentitas() {
        return noIdentitas;
    }

}
