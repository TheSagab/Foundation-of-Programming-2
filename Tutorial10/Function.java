/**
 * Created by ASUS on 5/10/2017.
 */
public class Function {
    private int[] consPangkat;
    private boolean derivative;
    private int highestOrder;

    public Function(int[] cons) {
        this.consPangkat = cons;
        this.highestOrder = consPangkat.length;
    }

    public Function(int[] cons, boolean derivative) {
        this.consPangkat = cons;
        this.derivative = derivative;
        this.highestOrder = consPangkat.length;
    }
    // f(x) = x^2 + 4x + 4
    // f(3) = 3^2 + 4.3 + 4 = 25
    public void printTitik(int interval){
        //System.out.println(this);
        for(int x = -100; x <= 100; x += interval){
            int y = getY(x);
            if(derivative)
                System.out.printf("d(x) -> x: %4d, y: %8d%n", x, y);
            else
                System.out.printf("f(x) -> x: %4d, y: %8d%n", x, y);
        }
    }

    public int getY(int x){
        int y = consPangkat[0];
        for(int j = 1; j < consPangkat.length; j++){
            if(consPangkat[j] == 0) continue;
            y += consPangkat[j] * Math.pow(x, j);
        }
        return y;
    }

    // x^2 + 2x + 1 -> 2x + 2
    public Function getDerivative(){
        int[] consTurunan = new int[this.consPangkat.length-1];
        for (int i = consTurunan.length-1; i > 0 ; i--) {
            consTurunan[i] = consPangkat[i+1]*(i+1);
        }
        consTurunan[0] = consPangkat[1];
        return new Function(consTurunan, true);
    }

    public int getYScale(){
        int num = 0;
        for (int i = 0; i < consPangkat.length; i++) {
            num += Math.pow(100, i)*consPangkat[i];
        }
        int scale = 0;
        while(num / 1000 != 0){
            num /= 10;
            scale++;
        }
        return scale;
    }

    public int getHighestOrder() {
        return highestOrder-2;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = consPangkat.length - 1; i > 1; i--) {
            if (consPangkat[i] > 1) s += consPangkat[i] + "x^" + i + " + ";
            else if (consPangkat[i] == 1) s += "x^" + i + " + ";
            else s += "";
        }
        s += consPangkat[1] + "x + ";
        s += consPangkat[0];
        return s;
    }
}
