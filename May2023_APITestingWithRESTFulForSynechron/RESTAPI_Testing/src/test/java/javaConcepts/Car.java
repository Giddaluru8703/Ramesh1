package javaConcepts;

public class Car {
	
	String model;
	int price;
	int wheels;

	public static void main(String[] args) {
		
		Car c =new Car();
		c.model="BMW";
		c.price=20000;
		c.wheels=4;
		
		System.out.println("model ="+c.model);
		System.out.println("price="+c.price);
		System.out.println("wheels="+c.wheels);

	}

}
