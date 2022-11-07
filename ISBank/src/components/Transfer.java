package components;

import java.util.Date;

public class Transfer extends Flow{

	private Integer accountNumber;

	public Transfer(String comment, String identifier, Double amount, Integer targetAccountNumber, Boolean effect,
			Date date, Integer accountNumber) {
		super(comment, identifier, amount, targetAccountNumber, effect, date);
		this.accountNumber= accountNumber;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

//	@Override
//	public String toString() {
//		return "Transfer [accountNumber:" + accountNumber + ", comment:" + getComment() + ", identifier:"
//				+ getIdentifier() + ", amount:" + getAmount() + ", targetAccountNumber:"
//				+ getTargetAccountNumber() + ", effect:" + getEffect() + ", date:" + getDate() + "]";
//	}

}
