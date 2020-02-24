import Game.Game;
import Game.Rules;
import Character.Wizard;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Rules rules = new Rules();
        Game game = new Game(rules);
//        initialise Game
        game.initialiseGame();
//        add players
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players?");
        int numberPlayer = scanner.nextInt();
        for (int i = 0; i < numberPlayer ; i++) {
            System.out.println("Player's "+ (i+1) + " name:");
            String name = scanner.next();
            System.out.println("Player's "+ (i+1) + " reply to the following questions with y for yes or n for no");
            boolean charTypeSelected = false;
            while ( charTypeSelected == false) {
                System.out.println("Player "+ name + " would you like to play a Wizard?");
                String answer = scanner.next().toLowerCase();
                if (answer.equals("y")) {
                    Wizard player1 = new Wizard(""+name+"");
                     game.addPlayerToParty(player1);
                     game.addPlayerToFightingPlayer(player1);
                    System.out.println("You have create a Wizard called " +name);
                    charTypeSelected = true;
                }
            }
            System.out.println("Your party is ready! " + game.getParty());
        }
//        enter room
        game.enterRoom(game.findNextLocation());
        System.out.println("The party enters " + game.getCurrentLocation().getName()+", an " + game.getCurrentLocation().getDescription() );
//        search for enemies
        System.out.println("The party carefully searches for enemies, and finds..." + game.getCurrentLocation().getEnemies().size() + "!");
//        fight enemies
        game.fight();
        System.out.println("The fight was intense...The winner is:");
    }








}
