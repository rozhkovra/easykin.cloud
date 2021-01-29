package ru.rrozhkov.easykin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Calculation service!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CalculationApplication
{
    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class, args);
    }
}
