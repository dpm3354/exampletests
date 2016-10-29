package testcases;



import com.github.javafaker.Faker;

import db.InvoiceData;

public class InvoiceDataGenerator {

	public static InvoiceData generate() {
		Faker faker = new Faker();
		InvoiceData invoice = new InvoiceData(
				faker.idNumber().toString(), 
				faker.company().name(), 
				faker.lorem().word(), 
				"12.23", 
				"Draft", 
				faker.date().toString(),
				faker.lorem().sentence());
		return invoice;
	}

}
