import java.util.Scanner;

/**
 * Created by ASUS on 3/14/2017.
 */
public class DDP2Tutorial5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input;
        int m, n;
        do {
            m = sc.nextInt();
            n = sc.nextInt();
            if (m < 1 || m > 10){
                System.out.println("Gerbong harus berjumlah antara 1 sampai dengan 10!");
            }
            if (n < 1 || n > 30){
                System.out.println("Kapasitas gerbong harus berjumlah antara 1 sampai dengan 30!");
            }
        } while(m < 1 || m > 30 || n < 1 || n > 10);
        Kereta commuterLine = new Kereta(m, n);
        sc.nextLine();
        while (sc.hasNextLine()){
            input = sc.nextLine().split(" ");
            if (input[0].equals("")) break;
            switch (input[0]){
                case ("TAMBAH"):
                    // index 1 nama, index 2 id, index 3 jenis kelamin, index 4 kode kursi
                    String[] kodeKursiStr = input[4].split("-");
                    // index 0 gerbong, index 1 kursi
                    int[] kodeKursi = {Integer.parseInt(kodeKursiStr[0]), Integer.parseInt(kodeKursiStr[1])};
                    commuterLine.tambahPenumpang(kodeKursi[0], kodeKursi[1], input[1],
                            Integer.parseInt(input[2]), input[3]);
                    break;
                case ("CARI"):
                    commuterLine.findPenumpangByID(Integer.parseInt(input[1]));
                    break;
                case ("LIST"):
                    commuterLine.listGerbong(Integer.parseInt(input[1]));
                    break;
                case ("INFO"):
                    commuterLine.getInfo();
                    break;
                case ("+GERBONG"):
                    commuterLine.tambahGerbong();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }
}
