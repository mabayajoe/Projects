  package DessertShop;

import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;

import DessertShop.Payable.PayType;

public class DessertShop {
	// Attributes
	private static HashMap<String, Customer> customerDB = new HashMap<String, Customer>();
	// Constructor

	// Methods
	public static void main(String[] args) {

		boolean closed = false;
		while (!closed) {

			Order o1 = new Order();
			Scanner sIn = new Scanner(System.in);
			String choice;
			DessertItem orderItem;
			String name;

			// String paymentMethong;

			boolean done = false;
			while (!done) {
				System.out.println("\n1: Candy");
				System.out.println("2: Cookie");
				System.out.println("3: Ice Cream");
				System.out.println("4: Sunday");
				System.out.println("5: Admin Module");

				System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
				choice = sIn.nextLine();

				if (choice.equals("")) {

					// System.out.print("\nEnter the customer name: ");
					// name = sIn.nextLine();
					// customerDB.put(name, customerDB.get(i).getName());

					o1.setPayType(validationPayment(sIn, "What form of payment will be used? (CASH, CARD, PHONE):",
							"That's not a valid form of payment. "));
					done = true;

				} else {
					switch (choice) {
					case "1":
						orderItem = userPromptCandy();
						o1.addDessertItem(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "2":
						orderItem = userPromptCookie();
						o1.addDessertItem(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "3":
						orderItem = userPromptIceCream();
						o1.addDessertItem(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "4":
						orderItem = userPromptSundae();
						o1.addDessertItem(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "5":
						admin_Module();
						break;

					default:
						System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
						break;
					}// end of switch (choice)
				} // end of if (choice.equals(""))
			} // end of while (!done)

			System.out.println("\n");

			Candy c1 = new Candy("Candy Corn", 1.5, .25);
			o1.addDessertItem(c1);

			Candy c2 = new Candy("Gummy Bears", .25, .35);
			o1.addDessertItem(c2);

			Cookie co1 = new Cookie("Chocolate Chip", 6, 3.99);
			o1.addDessertItem(co1);

			IceCream i1 = new IceCream("Pistachio", 2, .79);
			o1.addDessertItem(i1);

			Sundae s1 = new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29);
			o1.addDessertItem(s1);

			Cookie co2 = new Cookie("Oatmeal Raisin", 2, 3.45);
			o1.addDessertItem(co2);

			Collections.sort(o1.getOrderList());
			System.out.println(o1); // <-------- Replace that code with a single line to print out the receipt
									// (simply print order1)\

			System.out.print("\nEnter the customer name: ");
			name = sIn.nextLine();

			if (!customerDB.containsKey(name)) {
				Customer newCustomer = new Customer(name);
				customerDB.put(name, newCustomer);
				customerDB.get(name).addToHistory(o1);
			} else {
				customerDB.get(name).addToHistory(o1);
			}

			for (String i : customerDB.keySet()) {
				if (i.equals(name)) {
					System.out.print(
							"\n---------------------------------------------------------------------------------------\n");
					System.out.printf("\nCustomer Name: %-20sCustomer ID: %-14dTotal Orders: %-10d", name,
							customerDB.get(i).getID(), customerDB.get(i).getOrderHistory().size());
				}
			}

			System.out.println("\n\nHit enter to start a new order. \n");
			String neworder = sIn.nextLine();

			while (!neworder.equals("")) {
				closed = false;
			}
		}

		/*
		 * 
		 * for(DessertItem o : O1.order){
		 * System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", o.getName(),
		 * o.calculateCost(), o.calculateTax()); }
		 * 
		 * System.out.println("----------------------------------------------");
		 * System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", "Order Subtotals:" ,
		 * O1.orderCost(), O1.orderTax()); System.out.printf("%-25s$%-8.2f\n",
		 * "Order Total: " , O1.orderCost() + O1.orderTax());
		 * System.out.printf("Total items in the order: " + O1.itemCount());
		 */
	}

	private static DessertItem userPromptCandy() {
		Scanner ca = new Scanner(System.in);

		System.out.println("Enter the candy you want: ");
		String candytype = ca.nextLine();
		System.out.println("Enter the Candy Weight: ");
		double candyweight = validationdouble(ca, "weight purchased");
		System.out.println("Enter the price per pound: ");
		double ppp = validationdouble(ca, "Price Per Pound");

		return new Candy(candytype, candyweight, ppp);
	}

	private static DessertItem userPromptCookie() {
		Scanner co = new Scanner(System.in);

		System.out.println("Enter the type of cookie: ");
		String cookieC = co.nextLine();
		System.out.println("Enter the quantity purchased: ");
		int cookieqty = validationint(co, "Cooki Quantity");
		System.out.println("Enter the price per dozen: ");
		double ppd = validationdouble(co, "Price per Dozen");

		return new Cookie(cookieC, cookieqty, ppd);
	}

	private static DessertItem userPromptIceCream() {
		Scanner ic = new Scanner(System.in);

		System.out.println("Enter the type of Ice Cream used: ");
		String icname = ic.nextLine();
		System.out.println("Enter the number of scoops: ");
		int icnum = validationint(ic, "Number of scoops");
		System.out.println("Enter the price per scoop:");
		double icpps = validationdouble(ic, "Enter a number. ");

		return new IceCream(icname, icnum, icpps);
	}

	private static DessertItem userPromptSundae() {
		Scanner ic = new Scanner(System.in);

		System.out.println("Enter the type of Ice Cream used: ");
		String icname = ic.nextLine();
		System.out.println("Enter the number of scoops: ");
		int icnum = validationint(ic, "Number of scoops");
		System.out.println("Enter the price per scoop:");
		double icpps = validationdouble(ic, "Enter a number. ");
		System.out.println("Enter the kind of topping used: ");
		String tytp = ic.nextLine();
		System.out.println("Enter the price for the topping: ");
		double ppt = validationdouble(ic, "Error, please enter the price fof the topping. ");

		return new Sundae(icname, icnum, icpps, tytp, ppt);
	}

	private static double validationdouble(Scanner input, String error) {
		double validatedoble = 0;
		do {
			try {
				validatedoble = Double.parseDouble(input.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Error. PLEASE   Enter a number.\n");
			}
		} while (true);
		return validatedoble;
	}

	private static int validationint(Scanner input, String error) {
		int validateint = 0;
		do {
			try {
				validateint = Integer.parseInt(input.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Error. PLEASE   Enter a number.\n");
			}
		} while (true);
		return validateint;
	}

	private static PayType validationPayment(Scanner input, String question, String error) {
		PayType status = null;
		boolean valid = false;
		while (!valid) {
			System.out.println("What form of payment will be used? (CASH, CARD, PHONE): ");
			String ans = input.nextLine();
			for (PayType pm : PayType.values()) {
				if (ans.equalsIgnoreCase(pm.name())) {
					valid = true;
					status = pm;
				}
			}
			if (!valid) {
				System.out.println("That's not a valid form of payment.");
			}
		}
		return status;
	}

	/*
	 * private static String userCustomer(Order o1){
	 * 
	 * Scanner sIn = new Scanner(System.in);
	 * System.out.println("Enter the customer name: "); String name =
	 * sIn.nextLine();
	 * 
	 * if(!customerDB.containsKey(name)){
	 * 
	 * Customer newCustomer = new Customer(name); newCustomer.addToHistory(o1);
	 * customerDB.put(newCustomer.getName(), newCustomer); }else{
	 * customerDB.get(name).addToHistory(o1); }
	 * 
	 * return name; }
	 */

	private static void admin_Module() {
		Scanner sIn = new Scanner(System.in);

		boolean again = false;
		while (!again) {

			System.out.println("\n1: Shop Customer List");
			System.out.println("2: Customer Order History");
			System.out.println("3: Best Customer");
			System.out.println("4: Exit Admin Module");

			System.out.print("\nWhat would you like to do? (1-3, Type 4 to Exit): ");
			String choice = sIn.nextLine();

			switch (choice) {
			case "1":
				for (String customer : customerDB.keySet()) {
					System.out.printf("\nCustomer Name: %-15sCustomer ID: %-20d\n", customerDB.get(customer).getName(),
							customerDB.get(customer).getID());
				}
				break;
			case "2":
				System.out.println("Enter the name of the customer: ");
				choice = sIn.nextLine();

				for (String i : customerDB.keySet()) {
					if (choice.equals(customerDB.get(i).getName())) {
						System.out.printf("\nCustomer Name: %-10sCustomer ID: %-15d\n", customerDB.get(i).getName(),
								customerDB.get(i).getID());
						System.out.println(
								"-----------------------------------------------------------------------------\n");

						for (int o = 0; o < customerDB.get(i).getOrderHistory().size(); o++) {
							int j = o + 1;
							System.out.print("Order #: " + j + "\n"); 
							System.out.println(customerDB.get(i).getOrderHistory().get(o));
							System.out.println(
									"\n---------------------------------------------------------------------------------------\n");
						}
					}
				}
				break;
			case "3":
				int big = 0;
				String name = "";

				for (String i : customerDB.keySet()) {
					if (customerDB.get(i).getOrderHistory().size() > big) {
						big = customerDB.get(i).getOrderHistory().size();
					}
					if (big == customerDB.get(i).getOrderHistory().size()) {
						name = customerDB.get(i).getName();
					}
				}
				System.out.println("\n----------------------------------------------------");
				System.out.printf("The Dessert Shop's most valued customer is: %s!", name);
				System.out.println("\n----------------------------------------------------");
				break;
			case "4":
				System.out.println("Please type a number between 1-3:");
				again = true;
				break;
			}

		}
	}

}
