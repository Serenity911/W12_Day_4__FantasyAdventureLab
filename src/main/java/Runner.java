import Game.Game;
import Map.Room;
import Treasure.Treasure;
import Treasure.Gem;
import Game.Rules;
import Character.Dwarf;
import Character.Player;
import Character.Wizard;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Rules rules = new Rules();
        Game game = new Game(rules);
        game.initialiseGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        int numberPlayer = scanner.nextInt();
        for (int i = 0; i < numberPlayer ; i++) {
            System.out.println("Player's "+ (i+1) + " name:");
            String name = scanner.next();
            System.out.println("Player's "+ (i+1) + " reply to the following questions with y for yes or n for no");
            boolean charTypeSelected = false;
            while ( charTypeSelected == false) {
                System.out.println("charType Selected : " +charTypeSelected);
                System.out.println("Player "+ name + " would you like to play a Wizard?");
                String answer = scanner.next().toLowerCase();
                System.out.println(answer);
                if (answer.equals("y")) {
                    System.out.println("is it entering the if");
                    Wizard player1 = new Wizard(""+name+"");
                     game.addPlayerToParty(player1);
                    System.out.println("You have create a Wizard called " +name);
                    charTypeSelected = true;
                }
            }
            System.out.println(game.getParty());
        }
    }








}
