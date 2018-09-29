import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by ASUS on 5/10/2017.
 */
public class Lab10 {
    static final int WINDOW_WIDTH = 600;
    static final int WINDOW_HEIGHT = 600;
    public static void main(String[] args) {
        boolean valid = false;
        String functionOrder, intervalStr;
        int interval, funcOrder;
        int[] coefArr;
         do{
            functionOrder = JOptionPane.showInputDialog("Order of f(x)");
            if(isValidInput(functionOrder)) valid = true;
            else JOptionPane.showMessageDialog(null,
                    functionOrder + " is not a valid function order!","Warning", JOptionPane.WARNING_MESSAGE);
        } while (!valid);
        funcOrder = Integer.parseInt(functionOrder);
        valid = false;
        do {
            intervalStr = JOptionPane.showInputDialog("Interval between checks");
            if(isValidInput(intervalStr)) valid = true;
            else JOptionPane.showMessageDialog(null,
                    intervalStr + " is not a valid interval!","Warning", JOptionPane.WARNING_MESSAGE);
        } while (!valid);
        interval = Integer.parseInt(intervalStr);
        coefArr = new int[funcOrder+1];
        for (int i = 0; i <= funcOrder; i++){
            String coef = JOptionPane.showInputDialog("Coefficient for x^" + i);
            if (isInteger(coef)) coefArr[i] = Integer.parseInt(coef);
            else{
                JOptionPane.showMessageDialog(null,
                        coef + " is not a valid function coefficient!","Warning", JOptionPane.WARNING_MESSAGE);
                i--;
            }
        }
        Function fx = new Function(coefArr);
        fx.printTitik(interval);
        Function dx = fx.getDerivative();
        dx.printTitik(interval);
        //System.out.println(fx.getY(0));
        //System.out.println(fx.getY(5));
        Graph g = new Graph(fx, dx);
        JFrame frame = new JFrame("Function Plot");
        frame.add(g);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(null);
        frame.setVisible(true);
    }

    static boolean isValidInput(String s){
        try {
            int x = Integer.parseInt(s);
            if(x > 0) return true;
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
