/**
 * Created by ASUS on 3/14/2017.
 */
public class Gerbong {
    private Penumpang[] penumpang;
    private boolean gerbongWanita = false;
    public Gerbong(int jumlahKursi){
        this.penumpang = new Penumpang[jumlahKursi];
    }

    public Penumpang[] getPenumpang() {
        return penumpang;
    }

    public boolean isGerbongWanita() {
        return gerbongWanita;
    }

    public void setGerbongWanita(boolean gerbongWanita) {
        this.gerbongWanita = gerbongWanita;
    }
}
