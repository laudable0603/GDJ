package quiz03_bank;

public class BankO {
	
	private String accNo;
	private long balance;
	
	public BankO(String accNo, long balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void deposit(long money) throws BankException{
		if (money < 0) {
			throw new BankException("마이너스 입금불가", 1);
		}
		balance += money;
		
	}
	public long withdrawal(long money) throws BankException {
		
		if (money <= 0) {
			throw new BankException("마이너스 출금 불가", 2000);
		}else if (money > balance) {
			throw new BankException("잔액보다 큰 출금 불가", 2001);
		}
		balance -= money;
		return money;
		
	}
	public void transfers(BankO acc, long money) throws BankException {
		acc.deposit(withdrawal(money));
	}
	
	public void inquiry() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "BankO [accNo=" + accNo + ", balance=" + balance + "]";
	}
	
	
	
	
}
