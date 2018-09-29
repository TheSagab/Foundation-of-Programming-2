/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Kelas untuk mengatur segala hal tentang permainan dan informasi klasemen,
 * tim dan pemain
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Game {
    private static boolean finished = false;

    /**
     * Memainkan game berikutnya dari liga tersebut
     * @param liga liga yang diinginkan
     */
    public static void nextGame(Liga liga){
        Random rng = new Random();
        Tim[][] match = liga.getMatches();
        int currentMatch = liga.getCurrentMatch();
        Tim home = match[currentMatch][0];
        Tim away = match[currentMatch][1];

        // Arraylist penyimpan pemain yang mendapat kartu kuning sebelumnya
        ArrayList<Pemain> homeTadiKK = new ArrayList<>();
        ArrayList<Pemain> awayTadiKK = new ArrayList<>();

        // Acak outcome dari game tersebut
        int golHome = rng.nextInt(6);
        int golAway = rng.nextInt(6);
        int kkHome = rng.nextInt(4);
        int kkAway = rng.nextInt(4);
        int kmHome = rng.nextInt(3);
        int kmAway = rng.nextInt(3);
        int pelanggaranHome = rng.nextInt(6);
        int pelanggaranAway = rng.nextInt(6);
        home.cetakGolAcak(golHome);
        away.cetakGolAcak(golAway);
        home.kebobolan(golAway);
        away.kebobolan(golHome);
        home.kenaKM(kmHome);
        away.kenaKM(kmAway);
        home.kenaPelanggaran(pelanggaranHome);
        away.kenaPelanggaran(pelanggaranAway);

        // Special case kartu kuning
        // Jika 1 pemain terkena 3 kartu kuning maka mendapat 2 kartu merah
        for (int i = 0; i < kkHome; i++) {
            Pemain homeKenaKK = home.getPemain()[rng.nextInt(5)];
            homeKenaKK.dapatKartuKuning();

            // Tambahkan kartu merah jika terkena 2 kartu kuning
            if(homeTadiKK.contains(homeKenaKK)){
                homeKenaKK.dapatKartuMerah();
                homeKenaKK.kurangiPelanggaran();
                kmHome++;
            }
            homeTadiKK.add(homeKenaKK);
        }
        for (int i = 0; i < kkAway; i++) {
            Pemain awayKenaKK = away.getPemain()[rng.nextInt(5)];
            awayKenaKK.dapatKartuKuning();
            if (awayTadiKK.contains(awayKenaKK)){
                awayKenaKK.dapatKartuMerah();
                awayKenaKK.kurangiPelanggaran();
                kmAway++;
            }
            awayTadiKK.add(awayKenaKK);
        }
        System.out.printf("Statistika Pertandingan Tim %s VS Tim %s%n%n",
                home.getNamaTim(), away.getNamaTim());
        System.out.printf("Tim : %s%n", home.getNamaTim());
        System.out.printf("Gol : %d%n", golHome);
        System.out.printf("Pelanggaran : %d%n", pelanggaranHome);
        System.out.printf("Kartu Kuning : %d%n", kkHome);
        System.out.printf("Kartu Merah : %d%n%n", kmHome);
        System.out.printf("Tim : %s%n", away.getNamaTim());
        System.out.printf("Gol : %d%n", golAway);
        System.out.printf("Pelanggaran : %d%n", pelanggaranAway);
        System.out.printf("Kartu Kuning : %d%n", kkAway);
        System.out.printf("Kartu Merah : %d%n", kmAway);
        if (golHome > golAway) {
            home.menang();
            away.kalah();
        }
        if (golAway > golHome) {
            away.menang();
            home.kalah();
        }
        if (golHome == golAway){
            home.seri();
            away.seri();
        }
        liga.advanceCurrentMatch();
        Utility.sortKlasemen(liga.getTim());
        if(liga.getCurrentMatch() == liga.getNumberOfMatch()){
            finished = true;
        }
    }

    /**
     * Memainkan game berikutnya dari liga tersebut (mode manual)
     * @param liga liga yang diinginkan
     * @param arguments argumen untuk mode manual
     */
    public static void nextGame(Liga liga, String arguments){
        if (arguments.equals("")) nextGame(liga);
        else if (arguments.equals(" -all")) nextGameAll(liga);
        else {
            String[] args = arguments.split(" ");
            if (!Arrays.asList(args).contains("-g")){
                System.out.println("Mode manual harus memiliki argumen -g!");
            }
            else {
                boolean pass = true;
                int currentMatch = liga.getCurrentMatch();
                Tim home = liga.getMatches()[currentMatch][0];
                Tim away = liga.getMatches()[currentMatch][1];

                // Cek argumen tim
                if (!(Arrays.asList(args).contains(home.getNamaTim())
                        || Arrays.asList(args).contains(away.getNamaTim()))){
                    pass = false;
                }
                if (!pass){
                    System.out.println("Input tim salah!");
                }
                else {
                    // Arraylist penyimpan pemain yang mendapat kartu kuning sebelumnya
                    ArrayList<Pemain> ygTadiKartuKuning = new ArrayList<>();
                    int golHome = 0;
                    int golAway = 0;
                    int kkHome = 0;
                    int kkAway = 0;
                    int kmHome = 0;
                    int kmAway = 0;
                    int pelanggaranHome = 0;
                    int pelanggaranAway = 0;

                    // gatau kenapa harus dari 1
                    for (int i = 1; i < args.length; i += 3) {
                        // command1 seperti -g, -kk
                        // command2 nama tim, command3 nomor pemain
                        String command1 = args[i];
                        String command2 = args[i + 1];
                        int command3 = Integer.parseInt(args[i + 2]);
                        Tim tim = liga.findTeamWithName(command2);
                        Pemain pemain = tim.findPemainWithNomor(command3);
                        boolean pass2 = true;
                        // Cek pemain
                        if (pemain == null) {
                            System.out.println("Pemain tidak terdaftar pada tim " + tim.getNamaTim());
                            pass2 = false;
                        }
                        if (pass2) {
                            switch (command1) {
                                case ("-g"):
                                    pemain.cetakGol();
                                    if (tim == home) {
                                        golHome++;
                                        home.cetakGol();
                                        away.kebobolan(1);
                                    } else {
                                        golAway++;
                                        away.cetakGol();
                                        home.kebobolan(1);
                                    }
                                    break;
                                case ("-kk"):
                                    // Special case kartu kuning
                                    // Jika 1 pemain terkena 3 kartu kuning maka mendapat 2 kartu merah
                                    pemain.dapatKartuKuning();
                                    if (tim == home) {
                                        kkHome++;
                                        pelanggaranHome++;
                                    } else {
                                        kkAway++;
                                        pelanggaranAway++;
                                    }

                                    // Tambahkan kartu merah jika terkena 2 kartu kuning
                                    if (ygTadiKartuKuning.contains(pemain)) {
                                        if (tim == home) {
                                            kmHome++;
                                        } else {
                                            kmAway++;
                                        }
                                        pemain.dapatKartuMerah();
                                        pemain.kurangiPelanggaran();
                                    }
                                    ygTadiKartuKuning.add(pemain);
                                    break;
                                case ("-km"):
                                    if (tim == home) {
                                        kmHome++;
                                        pelanggaranHome++;
                                    } else {
                                        kmAway++;
                                        pelanggaranAway++;
                                    }
                                    pemain.dapatKartuMerah();
                                    break;
                                case ("-p"):
                                    if (tim == home) pelanggaranHome++;
                                    else pelanggaranAway++;
                                    pemain.dapatPelanggaran();
                                    break;
                                default:
                                    System.out.println("Error, input argumen salah!");
                                    break;
                            }
                            if (golHome > golAway) {
                                home.menang();
                                away.kalah();
                            }
                            if (golAway > golHome) {
                                away.menang();
                                home.kalah();
                            }
                            if (golHome == golAway) {
                                home.seri();
                                away.seri();
                            }
                            }
                        }
                    System.out.printf("Statistika Pertandingan Tim %s VS Tim %s%n%n",
                            home.getNamaTim(), away.getNamaTim());
                    System.out.printf("Tim : %s%n", home.getNamaTim());
                    System.out.printf("Gol : %d%n", golHome);
                    System.out.printf("Pelanggaran : %d%n", pelanggaranHome);
                    System.out.printf("Kartu Kuning : %d%n", kkHome);
                    System.out.printf("Kartu Merah : %d%n%n", kmHome);
                    System.out.printf("Tim : %s%n", away.getNamaTim());
                    System.out.printf("Gol : %d%n", golAway);
                    System.out.printf("Pelanggaran : %d%n", pelanggaranAway);
                    System.out.printf("Kartu Kuning : %d%n", kkAway);
                    System.out.printf("Kartu Merah : %d%n", kmAway);
                    liga.advanceCurrentMatch();
                    Utility.sortKlasemen(liga.getTim());
                    if (liga.getCurrentMatch() == liga.getNumberOfMatch()) {
                        finished = true;
                    }
                }
            }
        }
    }

    /**
     * Memainkan seluruh game di liga tersebut sampai selesai
     * @param liga liga yang diinginkan
     */
    public static void nextGameAll(Liga liga){
        while(!finished){
            nextGame(liga);
        }
    }

    /**
     * Melihat pertandingan selanjutnya dari liga tertentu
     * @param liga liga yang diinginkan
     */
    public static void showNextGame(Liga liga){
        int currentMatch = liga.getCurrentMatch();
        Tim[][] matches = liga.getMatches();
        System.out.println(matches[currentMatch][0].getNamaTim() + " VS " + matches[currentMatch][1].getNamaTim());
    }

    /**
     * Melihat statistik dari suatu pemain
     * @param liga liga yang diinginkan
     * @param tim tim dari pemain tersebut
     * @param nomorPemain nomor pemain tersebut
     */
    public static void showPemain(Liga liga, String tim, int nomorPemain) {
        Tim timnya = liga.findTeamWithName(tim);
        Pemain pemainnya = null;
        if (timnya != null) pemainnya = timnya.findPemainWithNomor(nomorPemain);
        else System.out.println("Tidak ada nama tim tersebut");
        if (pemainnya == null) System.out.println("Pemain tidak ditemukan!");
        else {
            System.out.println("Nomor        : " + pemainnya.getNomorPemain());
            System.out.println("Nama         : " + pemainnya.getNamaPemain());
            System.out.println("Gol          : " + pemainnya.getJumlahGolPemain());
            System.out.println("Pelanggaran  : " + pemainnya.getJumlahPelanggaran());
            System.out.println("Kartu Kuning : " + pemainnya.getJumlahKartuKuning());
            System.out.println("Kartu Merah  : " + pemainnya.getJumlahKartuMerah());
        }
    }

    /**
     * Melihat statistik dari suatu pemain
     * @param liga liga yang diinginkan
     * @param tim tim dari pemain tersebut
     * @param namaPemain nama dari pemain tersebut
     */
    public static void showPemain(Liga liga, String tim, String namaPemain) {
        Tim timnya = liga.findTeamWithName(tim);
        Pemain pemainnya = timnya.findPemainWithNama(namaPemain);
        if (timnya == null || pemainnya == null)
            System.out.println("Pemain tidak ditemukan!");
        else {
            System.out.println("Nomor        : " + pemainnya.getNomorPemain());
            System.out.println("Nama         : " + pemainnya.getNamaPemain());
            System.out.println("Gol          : " + pemainnya.getJumlahGolPemain());
            System.out.println("Pelanggaran  : " + pemainnya.getJumlahPelanggaran());
            System.out.println("Kartu Kuning : " + pemainnya.getJumlahKartuKuning());
            System.out.println("Kartu Merah  : " + pemainnya.getJumlahKartuMerah());
        }
    }

    /**
     * Melihat statistik dari suatu tim
     * @param liga liga yang diinginkan
     * @param tim tim yang diinginkan
     */
    public static void showTim(Liga liga, String tim) {
        Tim timnya = liga.findTeamWithName(tim);
        if (timnya == null)
            System.out.println("Tim tidak ditemukan dalam liga!");
        else {
            Pemain[] pemainnya = timnya.getPemain();
            System.out.println("Nomor |   Nama    | Gol | Pelanggaran | Kartu Kuning | Kartu Merah |");
            System.out.println("--------------------------------------------------------------------");
            for (int i = 0; i < 5; i++) {
                System.out.printf(" %-4d | %-9s |  %-1d  |      %-4d   |       %-6d |      %-6d |%n",
                        pemainnya[i].getNomorPemain(), pemainnya[i].getNamaPemain(), pemainnya[i].getJumlahGolPemain(),
                        pemainnya[i].getJumlahPelanggaran(), pemainnya[i].getJumlahKartuKuning(), pemainnya[i].getJumlahKartuMerah());
            }
        }
    }

    /**
     * Melihat statistik pencetak gol 10 besar
     * @param liga liga yang diinginkan
     */
    public static void showPencetakGol(Liga liga){
        // Arraylist sementara, setelah itu dipindahkan ke array pemain agar dapat diurutkan
        ArrayList<Pemain> tempScorer = new ArrayList<>();
        Tim[] timnya = liga.getTim();

        for (int i = 0; i < timnya.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (timnya[i].getPemain()[j].getJumlahGolPemain() > 0){
                    tempScorer.add(timnya[i].getPemain()[j]);
                }
            }
        }
        Pemain[] scorer = new Pemain[tempScorer.size()];

        for (int i = 0; i < scorer.length; i++) {
            scorer[i] = tempScorer.get(i);
        }
        Utility.sortGolPemain(scorer);
        System.out.println("Peringkat | Nama Pemain  | Nama Tim  | Jumlah Gol");
        System.out.println("------------------------------------------------");
        if(scorer.length>10){
            for (int i = 0; i < 10; i++) {
                System.out.printf("    %-4d  | %-12s | %-9s |     %d %n",
                        i + 1, scorer[i].getNamaPemain(), scorer[i].getAsalTim(), scorer[i].getJumlahGolPemain());
            }
        }
        else{
            for (int i = 0; i < scorer.length; i++) {
                System.out.printf("   %-5d  | %-12s | %-9s | %-5d %n",
                        i + 1, scorer[i].getNamaPemain(), scorer[i].getAsalTim(), scorer[i].getJumlahGolPemain());
            }
        }
    }

    /**
     * Melihat klasemen dari liga tertentu
     * @param liga liga yang diinginkan
     */
    public static void showKlasemen(Liga liga){
        System.out.println("Peringkat | Nama Tim | Jumlah Gol | Jumlah Kebobolan | Menang | Kalah | Seri | Poin");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int i = 0; i < liga.getTim().length; i++) {
            System.out.printf("    %-4d  | %-8s |     %-5d  |        %-8d  |   %-3d  |   %-3d |  %-3d |  %-3d%n",
                    i + 1, liga.getTim()[i].getNamaTim(), liga.getTim()[i].getJumlahGolTim(), liga.getTim()[i].getJumlahKebobolan(),
                    liga.getTim()[i].getJumlahMenang(), liga.getTim()[i].getJumlahKalah(), liga.getTim()[i].getJumlahSeri(),
                    liga.getTim()[i].getJumlahPoin());
        }
    }

    /**
     * Menampilkan pesan usainya liga dan menampilkan klasemen dan top scorer
     * @param liga liga yang diinginkan
     */
    public static void endGame(Liga liga){
        System.out.println("\nLIGA FASILKOM MUSIM INI TELAH USAI");
        System.out.println("CHAMPION: " + liga.getTim()[0].getNamaTim() + "\n");
        System.out.println("KLASEMEN");
        showKlasemen(liga);
        System.out.println("\nTOP SCORER");
        showPencetakGol(liga);
        System.out.println("\nGOOD GAME, WELL PLAYED!");
    }

    public static boolean isFinished() {
        return finished;
    }

}
