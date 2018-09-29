/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

/**
 * Kelas untuk menyimpan informasi pemain
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Pemain {
    private String namaPemain;
    private String asalTim;
    private int nomorPemain;
    private int jumlahGolPemain;
    private int jumlahPelanggaran;
    private int jumlahKartuKuning;
    private int jumlahKartuMerah;


    /**
     * Membuat pemain
     * @param namaPemain nama pemain tersebut
     * @param nomorPemain nomor pemain tersebut
     */
    public Pemain(String namaPemain, int nomorPemain) {
        this.namaPemain = namaPemain;
        this.nomorPemain = nomorPemain;
        this.jumlahGolPemain = 0;
        this.jumlahPelanggaran = 0;
        this.jumlahKartuKuning = 0;
        this.jumlahKartuMerah = 0;
    }

    public void dapatKartuKuning(){
        this.jumlahKartuKuning++;
        this.jumlahPelanggaran++;
    }

    public void dapatKartuMerah(){
        this.jumlahKartuMerah++;
        this.jumlahPelanggaran++;
    }

    public void dapatPelanggaran(){
        this.jumlahPelanggaran++;
    }
    public void kurangiPelanggaran(){
        this.jumlahPelanggaran--;
    }
    public void cetakGol(){
        this.jumlahGolPemain++;
    }

    public void setAsalTim(String asalTim){
        this.asalTim = asalTim;
    }

    public String getAsalTim() {
        return asalTim;
    }

    public String getNamaPemain() {
        return namaPemain;
    }

    public int getNomorPemain() {
        return nomorPemain;
    }

    public int getJumlahGolPemain() {
        return jumlahGolPemain;
    }

    public int getJumlahPelanggaran() {
        return jumlahPelanggaran;
    }

    public int getJumlahKartuKuning() {
        return jumlahKartuKuning;
    }

    public int getJumlahKartuMerah() {
        return jumlahKartuMerah;
    }

}
