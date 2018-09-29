/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * Kelas untuk menyimpan informasi tim
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Tim {
    private Pemain[] pemain;
    private String namaTim;
    private int jumlahMenang;
    private int jumlahKalah;
    private int jumlahSeri;
    private int jumlahPoin;
    private int jumlahGolTim;
    private int jumlahKebobolan;

    /**
     * Membuat tim baru dengan pemain acak
     * @param namaTim nama tim tersebut
     */
    public Tim(String namaTim) {
        this.namaTim = namaTim;
        this.jumlahKalah = 0;
        this.jumlahMenang = 0;
        this.jumlahSeri = 0;
        this.jumlahKebobolan = 0;
        this.jumlahGolTim = 0;
        this.jumlahPoin = 0;
        this.pemain = new Pemain[5];

        // Nama pemain yang dapat dipilih
        String[] arrayOfPlayerName = {"Arnold", "Kaidou", "Chopper", "Pica", "Enel", "Zoro",
                "Pedro", "Beckman", "Ace", "Shiryu", "Sakazuki", "Marco", "Garp", "Dadan",
                "Sengoku", "Sanji", "Magellan", "Dragon", "Sabo", "Smoker", "Luffy",
                "Franky", "Borsalino", "Buggy", "Crocodile", "Shanks", "Yasopp", "Coby",
                "Burgess", "Usopp", "Law", "Kid", "Bege", "Yonji", "Doffy", "Edward",
                "Mihawk", "Shanks", "Jinbei", "Killer", "Robin", "Roger", "Shiki", "Rayleigh",
                "Robb", "Kuma", "Moriah", "Teach", "Pagaya", "Conis", "Hachi", "Brook",
                "Kinemon", "Vergo", "Caesar", "Momo", "Mohji", "Cabaji", "Jozu", "Vista",
                "Doma", "Augur", "Drake", "Ivankov", "Charlotte", "Bellamy", "Demaro", "Dorry",
                "Brogy", "Kuro", "Zeff", "Gin", "Pearl", "Alvide", "Apoo", "Kuzan", "Nami",
                "Brook", "Hancock", "Koala"};

        // Arraylist penyimpan nama dan nomor pemain yang telah dibuat
        ArrayList<String> chosenPlayer = new ArrayList<>();
        ArrayList<Integer> chosenNumber = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random rng = new Random();
            String pemainAcak = arrayOfPlayerName[rng.nextInt(arrayOfPlayerName.length)];
            int nomorAcak = 1 + rng.nextInt(99);
            if (!chosenPlayer.contains(pemainAcak)){
                if (!chosenNumber.contains(nomorAcak)){
                    pemain[i] = new Pemain(pemainAcak, nomorAcak);
                    chosenPlayer.add(pemainAcak);
                    chosenNumber.add(nomorAcak);
                }
                else{
                    i--; /* tidak jadi memilih */
                }
            }
            else{
                i--; /* tidak jadi memilih */
            }
        }
        Utility.sortNomorPemain(pemain);
        for (int i = 0; i < 5; i++) {
            pemain[i].setAsalTim(this.namaTim);
        }
    }
    /**
     * Memilih pemain acak dalam tim
     * @return pemain acak
     */
    private Pemain getPemainAcak(){
        return this.pemain[new Random().nextInt(5)];
    }

    /**
     * Mencetak gol sebanyak n kali dan pilih pemain acak yang mencetak gol
     * @param gol jumlah gol
     */
    public void cetakGolAcak(int gol){
        this.jumlahGolTim += gol;
        for (int i = 0; i < gol; i++) {
            Pemain acak = this.getPemainAcak();
            acak.cetakGol();
        }
    }

    /**
     * Mencetak gol sebanyak 1 kali
     */
    public void cetakGol(){
        this.jumlahGolTim++;
    }

    /**
     * Memilih n acak pemain yang terkena kartu merah
     * @param km jumlah kartu merah
     */
    public void kenaKM(int km){
        for (int i = 0; i < km; i++) {
            Pemain acak = this.getPemainAcak();
            acak.dapatKartuMerah();
        }
    }

    /**
     *  Memilih n acak pemain yang terkena pelanggaran
     * @param p jumlah pelanggaran
     */
    public void kenaPelanggaran(int p){
        for (int i = 0; i < p; i++) {
            Pemain acak = this.getPemainAcak();
            acak.dapatPelanggaran();
        }
    }

    /**
     * Menambah jumlah kebobolan tim
     * @param gol jumlah gol
     */
    public void kebobolan(int gol){
        this.jumlahKebobolan += gol;
    }

    /**
     * Mencari pemain dalam tim berdasarkan nomor pemain
     * @param nomor nomor pemain
     * @return pemain tersebut, null jika tidak ada
     */
    public Pemain findPemainWithNomor(int nomor){
        for (int i = 0; i < 5; i++) {
            if(this.pemain[i].getNomorPemain() == nomor){
                return this.pemain[i];
            }
        }
        return null;
    }

    /**
     * Mencari pemain dalam tim berdasarkan nama pemain
     * @param nama nama pemain
     * @return pemain tersebut, null jika tidak ada
     */
    public Pemain findPemainWithNama(String nama){
        for (int i = 0; i < 5; i++) {
            if(this.pemain[i].getNamaPemain().equals(nama)){
                return this.pemain[i];
            }
        }
        return null;
    }

    /**
     * Menambah jumlah menang dan jumlah poin
     */
    public void menang(){
        this.jumlahPoin += 3;
        this.jumlahMenang++;
    }

    /**
     * Menambah jumlah seri dan jumlah poin
     */
    public void seri(){
        this.jumlahPoin++;
        this.jumlahSeri++;
    }

    /**
     * Menambah jumlah kalah
     */
    public void kalah(){
        this.jumlahKalah++;
    }
    public Pemain[] getPemain() {
        return pemain;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public int getJumlahPoin() {
        return jumlahPoin;
    }

    public int getJumlahGolTim() {
        return jumlahGolTim;
    }

    public int getJumlahKebobolan() {
        return jumlahKebobolan;
    }

    public int getJumlahMenang() {
        return jumlahMenang;
    }

    public int getJumlahKalah() {
        return jumlahKalah;
    }

    public int getJumlahSeri() {
        return jumlahSeri;
    }
}
