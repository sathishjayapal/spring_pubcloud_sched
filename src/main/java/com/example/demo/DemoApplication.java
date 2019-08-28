package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@EnableScheduling
public class DemoApplication {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);

  }

  @Scheduled(fixedDelay = 1000L)
  public void connectDB() {
    System.out.println(jdbcTemplate.queryForObject("select 1", String.class));
  }

}
