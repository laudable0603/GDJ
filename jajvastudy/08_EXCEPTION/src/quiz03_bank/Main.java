package quiz03_bank;

public class Main {

	public static void main(String[] args){
		
		BankO me = new BankO("1111", 10000);
		BankO mom = new BankO("1111", 10000);
		
		try {
		mom.transfers(me, -5000);
		} catch (BankException e) {
			System.out.println(e.getMessage() + ", " + e.getErrorCode());
		}
		me.inquiry();
		mom.inquiry();

	}

}
