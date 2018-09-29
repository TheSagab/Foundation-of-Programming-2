import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Class utama Lab 8. Diusahakan agar
 * Anda tidak mengubah isi dari class ini.
 */
public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Character> party = new ArrayList<Character>();

        String[] input;

        // Menerima masukan hingga EOF
        while (scan.hasNextLine()) {
            input = scan.nextLine().split(" ");

            // Ketika user memasukkan perintah ADD
            if (input[0].equalsIgnoreCase("ADD")) {
                Character character;

                if (input.length != 4) {
                    continue;
                }

                // Menginstansiasi karater sesuai dengan jenisnya
                switch(input[1]) {
                    case "Warrior":
                        character = new Warrior(input[2], Integer.parseInt(input[3]));
                        break;
                    case "Mage":
                        character = new Mage(input[2], Integer.parseInt(input[3]));
                        break;
                    case "Ranger":
                        character = new Ranger(input[2], Integer.parseInt(input[3]));
                        break;
                    default:
                        System.out.println("That job class doesn't exist. Please try again.");
                        continue;
                }

                // Menampilkan info karakter yang ditambahkan
                character.added();

                // Mengosongkan party
                party.add(character);

            // Ketika user memasukkan perintah MAGIC
            } else if (input[0].equalsIgnoreCase("MAGIC")) {
                int total = 0;

                // Melakukan serangan menggunakan magic damage
                for (Character character : party) {
                    character.magic();

                    // Menambahkan hasil perhitungan damage ke damage total
                    total += character.magicDamage();
                }

                // Mencetak total damage seluruh magic yang telah dilakukan
                System.out.println("--- Damage Total: " + total);

                // Mengosongkan party
                party = new ArrayList<Character>();

            // Ketika user memasukkan perintah ATTACK
            } else if (input.length == 1 && input[0].equalsIgnoreCase("ATTACK")) {
                int total = 0;

                // Melakukan serangan menggunakan physical damage
                for (Character character : party) {
                    character.attack();

                    // Menambahkan hasil perhitungan damage ke damage total
                    total += character.damage();
                }

                // Mencetak total damage seluruh serangan yang telah dilakukan
                System.out.println("--- Damage Total: " + total);

                // Mengosongkan party
                party = new ArrayList<Character>();

            // Ketika user memasukkan perintah ATTACK SORTED
            } else if (input.length == 2 && input[0].equalsIgnoreCase("ATTACK") && input[1].equalsIgnoreCase("SORTED")) {
                // Mensorting karakter pada party
                Collections.sort(party);

                int total = 0;

                // Melakukan serangan menggunakan physical damage
                for (Character character : party) {
                    character.attack();

                    // Menambahkan hasil perhitungan damage ke damage total
                    total += character.damage();
                }

                // Mencetak total damage seluruh serangan yang telah dilakukan
                System.out.println("--- Damage Total: " + total);

                // Mengosongkan party
                party = new ArrayList<Character>();

            // Ketika user memasukkan perintah ATTACK <jumlah efek item>
            } else if (input.length == 2 && input[0].equalsIgnoreCase("ATTACK")) {
                int total = 0;
                int itemModifier = Integer.parseInt(input[1]);

                // Melakukan serangan menggunakan physical damage
                for (Character character : party) {
                    // Melakukan serangan dengan efek item tertentu
                    character.attack(itemModifier);

                    // Menambahkan perhitungan damage dengan efek item tertentu ke damage total
                    total += character.damage(itemModifier);
                }

                // Mencetak total damage seluruh serangan yang telah dilakukan
                System.out.println("--- Damage Total: " + total);

                // Mengosongkan party
                party = new ArrayList<Character>();
            }
        }
    }
}
