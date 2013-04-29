/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mss;

import java.util.ArrayList;

/**
 *
 * @author uli
 */
public class NaiveAlgorithm implements MSSAlgorithm {

    @Override
    public MSSResult calculate(ArrayList<Double> data) {
        double maxscore = 0;
        int n = data.size();
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int s = 0;
                for (int k = i; k <= j; k++) {
                    s += data.get(k);
                }
                if (s > maxscore) {
                    maxscore = s;
                    l = i;
                    r = j;
                }
            }
        }
        return new MSSResult(l, r, maxscore);
    }
}