/**
 * Created by ASUS on 4/21/2017.
 */
public class Mahasiswa extends Elemen{
    private int angkatan;
    private Integer nilai;
    private boolean nilaiMasuk;

    public Mahasiswa(int umur, String nama, String gender, int angkatan) {
        super(umur, nama, gender);
        this.angkatan = angkatan;
        this.nilai = null;
        this.nilaiMasuk = false;
        System.out.println(nama + " diterima menjadi mahasiswa angkatan " + angkatan);
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }

    public boolean isNilaiMasuk() {
        return nilaiMasuk;
    }

    public void setNilaiMasuk(boolean nilaiMasuk) {
        this.nilaiMasuk = nilaiMasuk;
    }

    @Override
    public void sapaElemen(Elemen e) {
        if(e instanceof Mahasiswa){
            if(e.getGender().equals("Pria"))
                System.out.println(getNama() + " menyapa Bro " + e.getNama() + " dengan penuh kasih sayang");
            else if (e.getGender().equals("Wanita"))
                System.out.println(getNama() + " menyapa Sis " + e.getNama() + " dengan penuh kasih sayang");
        }
        else if (e instanceof Dosen){
            if(e.getGender().equals("Pria"))
                System.out.println(getNama() + " menyapa Pak " + e.getNama() + " dengan penuh kasih sayang");
            else if (e.getGender().equals("Wanita"))
                System.out.println(getNama() + " menyapa Bu " + e.getNama() + " dengan penuh kasih sayang");
        }
        else if (e instanceof Karyawan){
            if(e.getGender().equals("Pria"))
                System.out.println(getNama() + " menyapa Mas " + e.getNama() + " dengan penuh kasih sayang");
            else if (e.getGender().equals("Wanita"))
                System.out.println(getNama() + " menyapa Mbak " + e.getNama() + " dengan penuh kasih sayang");
        }
    }
}
