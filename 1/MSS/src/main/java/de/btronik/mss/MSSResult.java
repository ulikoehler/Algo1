/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.btronik.mss;

/**
 *
 * @author uli
 */
public class MSSResult {

    public int startIndex;
    public int endIndex;
    public double score;

    public MSSResult(int startIndex, int endIndex, double score) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.score = score;
    }

    /**
     * Create a tab-separated string from this
     */
    public String toString() {
        return Integer.toString(startIndex) + '\t' + endIndex + '\t' + score;
    }
}
