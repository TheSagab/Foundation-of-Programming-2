public class FitnessCalculator {
    /*
     * Kelas ini tidak perlu diinstansiasi objeknya,
     * cukup panggil langsung dari kelasnya.
     */

    public static double hitungBMI(Manusia manusia) {
        // @TODO hitung BMI (dalam kg/m^2)
        // perhitungan menurut https://en.wikipedia.org/wiki/Body_mass_index#History_and_usage_in_obesity_studies
        return manusia.getBerat() / (manusia.getTinggi()/100 * manusia.getTinggi()/100);
    }
    
    public static double hitungBMR(Manusia manusia) {
        // @TODO kalkulasi BMR*
        // https://en.wikipedia.org/wiki/Harris%E2%80%93Benedict_equation
        // Gunakan rumus original Harris–Benedict yang dipublikasikan pada tahun 1918 dan 1919*.
        double BMR = 0;
        if (manusia.getJenisKelamin().equals("Laki-laki")){
            BMR = 66.5 + (13.75 * manusia.getBerat()) + (5.003 * manusia.getTinggi()) - (6.755 * manusia.getUmur());
        }
        else if (manusia.getJenisKelamin().equals("Wanita")){
            BMR = 655.1 + (9.563 * manusia.getBerat()) + (1.85 * manusia.getTinggi()) - (4.676 * manusia.getUmur());
        }
        return BMR;
    }

    public static double hitungKaloriHarian(Manusia manusia) {
        // @TODO kalkulasi kebutuhan kalori harian
        // (lihat perhitungan Harris-Benedict di atas,
        // asumsikan manusia melakukan light exercise)
        return hitungBMR(manusia) * 1.375;
    }

    public static double hitungKaloriBarbel(Gym gym, int waktu) {
        // @TODO kalkulasi kalori terbakar:
        //      koefisienEfektivitas * 1.25 * waktu
        return gym.getKoefisienEfektivitas() * 1.25 * waktu;
    }

    public static double hitungKaloriPullUpBar(Gym gym, int waktu) {
        // @TODO kalkulasi kalori terbakar:
        //      koefisienEfektivitas * 8.125 * waktu
        return gym.getKoefisienEfektivitas() * 8.125 * waktu;
    }
}
