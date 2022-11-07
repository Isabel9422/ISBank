package components;

import java.util.Date;

public class Debit extends Flow{

	public Debit(String comment, String identifier, Double amount, Integer targetAccountNumber, Boolean effect,
			Date date) {
		super(comment, identifier, amount, targetAccountNumber, effect, date);
	}

//	@Override
//	public String toString() {
//		return "Debit [comment:" + getComment() + ", identifier:" + getIdentifier() + ", amount:"
//				+ getAmount() + ", targetAccountNumber:" + getTargetAccountNumber() + ", effect:"
//				+ getEffect() + ", date:" + getDate() + "]";
//	}
	
	
}
