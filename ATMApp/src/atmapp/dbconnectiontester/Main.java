package atmapp.dbconnectiontester;

public class Main {
	
	public static void main(String[] args) throws Exception{
		MySQLAcces dao = new MySQLAcces();
		dao.readDataBase();
	}

}
