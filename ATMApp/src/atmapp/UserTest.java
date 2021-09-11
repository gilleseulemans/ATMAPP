package atmapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test() {
		User userOne = new User("Gilles", "Ceulemans", 100);
		User userTwo = new User("Bob", "Bob", 50);
		
		assert userOne.getName() == "Gilles";
		assert userOne.getLastName() == "Ceulemans";
		assert userOne.getbalance() == 100;
		
		Transaction transToBob = new Transaction(userOne, userTwo, 50);
		assert userOne.getbalance() == 50;
		System.out.println(userOne.getbalance());
	}

}
