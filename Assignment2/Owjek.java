/* Nama     : Anindito Bhagawanta
 * NPM      : 1606879230
 * Kelas    : DDP 2 - B
 * Asisten  : B-4
 */

/**
 * Class abstract untuk merepresentasikan Owjek secara umum
 * @author Anindito Bhagawanta
 * @version 1.0
 */
public abstract class Owjek implements OwPay{
    private int tahunMotor;
    private int topSpeed;
    private int ccMotor;

    public Owjek(int tahunMotor, int topSpeed, int ccMotor) {
        this.tahunMotor = tahunMotor;
        this.topSpeed = topSpeed;
        this.ccMotor = ccMotor;
    }

}
