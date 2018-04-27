
public class Customer {
	 private String name;
	 private String address;
	 private Booking[] myBooking;
	 private int nbBookings;
	 
	 
	 
	 public Customer(String name, String address, int size){
	 this.name = name;
	 this.address = address;
	 myBooking = new Booking[size];
	 nbBookings=0;
	 }
	 public void addBooking(Booking b){
	 if (nbBookings < myBooking.length) 
	 if (b instanceof Hotel)
	 myBooking[nbBookings++] = new Hotel((Hotel)b); 
	 
	 }
	 
	 
	 public double totalHotelCost(){
	 double res = 0;
	 	for (int i=0; i < nbBookings; i++) 
	 		if (myBooking[i] instanceof Hotel) 
	 			res += myBooking[i].calculateCost();
	 return res;
	 }
	 
	 
	 public Hotel mostExpensiveHotel(){
	 Hotel max = null; 
	 	for (int i=0; i<nbBookings; i++) { 
	 		if (myBooking[i] instanceof Hotel) { 
	 			if (max == null) 
	 				max = (Hotel)myBooking[i];
	 else
		 if (max.calculateCost() < myBooking[i].calculateCost())
			 max = (Hotel)myBooking[i];
	 		}
	 }
	 return max;

	 }

	 
	 public Hotel[] getHotel(String d, int n){
	 Hotel[] res = new Hotel[nbBookings];
	 Hotel h;
	 int j = 0;
	 for (int i=0; i<nbBookings; i++) { 
		 if ( (myBooking[i] instanceof Hotel))
		if(myBooking[i].getDate().equals(d) && ( ((Hotel)myBooking[i]).getNbOfNights() >= n))
		 res[j++] = (Hotel)myBooking[i];
	 }
	 return res;
	 }

	}

