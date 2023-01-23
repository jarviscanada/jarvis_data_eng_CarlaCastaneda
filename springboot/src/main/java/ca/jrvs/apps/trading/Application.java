package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.controller.QuoteController;
import ca.jrvs.apps.trading.service.QuoteService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


import org.slf4j.Logger;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class,
        DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@PropertySource("/application.properties")
public class Application implements CommandLineRunner {
  private Logger logger = LoggerFactory.getLogger(Application.class);

  @Value("${app.init.dailyList}")
  private String[] initDailyList;



  @Autowired
  private QuoteService quoteService;

  public Application(String[] initDailyList, QuoteService quoteService){
    this.initDailyList = initDailyList;
    this.quoteService=quoteService;

  }

  public static void main(String args[]) {
    SpringApplication app = new SpringApplication(Application.class);
    app.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
  QuoteController quoteController = new QuoteController(quoteService);

    Arrays.stream(initDailyList).forEach(i->quoteController.getQuote(i));


  }
}
