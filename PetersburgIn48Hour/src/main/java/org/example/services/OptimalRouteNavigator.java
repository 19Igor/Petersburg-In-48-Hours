package org.example.services;

import org.example.Constants;

import java.util.ArrayList;
import java.util.List;

public class OptimalRouteNavigator implements RouteNavigator {
    private final float[] hours;
    private final float[] weights;

    public OptimalRouteNavigator(float[] hours, float[] weights) {
        this.hours = hours;
        this.weights = weights;
    }

    @Override
    public List<Integer> findRoute() {
        // the first index is responsible for landmarks number
        // the second index is responsible for bagpack capacity
        float[][] bestValuesTable = new float[Constants.TOTAL_LANDMARKS + 1][];
        initBestValueTable(bestValuesTable);
        fillBestValuesTable(bestValuesTable);
        List<Integer> result = new ArrayList<>();
        traceResult(bestValuesTable, result, Constants.TOTAL_LANDMARKS, Constants.TOTAL_REMAINING_HOURS);
        return result;
    }

    private void traceResult(float[][] table, List<Integer> res, int curLandmarksWeight, int curRemainTime){
        if (table[curLandmarksWeight][curRemainTime] == 0){
            return;
        }
        if (table[curLandmarksWeight - 1][curRemainTime] == table[curLandmarksWeight][curRemainTime]){
            traceResult(table, res, curLandmarksWeight - 1, curRemainTime);
        }
        else{
            traceResult(table,
                    res,
                    curLandmarksWeight - 1,
                    (int)(curRemainTime - hours[curLandmarksWeight - 1]));
            res.add(0, curLandmarksWeight);
        }
    }

    private void fillBestValuesTable(float[][] table){
        for (int k = 0; k <= Constants.TOTAL_LANDMARKS; k++){
            for (int s = 0; s <= Constants.TOTAL_REMAINING_HOURS; s++){
                if (k == 0 || s == 0){
                    table[k][s] = 0;
                }
                else {
                    if (s >= hours[k - 1]){
                        table[k][s] = Math.max(table[k - 1][s], table[k - 1][(int) (s - hours[k - 1]) + 1] + weights[k - 1]);
                    }
                    else{
                        table[k][s] = table[k - 1][s];
                    }
                }
            }
        }
    }

    private void initBestValueTable(float[][] table){
        for (int i = 0; i < Constants.TOTAL_LANDMARKS + 1; i++){
            table[i] = new float[Constants.TOTAL_REMAINING_HOURS + 1];
        }
    }
}
