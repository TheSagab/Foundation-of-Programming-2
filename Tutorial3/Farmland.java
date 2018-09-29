import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by ASUS on 2/28/2017.
 */
public class Farmland {
    private String nama, warna;
    private LocalDate tanggalPanen, tanggalExpire;
    private Period periodBagus, periodExpire;
    private long barcode;
    private char grade;
    private double diameter, berat;
    private boolean biji;

    public Farmland(){

    }

    /**
     * Memasukkan info buah
     */
    public void inputInfoBuah(){
        Scanner in = new Scanner(System.in);
        System.out.println("Database Buah ~Farmland~");
        System.out.println("---------------------------------");
        System.out.print("Nama : ");
        this.nama = in.nextLine();
        System.out.print("Tanggal Panen : ");
        String[] tanggalPanenStr = in.nextLine().split("-");
        System.out.print("Barcode : ");
        this.barcode = in.nextLong();
        System.out.print("Diameter : ");
        this.diameter = in.nextDouble();
        System.out.print("Berat : ");
        this.berat = in.nextDouble();
        in.nextLine(); // Mencegah bug
        System.out.print("Warna : ");
        this.warna = in.nextLine();
        System.out.print("Grade : ");
        this.grade = in.next().charAt(0);
        in.nextLine(); // Mencegah bug
        System.out.print("Expiration Date : ");
        String[] tanggalExpireStr = in.nextLine().split("-");
        System.out.print("Memiliki Biji : ");
        System.out.println(LocalDate.now());
        this.biji = Boolean.parseBoolean(in.next().toLowerCase());
        this.setTanggalPanen(tanggalPanenStr);
        this.setTanggalExpire(tanggalExpireStr);
        this.setPeriodBagus();
        this.setPeriodExpire();
    }
    public void printData(){
        System.out.println("\nDATA TERSIMPAN");
        System.out.println("-----------------------------------");
        System.out.printf("%s - %d - %c%n",this.nama, this.barcode, this.grade);
        System.out.printf("Berdiameter %.2f cm%n", this.diameter);
        System.out.printf("Berat %.2f gram%n", this.berat);
        System.out.printf("Warna %s%n", this.warna);
        if (this.periodBagus.getMonths() == 0)
            System.out.printf("Masa bagus %d tahun, ", this.periodBagus.getYears());
        else
            System.out.printf("Masa bagus %d tahun %d bulan, ", this.periodBagus.getYears(), this.periodBagus.getMonths());
        if (this.periodExpire.getMonths() == 0)
            System.out.printf("expired dalam %d tahun%n", this.periodExpire.getYears());
        else
            System.out.printf("expired dalam %d tahun %d bulan%n", this.periodExpire.getYears(), this.periodExpire.getMonths());
        if (this.biji)
            System.out.println("Memiliki biji...");
        else if (!(this.biji))
            System.out.println("Tidak memiliki biji~");
    }

    public void printPrediksi(){
        int syarat = 0;
        System.out.println("\nPREDIKSI");
        System.out.println("-----------------------------------");
        long umurBuah = 12*(this.periodBagus.getYears()) + this.periodBagus.getMonths();
        System.out.println(this.periodBagus.getYears() +"" + this.periodBagus.getMonths());
        long nilaiKualitas = (long) ((Math.pow(this.berat, 2) * (Math.pow(this.diameter, 2)*10000) * Math.pow(umurBuah, 3)));
        long longNK = nilaiKualitas;
        if (this.nama.replace(" ","").length() % 2 == 0) syarat++;;
        if (this.berat / this.diameter > 2) syarat++;
        if (this.grade != 'C') syarat++;
        if (!(this.biji)) syarat++;
        if (this.periodExpire.getYears() >= 2) syarat++;
        System.out.printf("Nilai Kualitas %d%n", longNK);
        System.out.println("Memenuhi " + syarat + " dari 5 syarat");
        if (syarat >= 3)
            System.out.println(this.nama + " diekspor");
        else
            System.out.println(this.nama + " tidak diekspor");
    }

    public void setTanggalPanen(String[] tanggalPanenStr){
        int tanggal = Integer.parseInt(tanggalPanenStr[0]);
        int bulan = Integer.parseInt(tanggalPanenStr[1]);
        int tahun = Integer.parseInt(tanggalPanenStr[2]);
        this.tanggalPanen = LocalDate.of(tahun, bulan, tanggal);

    }
    public void setTanggalExpire(String[] tanggalExpireStr) {
        int tanggal = LocalDate.now().getDayOfMonth(); // Default pada hari ini
        int bulan = Integer.parseInt(tanggalExpireStr[0]);
        int tahun = Integer.parseInt(tanggalExpireStr[1]);
        this.tanggalExpire = LocalDate.of(tahun, bulan, tanggal);
    }

    public void setPeriodBagus(){
        this.periodBagus = Period.between(this.tanggalPanen, this.tanggalExpire);
    }
    public void setPeriodExpire(){
        this.periodExpire = Period.between(LocalDate.now(), this.tanggalExpire);
    }

}

// 3-2017
// 2-2019
