/**
 * Created by ASUS on 4/21/2017.
 */
public abstract class Elemen {
    private int umur;
    private String nama;
    private String gender;

    public Elemen(int umur, String nama, String gender) {
        this.umur = umur;
        this.nama = nama;
        this.gender = gender;
    }

    public String getNama() {
        return nama;
    }

    public String getGender() {
        return gender;
    }
    public void sapaElemen(Elemen e){
        System.out.println(getNama() + " bukan mahasiswa");
    }

}
