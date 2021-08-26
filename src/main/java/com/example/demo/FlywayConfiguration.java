package com.example.demo;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;

@Configuration
@Slf4j
public class FlywayConfiguration {

    @Bean
    @Profile({"flywayRepair"})
    public FlywayMigrationStrategy repairMigrateStrategy() {
        return Flyway::repair;
    }

}
