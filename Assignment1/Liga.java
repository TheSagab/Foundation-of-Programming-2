/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Kelas untuk menyimpan informasi liga dan pertandingan
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public class Liga {
    private Tim[] tim;
    private int currentMatch = 0;
    private int numberOfMatch;
    private int teamNum;
    private Tim[][] matches;

    /**
     * Membuat liga dengan jumlah tim tertentu
     * @param teamNum jumlah tim
     */
    public Liga(int teamNum) {
        this.teamNum = teamNum;
        this.numberOfMatch = ((teamNum) * (teamNum - 1) * (teamNum - 2)) / ((teamNum - 2) * 2);

        // Nama tim yang dapat dipilih
        String[] arrayOfTeamName = {"Gajah", "Rusa", "Belalang", "Kodok", "Kucing", "Tupai",
                "Rajawali", "Siput", "Kumbang", "Semut", "Ular", "Harimau", "Kuda",
                "Serigala", "Panda", "Kadal", "Ayam", "Bebek"};

        // Arraylist penyimpan nama tim yang telah dipilih
        ArrayList<String> chosenTeam = new ArrayList<>();
        Random rng = new Random();
        this.tim = new Tim[teamNum];

        for (int i = 0; i < teamNum; i++){
            String timAcak = arrayOfTeamName[rng.nextInt(arrayOfTeamName.length)];
            if (!chosenTeam.contains(timAcak)){
                tim[i] = new Tim(timAcak);
                chosenTeam.add(timAcak);
            }
            else{
                i--; /* tidak jadi memilih */
            }
        }
    }

    /**
     * Menyusun jadwal pertandingan untuk liga
     */
    public void buatJadwal(){
        int match = 0;
        Tim[][] saingan = new Tim[numberOfMatch][2];

        for (int i = 0; i < this.teamNum - 1; i++) {
            for (int j = i + 1; j < this.teamNum; j++) {
                saingan[match][0] = this.tim[i];
                saingan[match][1] = this.tim[j];
                match++;
            }
        }
        Collections.shuffle(Arrays.asList(saingan));
        this.matches = saingan;
    }

    /**
     * Mencari tim dengan nama tertentu
     * @param name nama tim yang diinginkan
     * @return tim dengan nama tersebut, null jika tidak ada
     */
    public Tim findTeamWithName(String name){
        for (int i = 0; i < teamNum; i++) {
            if (this.tim[i].getNamaTim().equals(name)){
                return this.tim[i];
            }
        }
        return null;
    }

    public int getCurrentMatch() {
        return currentMatch;
    }

    public void advanceCurrentMatch(){
        this.currentMatch++;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public Tim[][] getMatches() {
        return matches;
    }

    public Tim[] getTim() {
        return tim;
    }

}