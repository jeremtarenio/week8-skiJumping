
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jerem
 */
public class TextUserInterface {
    
    private Scanner reader;
    private Tournament tourney;
    
    public TextUserInterface() {
        reader = new Scanner(System.in);
        tourney = new Tournament();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week\n"
                + "\n"
                + "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        while (true) {
            System.out.print("  Participant name: ");
            String ans = reader.nextLine();
            Jumper jumper = new Jumper(ans);
            if (ans.isEmpty()) {
                break;
            } else {
                tourney.addJumper(jumper);
            }
        }
        
        System.out.println("\nThe tournament begins!");
        
        while (true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            String ans2 = reader.nextLine();
            if (ans2.equals("jump")) {
                System.out.println("\nRound " + tourney.getCurrentRound());
                System.out.println("\nJumping order:");
                tourney.printJumpingOrder();
                System.out.println("\nResults of round " + tourney.getCurrentRound());
                tourney.jump();
                tourney.printResults();
            } else {
                System.out.println("\nThanks!");
                System.out.println("\nTournament results:");
                tourney.printVerdict();
                break;
            }
        }
        
    }
}
