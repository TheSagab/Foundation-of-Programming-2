public class Manusia {
    private String nama;
    private int umur;
    private int berat;
    private int tinggi;
    private String jenisKelamin;
    private double totalKalori;

    public Manusia(String nama, int umur, int berat, int tinggi, String jenisKelamin, double totalKalori) {
        this.nama = nama;
        this.umur = umur;
        this.berat = berat;
        this.tinggi = tinggi;
        this.jenisKelamin = jenisKelamin;
        this.totalKalori = totalKalori;
    }

    public void makan(Makanan makanan) {
        // @TODO
        // tambah totalKalori sebanyak kalori dari makanan
        // Cetak "[nama manusia] memakan [nama makanan] yang rasanya [rasa]"
        // tolak jika kalori tambahan akan melebihi kebutuhan kalori harian
        // (didapat dari method hitungKaloriHarian di kelas
        // FitnessCalculator)
        // Kemudian cetak "[nama manusia] tidak bisa memakan [nama makanan] karena akan melebihi batas kebutuhan kalori hariannya."
        if (this.totalKalori + makanan.getKalori() <= FitnessCalculator.hitungKaloriHarian(this)){
            this.totalKalori += makanan.getKalori();
            System.out.format("%s memakan %s yang rasanya %s.%n", this.nama, makanan.getNama(), makanan.getRasa());
        }
        else{
            System.out.format("%s tidak bisa memakan %s karena akan melebihi batas kebutuhan kalori hariannya.%n",
                    this.nama, makanan.getNama());
        }

    }

    public void cetakInformasi() {
        // @TODO
        // keluarkan nama, umur, berat, tinggi, totalKalori, BMR, dan kebutuhan kalori harian
        // -------
        // Contoh:
        // -------
        // John Smith
        // Jenis Kelamin : Pria
        // Umur          : 25 Tahun
        // Berat         : 60 KG
        // Tinggi        : 180 CM
        // Kalori        : 0
        // BMR           : 1618
        // KKH           : 2207 Kalori/hari
        System.out.println(this.nama);
        System.out.println("Jenis Kelamin : " + this.jenisKelamin);
        System.out.println("Umur          : " + this.umur + " Tahun");
        System.out.println("Berat         : " + this.berat + " KG");
        System.out.println("Tinggi        : " + this.tinggi + " CM");
        System.out.println("Kalori        : " + this.totalKalori);
        System.out.println("BMR           : " + FitnessCalculator.hitungBMR(this));
        System.out.println("KKH           : " + FitnessCalculator.hitungKaloriHarian(this) + " Kalori/hari");
    }

    // @TODO setter-getter seperlunya

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public double getTotalKalori() {
        return totalKalori;
    }

    public void setTotalKalori(double totalKalori) {
        this.totalKalori = totalKalori;
    }
}