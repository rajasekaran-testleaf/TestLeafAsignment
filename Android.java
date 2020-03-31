package Day1.FirstCode;

public class Android {

	boolean isLatest=true;
	String dName = "Samsung J7";
	float vNumber = 8.0f;
	int year = 2017;
	long price = 230000000;


	public static void main(String[] args) {

		//Calling Class 'ANdroid'
		Android andro = new Android();

		//Printing the Released year
		int year2 = andro.year;
		System.out.println("Release Year  :"+""+year2);

		//Printing the device Name
		String dName2 = andro.dName;
		System.out.println("Device Name  :"+""+dName2);

		//Printing the isLatest version
		boolean isLatest2 = andro.isLatest;
		System.out.println("Is Latest Version  :"+""+isLatest2);

		//Printing the price
		long price2 = andro.price;
		System.out.println("Price of the device  :"+""+price2);

		//Printing the version number
		float vNumber2 = andro.vNumber;
		System.out.println("Android Version    :"+""+vNumber2);

	}

}
