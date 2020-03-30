package Day1.FirstCode;

public class Mobile {

	int pNmber = 1234567890;
	String brand = "Samsung";
	boolean isAndroid = true;



	public static void main(String[] args) {

		//Calling Class Mobile
		Mobile mob = new Mobile();

		//Printing the phone number
		int pNmber2 = mob.pNmber;
		System.out.println(pNmber2);

		//Printing the Brand
		String brand2 = mob.brand;
		System.out.println(brand2);

		//Printing Is the brand belongs to Android
		boolean isAndroid2 = mob.isAndroid;
		System.out.println(isAndroid2);

	}

}
