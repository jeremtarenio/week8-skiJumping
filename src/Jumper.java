
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jerem
 */
public class Jumper implements Comparable<Jumper> {

    private Random ran;
    private int votes[];
    private int jumpLength;
    private int roundPoints;
    private int totalPoints;
    private String name;
    private ArrayList<Integer> jumps;

    public Jumper(String name) {
        this.name = name;
        votes = new int[5];
        jumpLength = 0;
        roundPoints = 0;
        totalPoints = 0;
        jumps = new ArrayList<Integer>();
        ran = new Random();
    }

    public void generateVotes() {
        for (int i = 0; i < votes.length; i++) {
            votes[i] = generateRandomNumber(10, 20);
        }
    }

    public void generateJumpLength() {
        jumpLength = generateRandomNumber(60, 120);
        jumps.add(jumpLength);
    }

    public String printJumps() {
        String str = "";

        if (jumps.size() > 1) {
            for (int i = 0; i < jumps.size(); i++) {
                if (i != jumps.size() - 1) {
                    str += jumps.get(i) + " m, ";
                } else {
                    str += jumps.get(i) + " m";
                }
            }
        } else {
            return jumps.get(0) + " m";
        }

        return str;
    }

    public String printVotes() {
        String str = "[";

        for (int i = 0; i < votes.length; i++) {
            if (i != votes.length - 1) {
                str += votes[i] + ", ";
            } else {
                str += votes[i];
            }
        }

        str += "]";

        return str;
    }

    public int getRoundPoints() {
        int roundPoint = 0;
        int sortedVotes[] = new int[5];

        for (int i = 0; i < votes.length; i++) { //copy array
            sortedVotes[i] = votes[i];
        }

        Arrays.sort(sortedVotes);
        roundPoint = jumpLength;

        for (int i = 0; i < sortedVotes.length; i++) {
            if (i != 0 && i != sortedVotes.length - 1) { //exclude first and last
                roundPoint += sortedVotes[i];
            }
        }

        return roundPoint;
    }

    public void updateTotalPoints() {
        totalPoints += getRoundPoints();
    }

    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }

    public String getName() {
        return name;
    }

    public int getJumpLength() {
        return jumpLength;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    @Override
    public int compareTo(Jumper jumper) {
        return totalPoints - jumper.getTotalPoints();
    }

    private int generateRandomNumber(int min, int max) {
        return ran.nextInt((max - min) + 1) + min;
    }

}
