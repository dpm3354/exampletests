package db;


public class InvoiceData {
	
	private String invoiceNumber;
	private String companyName;
	private String typeOfWork;
	private String amount;
	private String status;
	private String dueDate;
	private String description;

	public InvoiceData(String invoiceNumber, String companyName, String typeOfWork, String amount, String status, String dueDate, String description) {
		this.setInvoiceNumber(invoiceNumber);
		this.setCompanyName(companyName);
		this.setTypeOfWork(typeOfWork);
		this.setAmount(amount);
		this.setStatus(status);
		this.setDueDate(dueDate);
		this.setDescription(description);
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeOfWork() {
		return typeOfWork;
	}

	public void setTypeOfWork(String typeOfWork) {
		this.typeOfWork = typeOfWork;
	}

	@Override
	public String toString() {
		return "InvoiceData [invoiceNumber=" + invoiceNumber + ", companyName=" + companyName + ", typeOfWork="
				+ typeOfWork + ", amount=" + amount + ", status=" + status + ", dueDate=" + dueDate + ", description="
				+ description + "]";
	}
	

}
