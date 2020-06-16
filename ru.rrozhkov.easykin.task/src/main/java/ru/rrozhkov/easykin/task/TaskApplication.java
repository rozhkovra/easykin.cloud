package ru.rrozhkov.easykin.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Task service
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TaskApplication
{
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
