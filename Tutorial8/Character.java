/**
 * Class yang merepresentasikan karakter
 * yang dapat dimainkan di game Last Fantasy.
 *
 * Anda diperbolehkan mengubah isi class ini.
 */
public class Character implements Comparable<Character>{
    protected String name;
    protected int attack;

    public Character(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public void added() {
        System.out.println("Added a character.");
    }

    public int damage() {
        return attack;
    }

    public int damage(int itemDamage) {
        return attack + itemDamage;
    }

    public void attack() {
        System.out.println(name + " attacked! Damage: " + this.damage() + ".");
    }

    public void attack(int itemDamage){
        System.out.printf("%s attacked! Damage: %d.%n", name, attack + itemDamage);
    }

    public int magicDamage() {
        return attack;
    }

    public void magic() {
        System.out.println(name + " casted a magic! Damage: " + this.magicDamage() + ".");
    }

    public int compareTo(Character c){
        return this.name.compareTo(c.name);
    }

}
