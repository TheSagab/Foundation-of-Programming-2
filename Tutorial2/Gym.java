public class Gym {
    private String nama;
    private double koefisienEfektivitas;

    public Gym(String nama, double koefisienEfektivitas) {
        this.nama = nama;
        this.koefisienEfektivitas = koefisienEfektivitas;
    }

    public void gunakanBarbel(Manusia manusia, int waktu, int kecepatan) {
        // @TODO 
        // kurangi totalKalori manusia sebanyak kalkulasi kalori dengan
        // method hitungKaloriBarbel di kelas FitnessCalculator
        // tolak jika totalKalori yang ada kurang dari kalori yang akan dibakar dan cetak "[nama manusia] tidak dapat menggunakan barbel karena kekurangan energi."
        // apabila berhasil cetak "[nama manusia] menggunakan barbel selama [waktu] dengan kecepatan [kecepatan]"
        if (manusia.getTotalKalori() > FitnessCalculator.hitungKaloriBarbel(this, waktu)){
            manusia.setTotalKalori(manusia.getTotalKalori() - FitnessCalculator.hitungKaloriBarbel(this, waktu));
            System.out.printf("%s menggunakan barbel selama %d dengan kecepatan %d.%n", manusia.getNama(), waktu, kecepatan);
        }
        else{
            System.out.printf("%s tidak dapat menggunakan barbel karena kekurangan energi.%n", manusia.getNama());
        }
    }

    public void gunakanPullUpBar(Manusia manusia, int waktu) {
        // @TODO
        // kurangi totalKalori manusia sebanyak kalkulasi kalori dengan
        // method hitungKaloriPullUpBar di kelas FitnessCalculator
        // tolak jika totalKalori yang ada kurang dari kalori yang akan dibakar dan cetak "[nama manusia] tidak dapat menggunakan pull up bar karena kekurangan energi."
        // apabila berhasil cetak "[nama manusia] menggunakan pull up bar selama [waktu]"
        if (manusia.getTotalKalori() > FitnessCalculator.hitungKaloriPullUpBar(this, waktu)) {
            manusia.setTotalKalori(manusia.getTotalKalori() - FitnessCalculator.hitungKaloriPullUpBar(this, waktu));
            System.out.printf("%s menggunakan pull up selama %d.%n", manusia.getNama(), waktu);
        } else {
            System.out.printf("%s tidak dapat menggunakan pull up karena kekurangan energi.%n", manusia.getNama());
        }
    }
    public String getNama() {
         return nama;
    }
    public void setNama(String nama) {
         this.nama = nama;
        }
    public double getKoefisienEfektivitas() {
         return koefisienEfektivitas;
        }
    public void setKoefisienEfektivitas(double koefisienEfektivitas) {
         this.koefisienEfektivitas = koefisienEfektivitas;
        }
    }