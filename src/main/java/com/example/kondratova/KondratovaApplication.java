package com.example.kondratova;

import com.example.kondratova.taskClasses.ParseFile;
import com.example.kondratova.taskClasses.TaskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class KondratovaApplication implements CommandLineRunner {

    @Autowired
    private ParseFile parseFile;

    public static void main(String[] args) {
        SpringApplication.run(KondratovaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        parseFile.parseCSVFile(new File("Показатель счастья по странам 2017.csv").getAbsolutePath());
        TaskHandler.secondTask();
        TaskHandler.thirdTask();
        TaskHandler.firstTask();
    }
}
