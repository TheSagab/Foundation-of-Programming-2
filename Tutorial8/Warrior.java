/**
 * Class yang merepresentasikan jenis
 * karakter berupa Warrior.
 */
public class Warrior extends Character{

    public Warrior(String name, int attack) {
        super(name, attack);
    }

    @Override
    public void added() {
        System.out.println("Warrior " + name + " joined your party! (ATK : " + attack + ")");
    }


    @Override
    public int damage() {
        return attack + 15;
    }

    @Override
    public int magicDamage() {
        return attack - 10;
    }
}
