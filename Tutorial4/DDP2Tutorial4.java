public class DDP2Tutorial4 {
	public static void main(String[] args) {
		Sprite red = new Sprite("Red", 4);
		System.out.println(red);
		Sprite yellow = new Sprite("Yellow", 2);
		System.out.println(yellow);
		//System.out.println("Teman terbaru Red : " + red.getPeriTerakhir());
		Sprite blue = new Sprite("Blue", 9);
		System.out.println(blue);
		//System.out.println("Teman terbaru Red : " + red.getPeriTerakhir());
		//System.out.println("Teman terbaru Yellow : " + yellow.getPeriTerakhir());
		Sprite green = new Sprite("Green", 6);
		System.out.println(green);
		//System.out.println("Teman terbaru Red : " + red.getPeriTerakhir());
		//System.out.println("Teman terbaru Yellow : " + yellow.getPeriTerakhir());
		//System.out.println("Teman terbaru Blue : " + blue.getPeriTerakhir());
		
		Fruit apple = new Fruit("Apple", 50);
		System.out.println(apple);
		Fruit orange = new Fruit("Orange", 40);
		System.out.println(orange);
		Fruit banana = new Fruit("Banana", 100);
		System.out.println(banana);
		Fruit grape = new Fruit("Grape", 80);
		System.out.println(grape);
		Fruit papaya = new Fruit("Papaya", 70);
		System.out.println(papaya);
		
		red.harvest(apple);
		red.harvest(orange);
		yellow.harvest(banana);
		blue.harvest(grape);
		blue.harvest(papaya);
		green.harvest(orange);
		
		System.out.println(apple);
		System.out.println(orange);
		System.out.println(banana);
		System.out.println(grape);
		System.out.println(papaya);
		
		Payment.paySprite(red);
		Payment.paySprite(yellow);
		Payment.paySprite(blue);
		Payment.paySprite(green);
	}
}