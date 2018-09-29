public class Makanan {
    private String nama;
    private String rasa;
    private int kalori;

    public Makanan(String nama){
        this.nama = nama;
        this.rasa = "Tidak enak";
        this.kalori = 0;
    }

    public Makanan(String nama, String rasa, int kalori) {
        this.nama = nama;
        this.rasa = rasa;
        this.kalori = kalori;
    }
    // @TODO setter-getter seperlunya

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }
}