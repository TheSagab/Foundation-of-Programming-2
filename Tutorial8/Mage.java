/**
 * Class yang merepresentasikan jenis
 * karakter berupa Mage.
 */
public class Mage extends Character{

    public Mage(String name, int attack) {
        super(name, attack);
    }

    @Override
    public void added() {
        System.out.println(name + " decided to be in your party! (ATK : " + attack + ")");
    }


    @Override
    public int damage() {
        return attack - 10;
    }

    @Override
    public int magicDamage() {
        return attack + 18;
    }
}
