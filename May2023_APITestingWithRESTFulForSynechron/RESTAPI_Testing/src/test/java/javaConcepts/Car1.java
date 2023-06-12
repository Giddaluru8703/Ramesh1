package javaConcepts;

public class Car1 {

	String model;
	int price;
	int wheels;
	public Car1(String model,int price, int wheels){
		this.model=model;
		this.price=price;
		this.wheels=wheels;
	}
	public static void main(String[] args) {
		Car1 c=new Car1("BMW",20000,4);
		System.out.println("model ="+c.model);
		System.out.println("price="+c.price);
		System.out.println("wheels="+c.wheels);
	}

}
