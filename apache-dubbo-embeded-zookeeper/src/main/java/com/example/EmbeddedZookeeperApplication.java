package com.example;

import io.github.raonigabriel.embedded.zookeeper.annotation.EnableEmbeddedZooKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmbeddedZooKeeper
public class EmbeddedZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedZookeeperApplication.class, args);
    }
}