package ru.rrozhkov.easykin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Reference service
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ReferenceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(ReferenceApplication.class, args);
    }
}
