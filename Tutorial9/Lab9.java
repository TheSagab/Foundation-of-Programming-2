import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ASUS on 5/2/2017.
 */
public class Lab9 {
    public static void main(String[] args) throws IOException{
        BufferedReader file = null;
        String command;
        PrintWriter out = new PrintWriter("keluaran.out");
        try {
            file = new BufferedReader(new FileReader("masukan.in"));
            int n = Integer.parseInt(file.readLine());
            String[] list = file.readLine().split(" ");
            if (list.length != n) throw new IllegalArgumentException("List amount is not the same as requested");
            int q = Integer.parseInt(file.readLine());
            for (int i = 0; i < q; i++) {
                command = file.readLine();
                double num;
                double stdev;
                int x = Integer.parseInt(command.split(" ")[1]);
                int y = Integer.parseInt(command.split(" ")[2]);
                if (command.split(" ")[0].equals("Max")) {
                    num = getMax(x, y, list, out);
                    out.printf("Nilai maksimal dari indeks ke %d - %d adalah " + (integerable(num) ? "%d%n" : "%f%n"), x, y, (int) num, num);
                }
                else if (command.split(" ")[0].equals("Quartile")){
                    num = getQuartile1(x, y, list, out);
                    out.printf("Nilai quartile 1 dari indeks ke %d - %d adalah " + (integerable(num) ? "%d%n" : "%f%n"), x, y, (int) num, num);
                    num = getQuartile2(x, y, list, out);
                    out.printf("Nilai quartile 3 dari indeks ke %d - %d adalah " + (integerable(num) ? "%d%n" : "%f%n"), x, y, (int) num, num);
                }
                else if (command.split(" ")[0].equals("Mean")) {
                    num = getMean(x, y, list, out);
                    if (integerable(num))
                        out.printf("Nilai rata-rata dari indeks ke %d - %d adalah %d%n", x, y, (int) num);
                    else
                        out.printf("Nilai rata-rata dari indeks ke %d - %d adalah %f%n", x, y, num);
                }
                else if (command.split(" ")[0].equals("Stdev")) {
                    stdev = getStdev(x, y, list, out);
                    out.println("Nilai standard deviasi dari indeks ke " + x + " - " + y + " adalah " + stdev);
                }
                else throw new IllegalArgumentException("Can not find operation for " + command.split(" ")[0]);
            }
        }catch (IOException e){
            out.println("Error = File not Found Exception for \"masukan.in\"");
        }catch (IllegalArgumentException e){
            out.println("Error = " + e.getMessage());
        }catch (IndexOutOfBoundsException e){
            out.println("Error = Index out of range " + e.getMessage());
        }catch(Exception e){
            out.println("Error = " + e.getMessage());
        }
        finally {
            if(file != null)
                file.close();
            if(out != null)
                out.close();
        }
    }
    public static double getMax(int x, int y, String[] list, PrintWriter out){
        double max = Integer.MIN_VALUE;
        for (int i = x-1; i < y; i++) {
            try {
                if (Double.parseDouble(list[i]) > max)
                    max = Double.parseDouble(list[i]);
            } catch (NumberFormatException e){
                out.println("Error = Invalid Number Format at index " + (i+1));
            }
        }
        return max;
    }

    public static double getQuartile1(int x, int y, String[] list, PrintWriter out){
        ArrayList<Double> angka = new ArrayList<>();
        for (int i = x-1; i < y; i++) {
            try {
                angka.add(Double.parseDouble(list[i]));
            } catch (NumberFormatException e) {
                out.println("Error = Invalid Number Format at index " + (i + 1));
            }
        }
        Collections.sort(angka);
        return angka.get((angka.size()) / 4);
    }

    public static double getQuartile2(int x, int y, String[] list, PrintWriter out){
        ArrayList<Double> angka = new ArrayList<>();
        for (int i = x-1; i < y; i++) {
            try {
                angka.add(Double.parseDouble(list[i]));
            } catch (NumberFormatException e) {
                out.println("Error = Invalid Number Format at index " + (i + 1));
            }
        }
        Collections.sort(angka);
        return angka.get(3 * (angka.size()) / 4);
    }

    public static double getMean(int x, int y, String[] list, PrintWriter out){
        double sum = 0;
        int num = 0;
        for (int i = x-1; i < y; i++) {
            try {
                sum += Double.parseDouble(list[i]);
                num++;
            } catch (NumberFormatException e) {
                out.println("Error = Invalid Number Format at index " + (i + 1));
            }
        }
        return sum / num;
    }

    public static double getStdev(int x, int y, String[] list, PrintWriter out){
        double mean = getMean(x, y, list, out);
        double temp = 0;
        int n = 0;
        for (int i = x-1; i < y; i++) {
            try {
                temp += Math.pow((Double.parseDouble(list[i]) - mean), 2);
                n++;
            }catch(NumberFormatException e){
            }
        }
        temp /= (n-1);
        return Math.sqrt(temp);
    }

    public static boolean integerable(double d){
        if(d == Math.floor(d)) return true;
        return false;
    }
}
