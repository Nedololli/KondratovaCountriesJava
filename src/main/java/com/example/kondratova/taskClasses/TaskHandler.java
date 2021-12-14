package com.example.kondratova.taskClasses;

import com.example.kondratova.CountryRepo;
import com.example.kondratova.CountryValuesRepository;
import com.example.kondratova.models.CountryModel;
import com.example.kondratova.models.CountryValuesModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class TaskHandler {

    private static CountryRepo countryRepo;
    private static CountryValuesRepository countryValuesRepository;
    private static ArrayList<CountryModel> listOfEuropeAndAfrica;


    public TaskHandler(CountryRepo countryRepo, CountryValuesRepository countryValuesRepository) {
        this.countryRepo = countryRepo;
        this.countryValuesRepository = countryValuesRepository;
    }

    public static void firstTask() throws IOException {
        var dataset = new DefaultCategoryDataset();
        for (var country:countryRepo.findAll()) {
            dataset.setValue(country.getHealthLifeExpectancy(), country.getCountry(), "Страны");
        }
        var chart = ChartFactory.createBarChart(
                "Показатель здоровья у стран", null, "Среднее здоровье у стран", dataset, PlotOrientation.VERTICAL, true, false, false);
        chart.setBackgroundPaint(Color.black);
        chart.getTitle().setPaint(Color.white);
        var plot = chart.getCategoryPlot();
        var barRender = (BarRenderer) plot.getRenderer();
        barRender.setItemMargin(0);

        ChartUtilities.saveChartAsPNG(new File("img.png"), chart, 1600, 800);
    }

    public static void secondTask(){
        listOfEuropeAndAfrica = countryRepo.findAllByRegion("Western Europe");
        listOfEuropeAndAfrica.addAll(countryRepo.findAllByRegion("Sub-Saharan Africa"));
        var sum = 0.0f;

        for (var element:listOfEuropeAndAfrica) {
            sum += element.getHealthLifeExpectancy();
        }

        System.out.println(" средний показатель здоровья среди Western Europe и Sub-Saharan Africa "+sum / listOfEuropeAndAfrica.size());
    }

    public static void thirdTask(){

        var averageValue = 0.0f;
        var numbers = 0;
        for (var element:listOfEuropeAndAfrica) {
            averageValue += element.sum();
            numbers ++;
        }

        averageValue = averageValue / numbers;
        var id = 1l;
        for (var element:listOfEuropeAndAfrica) {
            countryValuesRepository.save(new CountryValuesModel(id, element, Math.abs(averageValue - element.sum())));
            id++;
        }

        var country = countryValuesRepository.findAllByOrderByValueAsc().get(0).getCountry().getCountry();
        System.out.println("страна с \"самыми средними показателями\" среди Western Europe и Sub-Saharan Africa - "+country);

    }
}