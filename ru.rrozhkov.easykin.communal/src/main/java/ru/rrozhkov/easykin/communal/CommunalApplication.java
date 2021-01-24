package ru.rrozhkov.easykin.communal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Communal service
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CommunalApplication
{
    public static void main(String[] args) {
        SpringApplication.run(CommunalApplication.class, args);
    }
}
