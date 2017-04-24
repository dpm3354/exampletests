package testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

import db.InvoiceData;

public class InvoiceDataGenerator {

	private static final String statuses[] = new String[]{ "Draft", "Paid", "Sent", "Past Due" };

	public static InvoiceData generate() {
		Faker faker = new Faker();
		
		InvoiceData invoice = new InvoiceData(
				Long.toString(faker.number().randomNumber(5, true)), 
				faker.company().name(), 
				faker.lorem().word(), 
				faker.commerce().price().toString(), 
				status(),
				new SimpleDateFormat("MM/dd/yyyy").format(new Date()),
				faker.lorem().sentence());
		return invoice;
	}

	private static String status(){
		int randomIndex = ThreadLocalRandom.current().nextInt(0, 4);		
		return statuses[randomIndex];
	}
	
}
