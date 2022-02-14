package nubank.service.wallet;

import nubank.service.wallet.domain.Income;
import nubank.service.wallet.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class App implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Autowired
	private IncomeRepository repository;

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		var format = new SimpleDateFormat("yyyy-MM-dd");

		// save a couple of customers
		repository.save(new Income("100% do CDI", 100.0, format.parse("2021-10-08")));
		repository.save(new Income("102% do CDI", 102.0, format.parse("2021-12-03")));
		repository.save(new Income("105% do CDI", 105.0, format.parse("2024-06-23")));

	}
}
