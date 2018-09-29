public class DDP2Tutorial2 {
    public static void main(String[] args) {

        // @TODO instansiasi obyek manusia
        Manusia manusia = new Manusia("John Smith", 25, 60, 180, "Laki-laki", 0);
        manusia.cetakInformasi(); 

        // @TODO instansiasi beberapa makanan:
        // apel: 52 kalori
        // nasi goreng: 163 kalori
        // nasi padang: 306 kalori
        // indomie: 342 kalori
        // soto betawi: 363 kalori
        // pizza: 266 kalori
        Makanan apel = new Makanan("Apel", "Manis", 52);
        Makanan nasiGoreng = new Makanan("Nasi Goreng", "Enak", 163);
        Makanan nasiPadang = new Makanan("Nasi Padang", "Pedas", 306);
        Makanan indomie = new Makanan("Indomie", "Ayam Bawang", 342);
        Makanan sotoBetawi = new Makanan("Soto Betawi", "Ntap", 363);
        Makanan pizza = new Makanan("Pizza", "Enak", 266);
        
        manusia.makan(nasiPadang);
        manusia.makan(apel);
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Jenis Kelamin : Pria
        // Umur          : 25 Tahun
        // Berat         : 60 KG
        // Tinggi        : 180 CM
        // Kalori        : 358
        // BMR           : 1618
        // KKH           : 2207 Kalori/hari

        // @TODO instansiasi gym dengan koefisien 1.25
        Gym gym = new Gym("Gold's Gym", 1.25);
        gym.gunakanBarbel(manusia, 10, 10);
        gym.gunakanBarbel(manusia, 20, 10);
        gym.gunakanBarbel(manusia, 500, 10);
        
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Jenis Kelamin : Pria
        // Umur          : 25 Tahun
        // Berat         : 60 KG
        // Tinggi        : 180 CM
        // Kalori        : 208
        // BMR           : 1618
        // KKH           : 2207 Kalori/hari

        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie);
        manusia.makan(indomie); // kelebihan makan
        
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Jenis Kelamin : Pria
        // Umur          : 25 Tahun
        // Berat         : 60 KG
        // Tinggi        : 180 CM
        // Kalori        : 1928
        // BMR           : 1618
        // KKH           : 2207 Kalori/hari

        gym.gunakanBarbel(manusia, 30, 10);
        gym.gunakanPullUpBar(manusia, 30);
        
        manusia.cetakInformasi();
        // ----------------
        // Contoh keluaran:
        // ----------------
        // John Smith
        // Jenis Kelamin : Pria
        // Umur          : 25 Tahun
        // Berat         : 60 KG
        // Tinggi        : 180 CM
        // Kalori        : 1103
        // BMR           : 1618
        // KKH           : 2207 Kalori/hari
    }
}