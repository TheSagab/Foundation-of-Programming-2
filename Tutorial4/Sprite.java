public class Sprite {
	private String nama;
	private int heart;
	private int totalHarga;

	private static String periTerakhir;
	
	public Sprite (String nama, int heart) {
		this.nama = nama;
		this.heart = heart;
		totalHarga = 0;
		periTerakhir = nama;
	}
	
	public void harvest(Fruit buah) {
		// @TODO implementasi fungsi ini
		if (!(buah.isSudahPanen())){
			buah.setSudahPanen(true);
			this.totalHarga += buah.getHarga();
			System.out.printf("%s telah memanen buah %s dengan harga %d G%n", this.nama, buah.getNama(), buah.getHarga());
		}
		else{
			System.out.printf("%s tidak jadi memanen buah %s karena sudah tidak ada%n", this.nama, buah.getNama());
		}
	}

	@Override
	public String toString() {
		return "Peri " + this.nama + ", jumlah hati: " + this.heart;
	}

	public String getNama() {
		return nama;
	}

	public int getHeart() {
		return heart;
	}

	public int getTotalHarga() {
		return totalHarga;
	}

	public static String getPeriTerakhir() {
		return periTerakhir;
	}

}
