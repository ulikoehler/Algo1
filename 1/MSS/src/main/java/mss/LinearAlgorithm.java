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
public class LinearAlgorithm implements MSSAlgorithm {

    @Override
    public MSSResult calculate(ArrayList<Double> data) {
        double maxscore = 0;
        int l = 1;
        int r = 0;
        double rmaxscore = 0;
        int rstart = 1;
        final int n = data.size();
        for (int i = 1; i <= n; i++) {
            if (rmaxscore > 0) {
                rmaxscore += data.get(i - 1);
            } else {
                rmaxscore = data.get(i - 1);
                rstart = i;
            }
            if (rmaxscore > maxscore) {
                maxscore = rmaxscore;
                l = rstart;
                r = i;
            }
        }
        return new MSSResult(l-1, r-1, maxscore);
    }
}
