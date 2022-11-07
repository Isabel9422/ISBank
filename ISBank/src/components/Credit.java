package components;

import java.util.Date;

public class Credit extends Flow{

	public Credit(String comment, String identifier, Double amount, Integer targetAccountNumber, Boolean effect,
			Date date) {
		super(comment, identifier, amount, targetAccountNumber, effect, date);
	}

//	@Override
//	public String toString() {
//		return "Credit [comment:" + getComment() + ", identifier:" + getIdentifier() + ", amount:"
//				+ getAmount() + ", targetAccountNumber:" + getTargetAccountNumber() + ", effect:"
//				+ getEffect() + ", date:" + getDate() + "]";
//	}

	
}
