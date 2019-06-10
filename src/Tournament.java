
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jerem
 */
public class Tournament {

    private List<Jumper> jumpers;
    private int currentRound;

    public Tournament() {
        jumpers = new ArrayList<Jumper>();
        currentRound = 1;
    }

    public void addJumper(Jumper jumper) {
        jumpers.add(jumper);
    }

    public void jump() {
        for (Jumper jumper : jumpers) {
            jumper.generateJumpLength();
            jumper.generateVotes();
            jumper.updateTotalPoints();
        }
        currentRound++;
    }

    public void printJumpingOrder() {
        Collections.sort(jumpers);
        int num = 1;

        for (Jumper jumper : jumpers) {
            System.out.println("  " + num++ + ". " + jumper.getName() + " (" + jumper.getTotalPoints() + " points)");
        }
    }

    public void printResults() {
        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName() + "\n    length: " + jumper.getJumpLength() + "\n    judge votes: " + jumper.printVotes());
        }
    }

    public void printVerdict() {
        Collections.sort(jumpers, new SortVerdict());
        int num = 1;
        System.out.println("Position    Name");
        for (Jumper jumper : jumpers) {
            System.out.println(num++ + "           " + jumper.getName() + " (" + jumper.getTotalPoints() + " points)"
                    + "\n            jump lengths: " + jumper.printJumps());
        }

    }
    
    public int getCurrentRound() {
        return currentRound;
    }

}
