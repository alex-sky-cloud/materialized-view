package com.materializedview;

import com.materializedview.service.data.GeneratorDataInitialization;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MaterializedViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaterializedViewApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(GeneratorDataInitialization generatorDataInitialization){
        return args -> generatorDataInitialization.run();
    }

}
