package components;

import java.util.Date;

public abstract class Flow {

	private String comment;
	private String identifier;
	private Double amount;
	private Integer targetAccountNumber;
	private Boolean effect;
	private Date date;

	public Flow(String comment, String identifier, Double amount, Integer targetAccountNumber, Boolean effect, Date date) {
		this.comment = comment;
		this.identifier = identifier;
		this.amount = amount;
		this.targetAccountNumber = targetAccountNumber;
		this.effect = effect;
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(Integer targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public Boolean getEffect() {
		return effect;
	}

	public void setEffect(Boolean effect) {
		this.effect = effect;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	@Override
//	public String toString() {
//		return "Flow [comment:" + comment + ", identifier:" + identifier + ", amount:" + amount
//				+ ", targetAccountNumber:" + targetAccountNumber + ", effect:" + effect + ", date:" + date + "]";
//	}


}
