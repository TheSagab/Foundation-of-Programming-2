import java.util.Arrays;

/**
 * Created by ASUS on 3/14/2017.
 */
public class Kereta {
    private Gerbong[] gerbong;
    private int jumlahPenumpang = 0;
    public Kereta(int jumlahGerbong, int jumlahPenumpangTiapGerbong){
        this.gerbong = new Gerbong[jumlahGerbong];
        for (int i = 0; i < jumlahGerbong; i++) {
            gerbong[i] = new Gerbong(jumlahPenumpangTiapGerbong);
        }
        this.gerbong[0].setGerbongWanita(true);
        this.gerbong[this.gerbong.length - 1].setGerbongWanita(true);
    }

    private boolean inspeksiPenumpang(int id, String nama, String kelamin){
        int syarat = 0;
        if (!nama.equals(""))
            syarat++;
        else System.out.println("Nama penumpang tidak boleh kosong!");
        if (id > 9999999 && id < 100000000)
            syarat++;
        else System.out.println("ID penumpang harus 8 digit!");
        if (kelamin.equalsIgnoreCase("Pria") || kelamin.equalsIgnoreCase("Wanita"))
            syarat++;
        else System.out.println("Kamu pria apa wanita?");
        if (!cekIDSama(id))
            syarat++;
        else System.out.println("Terdapat penumpang dengan ID sama!");
        return syarat == 4;
    }
    private boolean cekIDSama(int id){
        for (int i = 0; i < gerbong.length; i++) {
            for (int j = 0; j < gerbong[i].getPenumpang().length; j++) {
                if (!(gerbong[i].getPenumpang()[j] == null)) {
                    if (gerbong[i].getPenumpang()[j].getNoIdentitas() == id) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void tambahPenumpang(int gerbongKe, int kursiKe, String nama, int id, String kelamin){
        if (kelamin.equalsIgnoreCase("Pria") && gerbong[gerbongKe - 1].isGerbongWanita()){
            System.out.println("Pria tidak diperbolehkan di gerbong khusus wanita!");
        }
        else{
            boolean pass = inspeksiPenumpang(id, nama, kelamin);
            if (pass) {
                if (kursiKe > this.gerbong[gerbongKe - 1].getPenumpang().length){
                    System.out.println("Kode kursi tidak ada!");
                }
                else {
                    if (!(gerbong[gerbongKe - 1].getPenumpang()[kursiKe - 1] == null)) {
                        System.out.println("Kursi " + gerbongKe + "-" + kursiKe + " sudah ada yang menempati");
                    } else {
                        gerbong[gerbongKe - 1].getPenumpang()[kursiKe - 1] = new Penumpang(nama, id, kelamin);
                        System.out.printf("Penumpang baru %s diregistrasi di kursi %d-%d%n", nama, gerbongKe, kursiKe);
                        this.jumlahPenumpang++;
                    }
                }
            }
        }
    }

    public void findPenumpangByID(int id){
        for (int i = 0; i < gerbong.length; i++) {
            for (int j = 0; j < gerbong[i].getPenumpang().length; j++) {
                if (!(gerbong[i].getPenumpang()[j] == null)){
                    if (gerbong[i].getPenumpang()[j].getNoIdentitas() == id) {
                        System.out.printf("%s, %d, duduk di kursi ke %d-%d%n", gerbong[i].getPenumpang()[j].getNama(),
                                gerbong[i].getPenumpang()[j].getNoIdentitas(), i + 1, j + 1);
                        return;
                    }
                }
            }
        }
        System.out.println("Tidak ada penumpang dengan no identitas tersebut");
    }

    public void listGerbong(int ke){
        int nomor = 1;
        for (int i = 0; i < gerbong[ke - 1].getPenumpang().length; i++) {
            if (!(gerbong[ke - 1].getPenumpang()[i] == null)){
                System.out.printf("No. %d %s, %d%n", i + 1, gerbong[ke - 1].getPenumpang()[i].getNama(),
                        gerbong[ke - 1].getPenumpang()[i].getNoIdentitas());
                nomor++;
            }
        }
        if (nomor == 1) {
            System.out.println("Tidak ada penumpang di gerbong tersebut");
        }
    }
    public void getInfo(){
        System.out.printf("Kereta terdiri dari %d gerbong dengan jumlah penumpang sebanyak %d penumpang%n",
                this.gerbong.length, this.jumlahPenumpang);
    }

    public void tambahGerbong(){
        this.gerbong = Arrays.copyOf(this.gerbong, this.gerbong.length + 1);
        this.gerbong[this.gerbong.length - 1] = new Gerbong(this.gerbong[0].getPenumpang().length);
        this.gerbong[this.gerbong.length - 1].setGerbongWanita(true);
        this.gerbong[this.gerbong.length - 2].setGerbongWanita(false);
        System.out.println("Gerbong berhasil ditambah");
    }

}
