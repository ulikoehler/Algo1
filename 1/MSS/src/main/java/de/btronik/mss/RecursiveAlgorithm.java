/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btronik.mss;

import java.util.ArrayList;

/**
 *
 * @author uli
 */
public class RecursiveAlgorithm implements MSSAlgorithm {

    double sigma(int i, int j, ArrayList<Double> data) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return data.get(j - 1); //Index 
        } else {
            int k = i + ((j - i) / 2); //Pivot ~= middle
            return sigma(i, k, data) + sigma(k + 1, j, data);
        }
    }

    @Override
    public MSSResult calculate(ArrayList<Double> data) {
        int n = data.size();
        double maxscore = 0;
        int l = 1;
        int r = 0;
        for (int i = 1; i <= data.size(); i++) {
            for (int j = i; j <= data.size(); j++) {
                double s = sigma(i, j, data);
                if (s > maxscore) {
                    maxscore = s;
                    l = i;
                    r = j;
                }
            }
        }
        return new MSSResult(l - 1, r - 1, maxscore);
    }
}
