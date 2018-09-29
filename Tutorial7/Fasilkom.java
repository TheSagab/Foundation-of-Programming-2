import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by ASUS on 4/21/2017.
 */
public class Fasilkom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Elemen> elemenFasilkom = new ArrayList<>();
        while(in.hasNextLine()){
            String[] input = in.nextLine().split(" ");
            switch(input[0]){
                case "TERIMA":
                    if(!(input[3].equals("Pria") || input[3].equals("Wanita"))){
                        System.out.println("Gender harus pria / wanita!");
                    }
                    else {
                        if (Integer.parseInt(input[4]) < 2013 || Integer.parseInt(input[4]) > 2016){
                            System.out.println("Angkatan harus diantara 2013 sd 2016!");
                        }
                        else {
                            if (!isAdded(elemenFasilkom, input[1])) {
                                if (isInteger(input[2])) {
                                    elemenFasilkom.add(new Mahasiswa(Integer.parseInt(input[2]), input[1], input[3], Integer.parseInt(input[4])));
                                } else System.out.println("Nama harus terdiri dari 1 kata!");
                            } else
                                System.out.println("Sudah ada elemen bernama " + input[1] + " yang diterima");
                        }
                    }
                    break;
                case "REKRUT":
                    if(!(input[5].equals("Pria") || input[5].equals("Wanita"))){
                        System.out.println("Gender harus pria / wanita!");
                    }
                    else {
                        if (isInteger(input[4])) {
                            if (!isAdded(elemenFasilkom, input[3])) {
                                if (input[1].equals("Dosen"))
                                    elemenFasilkom.add(new Dosen(Integer.parseInt(input[4]), input[3], input[5], input[2]));
                                else if (input[1].equals("Karyawan"))
                                    elemenFasilkom.add(new Karyawan(Integer.parseInt(input[4]), input[3], input[5], input[2]));
                                else {
                                    System.out.println("Rekrutmen hanya untuk dosen / karyawan!");
                                }
                            } else
                                System.out.println("Sudah ada elemen bernama " + input[3] + " yang diterima");
                        }
                        else{
                            System.out.println("Nama harus terdiri dari 1 kata!");
                        }
                    }
                    break;
                case "SAPA":
                    Elemen e1 = getElemenByName(elemenFasilkom, input[1]);
                    if (e1 == null) {
                        System.out.println("Tidak ada elemen bernama " + input[1]);
                    }
                    Elemen e2 = getElemenByName(elemenFasilkom, input[2]);
                    if (e2 == null) {
                        System.out.println("Tidak ada elemen bernama " + input[2]);
                        break;
                    }
                    e1.sapaElemen(e2);
                    break;
                case "LIHAT":
                    Mahasiswa m = (Mahasiswa) getElemenByName(elemenFasilkom, input[2]);
                    if (m == null)
                        System.out.println("Tidak ada mahasiswa bernama " + input[2]);
                    else{
                        if (m.isNilaiMasuk())
                            System.out.println("Nilai " + m.getNama() + " adalah " + m.getNilai());
                        else
                            System.out.println("Nilai " + m.getNama() + " belum ada");
                   }
                    break;
                case "MEMBERI":
                    m = (Mahasiswa) getElemenByName(elemenFasilkom, input[2]);
                    if (m == null)
                        System.out.println("Tidak ada mahasiswa bernama " + input[2]);
                    else{
                        Dosen d = (Dosen) getElemenByName(elemenFasilkom, input[4]);
                        if (d == null) {
                            System.out.println("Tidak ada dosen bernama " + input[4]);
                        }
                        else{
                            if(Integer.parseInt(input[6]) >= 0 && Integer.parseInt(input[6]) <=100) {
                                System.out.println(d.getNama() + " memberikan nilai " + d.getMatkul() + " kepada "
                                        + m.getNama() + " sebesar " + input[6]);
                                m.setNilai(Integer.valueOf(input[6]));
                            }
                            else
                                System.out.println("Nilai harus berkisar antara 0 sd 100!");
                        }
                    }
                    break;
                case "MASUKKAN":
                    m = (Mahasiswa) getElemenByName(elemenFasilkom, input[2]);
                    if (m == null)
                        System.out.println("Tidak ada mahasiswa bernama " + input[2]);
                    else {
                        Karyawan k = (Karyawan) getElemenByName(elemenFasilkom, input[4]);
                        if (k == null) {
                            System.out.println("Tidak ada karyawan bernama " + input[4]);
                        } else {
                            if (m.getNilai() == null)
                                System.out.println("Nilai untuk mahasiswa bernama " + m.getNilai() + " belum ada");
                            else {
                                System.out.println(k.getNama() + " memasukkan nilai untuk mahasiswa bernama " +
                                        m.getNama());
                                m.setNilaiMasuk(true);
                            }
                        }
                    }
            }
        }
    }

    public static boolean isAdded(ArrayList<Elemen> a, String nama){
        for (Elemen e: a) {
            if (e.getNama().equals(nama)) return true;
        }
        return false;
    }

    public static Elemen getElemenByName(ArrayList<Elemen> a, String nama){
        for (Elemen e: a) {
            if (e.getNama().equals(nama)) return e;
        }
        return null;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
