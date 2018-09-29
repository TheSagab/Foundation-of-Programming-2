/**
 * Class yang merepresentasikan jenis
 * karakter berupa Ranger.
 */
public class Ranger extends Character{

    public Ranger(String name, int attack) {
        super(name, attack);
    }

    @Override
    public void added() {
        System.out.println("You got Ranger " + name + " in your party! (ATK : " + attack + ")");
    }

    @Override
    public int damage() {
        return attack + 3;
    }

    @Override
    public int magicDamage() {
        return attack - 5;
    }
}
