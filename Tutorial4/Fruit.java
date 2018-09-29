public class Fruit {
	private String nama;
	private int harga;
	private boolean sudahPanen;
	
	public Fruit(String nama, int harga) {
		this.nama = nama;
		this.harga = harga;
		sudahPanen = false;
	}

	@Override
	public String toString() {
		String status;
		if (this.sudahPanen) status = "Sudah dipanen";
		else status = "Belum dipanen";
		return "Buah " + this.nama + ", harga: " + this.harga + " G, status: " + status;
	}

	public String getNama() {
		return nama;
	}

	public int getHarga() {
		return harga;
	}

	public boolean isSudahPanen() {
		return sudahPanen;
	}

	public void setSudahPanen(boolean sudahPanen) {
		this.sudahPanen = sudahPanen;
	}
}