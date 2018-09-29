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
public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Scanner in = new Scanner(System.in);
        String[] input;
        System.out.println("Welcome to OwJek");
        while(in.hasNextLine()){
            input = in.nextLine().split(" ");
            if(input[0].equals("show") && input[1].equals("map")) map.print();
            else if (input[0].equals("go") && input[1].equals("from")
                    && input[3].equals("to") && input[5].equals("with")
                    && input[6].equals("OW-JEK")){
                Owjek o;
                String from = input[2];
                String to = input[4];
                String type = input[7];

                if (type.equals("Regular"))
                    o = new OwjekRegular(2014, 100, 250);
                else if (type.equals("Sporty"))
                    o = new OwjekSporty(2016, 140, 300);
                else if (type.equals("Exclusive"))
                    o = new OwjekExclusive(2016, 180, 500);
                else{
                    System.out.println("Tipe tidak ada!");
                    continue;
                }
                int dist = Pathfinding.calculateDistance(from, to);
                //jika tidak valid
                if (dist == -1) continue;
                o.printBiaya(dist);
            }
            else if(input[0].equals("exit")) break;
            else System.out.println("Invalid input!");
        }
        System.out.println("Goodbye!");
    }
}
