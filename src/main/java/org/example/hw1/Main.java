package org.example.hw1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String again = "";
        Game game = new Game();

        do {
            game.startGame();
            System.out.println("Выберите одну из дверей (число от 1 до 3): ");

            int firstSelectedDoor = scanner.nextInt();
            if (game.chooseDoor(firstSelectedDoor)){

                int hintDoor = game.giveHint();
                System.out.println("Ведущий открывает дверь №"+(hintDoor+1)+ ". Хотите ли вы изменить свой выбор? Y/N");
                String changeChoice = scanner.next();
                if(changeChoice.equalsIgnoreCase("Y")){
                    game.changeChoice();
                }
                game.openSelectedDoor();

            } else {
                System.out.println("Введенной вами двери не существует");
            }
            System.out.println("Хотите сыграть еще один раз? Y/N");
            again = scanner.next();

        } while(again.equalsIgnoreCase("Y"));

    }
}