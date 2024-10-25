package org.example;

import org.example.services.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reader reader = new FileReader();
        List<String> attractionList  = reader.readFromFile(Constants.DATA_FILE_PATH);
        float[] hours;
        float[] priorities;

        DataHandler  parser = new StringHandler();
        hours      = parser.getVisitingAttributes(attractionList, Constants.HOUR_SHIFT);
        priorities = parser.getVisitingAttributes(attractionList, Constants.PRIORITY_SHIFT);

        RouteNavigator navigator = new OptimalRouteNavigator(hours, priorities);
        List<Integer> res = navigator.findRoute();

        System.out.println("Оптимальный маршрут для знакомства с Питером:");
        for (Integer index : res){
            System.out.println(attractionList.get(index - 1));
        }

        float tripTime = 0;
        for (Integer time : res){
            tripTime += hours[time - 1];
        }
        System.out.println("\nВесь маршрут займёт столько времени: " + tripTime + " ч.");
        float remainingTime = (float) Constants.TOTAL_REMAINING_HOURS - tripTime;
        System.out.println("У вас ещё останется "+ remainingTime + " ч. Так что можно ещё отдохнуть после прогулки и выпить кофе :)");
    }
}