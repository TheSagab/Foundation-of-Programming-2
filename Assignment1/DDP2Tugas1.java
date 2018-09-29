/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

import java.util.Scanner;

/**
 * Kelas yang berisi main method untuk dijalankan
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class DDP2Tugas1 {
    public static void main(String[] args){
        String masukan;
        String x;
        int angka = 0;
        Liga CSLeague = null;
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME...");
        while (!Game.isFinished()) {
            System.out.print(">>> ");
            masukan = in.next();
            switch (masukan){
                case ("init"):
                    x = in.next();
                    if (Utility.isInteger(x)){
                        angka = Integer.parseInt(x);
                    }
                    else{
                        System.out.println("Init harus berupa bilangan bulat!");
                    }
                    if (CSLeague == null){
                        if (angka < 4 || angka > 10) {
                            System.out.println("Liga harus terdiri dari 4 sampai 10 tim!");
                        }
                        else {
                            CSLeague = new Liga(angka);
                            System.out.println("Init berhasil!");
                            CSLeague.buatJadwal();
                        }
                        in.nextLine();
                    }
                    else{
                        System.out.println("Liga telah dibuat!");
                    }
                    break;
                case ("nextGame"):
                    if (CSLeague == null) System.out.println("Liga belum diinisialisasi!");
                    else {
                        // argumen kosong akan menjalankan nextGame random
                        // argumen -all akan menjalankan seluruh pertandingan
                        String arguments = in.nextLine();
                        Game.nextGame(CSLeague, arguments);
                    }
                    break;
                case("show"):
                    if (CSLeague == null) System.out.println("Liga belum diinisialisasi!");
                    else {
                        String par = in.next();
                        if (par.equals("nextGame"))
                            Game.showNextGame(CSLeague);
                        else if (par.equals("tim")) {
                            String tim = in.next();
                            Game.showTim(CSLeague, tim);
                        } else if (par.equals("pemain")) {
                            String tim = in.next();
                            String pemain = in.next();
                            if (Utility.isInteger(pemain)) {
                                Game.showPemain(CSLeague, tim, Integer.parseInt(pemain));
                            } else {
                                Game.showPemain(CSLeague, tim, pemain);
                            }
                        } else if (par.equals("pencetakGol"))
                            Game.showPencetakGol(CSLeague);
                        else if (par.equals("klasemen"))
                            Game.showKlasemen(CSLeague);
                        else System.out.println("Input tidak valid!");
                    }
                    break;
                default:
                    System.out.println("Input tidak valid!");
                    break;
            }
        }
        Game.endGame(CSLeague);
    }
}
