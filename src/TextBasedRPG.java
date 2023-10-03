import java.util.Random;
import java.util.Scanner;
public class TextBasedRPG {

    Random r = new Random ();
    Scanner input = new Scanner(System.in);
    int ability;
    int damage, hp, coins, foodHeal;
    int wins;
    String item, food;
    String key;
    String name;

    public void win() {
        System.out.println("");
        System.out.println("Principal:Aagh! you've bested me you child, but you think this is the end? Because it isn't!!");
        System.out.println("Principal:You might have escaped the clutches of my school today, but you'll be back right here by tommorow!");
        System.out.println(name + ": I guess lol... hehe cya tommorow baldie. At least I didn't have to do that big CP test.");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("Clair : phew glad thats over. Hey btw you were pretty cool today <3, we should hang out more some other time.");
        System.out.println("Clair : Now get! Before that megajuul's effects make you into one of the dwellers.");
        System.out.println(name+ ": Wait what!?! AHHHHHHHHHHHHHHHHHHHHH! ;) the end");
        System.out.println(" __      ______  _    _  __            _______ _   _  _ ");
        System.out.println("\\ \\   / / __\\| |  | | \\ \\        / /_   _| \\ | | |");
        System.out.println(" \\ \\_/ / |  | | |  | |  \\ \\  /\\  / / | | |  \\| | |");
        System.out.println("   \\   /| |  | | |  | |   \\ \\/  \\/ /  | | | . `  | |");
        System.out.println("     | | | |__| | |__| |    \\  /\\  /   _| |_| |\\  |_|");
        System.out.println("     |_| \\____/\\____/      \\/  \\/   |_____|_| \\_(_)");
    }

    public void fightPrincipal() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println("                                 / * %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println("Principal: Hm... shouldn't you be in class right now?");
        System.out.println(name + ": I really need to get out of school... and you can't stop me.");
        System.out.println("Principal: Ahaha we'll see");
        System.out.println("");
        int health = hp, principalHp = 1000, cdFood, cdAbility = 1;
        if (!food.equals("")) {
            cdFood = 1;
        } else {
            cdFood = 0;
        }
        do {
            System.out.println("Your health: " + health);
            System.out.println("Janitor Health: " + principalHp);
            System.out.println("What would you like to do?");
            if (cdFood > 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability, food");
            } else if (cdFood == 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability");
            } else if (cdFood > 0 && cdAbility == 0) {
                System.out.println("Choices: attack, food");
            } else {
                System.out.println("Choices: attack");
            }
            String choice = input.next();
            if (choice.equals("attack")) {
                principalHp -= damage;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your " + item + " and dealt " + damage + " damage.");
                System.out.println("");
            } else if (choice.equals("food") && !food.equals("") && cdFood > 0) {
                health += foodHeal;
                cdFood -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You ate your " + food + " and healed " + foodHeal + " hp.");
                System.out.println("");
            } else if (choice.equals("ability") && cdAbility > 0) {
                principalHp -= ability;
                cdAbility -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your ability and dealt " + ability + " damage.");
                System.out.println("");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You messed up and missed your turn!");
                System.out.println("");
            }
            if (principalHp <= 0) {
                win();
            } else if (principalHp > 0) {
                int principalDamage = r.nextInt(101) + 200;
                System.out.println("The principal dealt " + principalDamage + " damage to you!");
                System.out.println("");
                health -= principalDamage;
            }
            if (health <= 0) {
                System.out.println("Your plan to skip the day has been absolutely ruined...");
                System.out.println("You died.");
                System.out.println("");
                System.out.println("Would you like to play again?");
                String Choice = input.next();
                if (Choice.equals("yes")) {
                    start();
                }
            }
        } while (principalHp > 0 &&  health > 0);


    }

    public void inOffice() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println("  *                              /   %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println("Choices: east, west");
        String move = input.next();
        if (move.equals("east")) {
            principal();
        } else if (move.equals("west")) {
            office();
        } else {
            inOffice();
        }
    }

    public void principal() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println("                                */   %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println("Choices: enter, west");
        String move = input.next();
        if (move.equals("west")) {
            inOffice();
        } else if (move.equals("enter")) {
            fightPrincipal();
        } else {
            principal();
        }
    }

    public void beatTeacher() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println("                        *        /   %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println(name + ": phew! ok... now here comes the real deal...");
        System.out.println("");
        System.out.println("Choices: back, east");
        String move = input.next();
        if (move.equals("back")) {
            office();
        } else if (move.equals("east")) {
            principal();
        } else {
            beatTeacher();
        }
    }

    public void fightTeacher() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println("                    *   $        /   %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println(name + ": I'm really sorry... but I can't afford to fail another class!");
        System.out.println("");
        int health = hp, teacherHp = 250, cdFood, cdAbility = 1;
        if (!food.equals("")) {
            cdFood = 1;
        } else {
            cdFood = 0;
        }
        do {
            System.out.println("Your health: " + health);
            System.out.println("Teacher Health: " + teacherHp);
            System.out.println("What would you like to do?");
            if (cdFood > 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability, food");
            } else if (cdFood == 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability");
            } else if (cdFood > 0 && cdAbility == 0) {
                System.out.println("Choices: attack, food");
            } else {
                System.out.println("Choices: attack");
            }
            String choice = input.next();
            if (choice.equals("attack")) {
                teacherHp -= damage;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your " + item + " and dealt " + damage + " damage.");
                System.out.println("");
            } else if (choice.equals("food") && !food.equals("") && cdFood > 0) {
                health += foodHeal;
                cdFood -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You ate your " + food + " and healed " + foodHeal + " hp.");
                System.out.println("");
            } else if (choice.equals("ability") && cdAbility > 0) {
                teacherHp -= ability;
                cdAbility -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your ability and dealt " + ability + " damage.");
                System.out.println("");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You messed up and missed your turn!");
                System.out.println("");
            }
            if (teacherHp <= 0) {
                coins += 1000;
                wins += 1;
                System.out.println("You won.");
                System.out.println("You gained 1000 coins.");
                System.out.println("");
                System.out.println("Choices: back");
                choice = input.next();
                beatTeacher();
            } else if (teacherHp > 0) {
                int teacherDamage = r.nextInt(11) + 50;
                System.out.println("The Teacher dealt " + teacherDamage + " damage to you!");
                System.out.println("");
                health -= teacherDamage;
            }
            if (health <= 0) {
                System.out.println("Your mission to get out of school failed.");
                System.out.println("Big F.");
                System.out.println("");
                System.out.println("Would you like to play again?");
                String Choice = input.next();
                if (Choice.equals("yes")) {
                    start();
                }
            }
        } while (teacherHp > 0 &&  health > 0);
    }

    public void teacher() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println("                    *   $        /   %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println("Teacher: Hey! how did you get in here?? get back to class!");
        System.out.println("");
        System.out.println("Choices: fight, flee");
        String move = input.next();
        if (move.equals("fight")) {
            fightTeacher();
        } else if (move.equals("flee")) {
            enterOffice();
        } else {
            teacher();
        }
    }

    public void beatJanitor() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|      * &                                |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("Janitor: Aaahhh! I'm sorry. Here's your key...");
        System.out.println("");
        System.out.println("text from Claire: 'You got the key! now go to the office and show them who's the boss!'");
        System.out.println("");
        System.out.println("Choices: north, east");
        String move = input.next();
        if (move.equals("north")) {
            enterCommons();
        } else if (move.equals("east")) {
            downCommons();
        } else {
            beatJanitor();
        }
    }

    public void fightJanitor() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|      * &                                |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println(name +": I'm sorry... but i'm gonna need to steal that key of yours!");
        System.out.println("");
        int health = hp, janitorHp = 200, cdFood, cdAbility = 1;
        if (!food.equals("")) {
            cdFood = 1;
        } else {
            cdFood = 0;
        }
        do {
            System.out.println("Your health: " + health);
            System.out.println("Janitor Health: " + janitorHp);
            System.out.println("What would you like to do?");
            if (cdFood > 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability, food");
            } else if (cdFood == 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability");
            } else if (cdFood > 0 && cdAbility == 0) {
                System.out.println("Choices: attack, food");
            } else {
                System.out.println("Choices: attack");
            }
            String choice = input.next();
            if (choice.equals("attack")) {
                janitorHp -= damage;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your " + item + " and dealt " + damage + " damage.");
                System.out.println("");
            } else if (choice.equals("food") && !food.equals("") && cdFood > 0) {
                health += foodHeal;
                cdFood -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You ate your " + food + " and healed " + foodHeal + " hp.");
                System.out.println("");
            } else if (choice.equals("ability") && cdAbility > 0) {
                janitorHp -= ability;
                cdAbility -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your ability and dealt " + ability + " damage.");
                System.out.println("");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You messed up and missed your turn!");
                System.out.println("");
            }
            if (janitorHp <= 0) {
                coins += 300;
                wins += 1;
                key = "key";
                System.out.println("You won.");
                System.out.println("You gained 500 coins.");
                System.out.println("");
                System.out.println("Choices: back");
                choice = input.next();
                beatJanitor();
            } else if (janitorHp > 0) {
                int janitorDamage = r.nextInt(6) + 27;
                System.out.println("The janitor used his mop and dealt " + janitorDamage + " damage to you!");
                System.out.println("");
                health -= janitorDamage;
            }
            if (health <= 0) {
                System.out.println("The Janitor was too strong...");
                System.out.println("You died.");
                System.out.println("");
                System.out.println("Would you like to play again?");
                String Choice = input.next();
                if (Choice.equals("yes")) {
                    start();
                }
            }
        } while (janitorHp > 0 &&  health > 0);

    }

    public void janitor() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|      * &                                |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("Janitor: Another depressing day in school...");
        System.out.println("");
        if (wins == 3) {
            System.out.println("Choices: fight, north, east");
            String move = input.next();
            if (move.equals("fight")) {
                fightJanitor();
            } else if (move.equals("north")) {
                enterCommons();
            } else if (move.equals("east")) {
                downCommons();
            } else {
                janitor();
            }
        } else if (wins != 3) {
            System.out.println("Choices: north, east");
            String move = input.next();
            if (move.equals("north")) {
                enterCommons();
            } else if (move.equals("east")) {
                downCommons();
            } else {
                janitor();
            }
        }
    }

    public void beatHoopers() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("GYM");
        System.out.println("   _____       |__                                                   __|              current item: " + item);
        System.out.println("	|     /vv`                                                  vv`\\              hp: " + hp);
        System.out.println("	|     |                                                        |              damage: " + damage);
        System.out.println("	|     |                                                        |              coins: " + coins);
        System.out.println("	|     |                                                        |");
        System.out.println("        |     |                                                        |");
        System.out.println("	/_____|____________________*___________________________________|");
        System.out.println(name + ": I be ballin like curry, cause this is too ez...");
        System.out.println("");
        System.out.println("text from Claire: 'Hey " + name + ", I think you are strong enough to get out of the school now.");
        System.out.println("You'll be able to get out of here through the office. You are going to need the key though,");
        System.out.println("since it's always locked. Go find the janitor, he has the key.");
        System.out.println("");
        System.out.println("Choices: back");
        String move = input.next();
        if (move.equals("back")) {
            gym();
        } else {
            beatHoopers();
        }
    }

    public void enterCafe() {
        int friesCost = 50, cookiesCost = 75, burgerCost = 100, chickenCost = 200,  saladCost = 300, pretzelCost = 500;
        String buy;
        System.out.println("-------------------------------------------------------");
        System.out.println("CAFETERIA");
        System.out.println("_____________");
        System.out.println("|' , ;` .,~ |");
        System.out.println("| `         |");
        System.out.println("|     *     |");
        System.out.println("");
        System.out.println("Welcome to the cafeteria! which food would you like to buy?");
        do {
            System.out.println("");
            System.out.println("Coins: " + coins);
            System.out.println("");
            System.out.println("fries : 50 coins : heal 30hp");
            System.out.println("cookies : 75 coins : heal 40hp");
            System.out.println("burger : 100 coins : heal 45hp");
            System.out.println("chickenWrap : 200 coins : heal 60 hp");
            System.out.println("salad : 300 coins : heal 80 hp");
            System.out.println("ExpiredPretzel : 500 coins : heal 100 hp");
            System.out.println("");
            System.out.println("Type an item you'd like to buy, or press e to exit.");
            buy = input.next();
            if (buy.equals("e")) { //exit
                System.out.println("-------------------------------------------------------");
                System.out.println("You exited the shop.");
                cafeteria();
            } else if (buy.equalsIgnoreCase("fries") && coins >= friesCost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You bought fries! heals you for 30 hp.");
                System.out.println(" -50 coins");
                foodHeal = 30;
                food = "Fries";
                coins -= friesCost;
            } else if (buy.equalsIgnoreCase("cookies") && coins >= cookiesCost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You bought cookies! heals you for 40 hp.");
                System.out.println(" -75 coins");
                foodHeal = 40;
                food = "Cookies";
                coins -= cookiesCost;
            } else if (buy.equalsIgnoreCase("burger") && coins >= burgerCost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You bought a burger. heals you for 45 hp.");
                System.out.println(" -100 coins");
                foodHeal = 45;
                food = "Burger";
                coins -= burgerCost;
            } else if (buy.equalsIgnoreCase("chickenwrap") && coins >= chickenCost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You bought a delicious chicken wrap. It heals you for 60 hp.");
                System.out.println(" -200 coins");
                foodHeal = 60;
                food = "Chicken wrap";
                coins -= chickenCost;
            } else if (buy.equalsIgnoreCase("salad") && coins >= saladCost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You bought the salad. It heals you for 80 hp");
                System.out.println(" -300 coins");
                foodHeal = 80;
                food = "Salad";
                coins -= saladCost;
            } else if (buy.equalsIgnoreCase("ExpiredPretzel") && coins >= pretzelCost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You bought the best food we can serve, the expired pretzel!");
                System.out.println(" -500 coins");
                foodHeal = 100;
                food = "Expired Pretzel";
                coins -= pretzelCost;
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You don't have enough coins, or you misspelled.");
            }

        } while (!buy.equals("e"));
    }

    public void shop() {
        int stickcost = 50, guncost = 100, pencilcost = 100, coinshoodie = 200, coinskeychain = 200, slingcost = 600, juulcost = 1000;
        String buy;
        System.out.println("-------------------------------------------------------");
        System.out.println("SHADE STORE");
        System.out.println(" _     _");
        System.out.println("|   *   |");
        System.out.println("|       |");
        System.out.println("|   $   |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|______ |");
        System.out.println("Shady guy: uh suh dude what can i get for you ma boi");
        if (damage == 20) {
            System.out.println("Shady guy: btw bruh i gatta tell you that you can only have one item at a time.");
            System.out.println("Shady guy: so the last thing you buy will be whats ya ganna haaaaave...");
        }
        do {
            System.out.println("");
            System.out.println("Coins: " + coins);
            System.out.println("");
            System.out.println("MeterStickv2 : 50 coins : 30 damage");
            System.out.println("rubberGun : 100 coins : 35 damage, 110 hp");
            System.out.println("sharpenedPencil : 100 coins : 40 damage");
            System.out.println("hoodie : 200 coins : 30 damage, 150 hp");
            System.out.println("keychain : 200 coins : 40 damage, 120 hp");
            System.out.println("slingSpit : 600 coins : 70 damage, 200 hp");
            System.out.println("megaJuul : 1000 coins : ???");
            System.out.println("");
            System.out.println("Type an item you'd like to buy, or press e to exit.");
            buy = input.next();
            if (buy.equals("e")) { //exit
                System.out.println("-------------------------------------------------------");
                System.out.println("You exited the shop.");
                shadeStore();
            } else if (buy.equalsIgnoreCase("MeterStickv2") && coins >= stickcost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the Meter Stick v2! A slightly better version that the regular meterstick. ");
                System.out.println(" -50 coins");
                damage = 30;
                ability = r.nextInt(11) + 25;
                item = "MeterStickv2";
                coins -= stickcost;
            } else if (buy.equalsIgnoreCase("rubbergun") && coins >= guncost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the Rubber gun! This bad boi rips rubber bands at people so hard it can be considered a weapon. ");
                System.out.println(" -100 coins");
                damage = 35;
                ability = r.nextInt(11) + 30;
                hp = 110;
                item = "Rubber Gun";
                coins -= guncost;
            } else if (buy.equalsIgnoreCase("sharpenedPencil") && coins >= pencilcost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the sharpedned pencil. I mean i think you know the damage this can do.");
                System.out.println(" -100 coins");
                hp = 100;
                damage = 40;
                ability = r.nextInt(11) + 40;
                item = "Sharpened Pencil";
                coins -= pencilcost;
            } else if (buy.equalsIgnoreCase("hoodie") && coins >= coinshoodie) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the Terry Fox hoodie. Keeps you warmer and healthier.");
                System.out.println(" -200 coins");
                damage = 25;
                ability = r.nextInt(11) + 25;
                hp = 150;
                item = "Hoodie";
                coins -= coinshoodie;
            } else if (buy.equalsIgnoreCase("keychain") && coins >= coinskeychain) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the Terry Fox keychain. The ultimate status check, will give you a boost of life.");
                System.out.println(" -200 coins");
                damage = 40;
                ability = r.nextInt(11) + 35;
                hp = 120;
                item = "Keycahin";
                coins -= coinskeychain;
            } else if (buy.equalsIgnoreCase("slingSpit") && coins >= slingcost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the Sling Spit! Pew pew !!!!!");
                System.out.println(" -400 coins");
                damage = 70;
                ability = r.nextInt(16) + 40;
                hp = 200;
                item = "SlingSpit";
                coins -= slingcost;
            } else if (buy.equalsIgnoreCase("megajuul") && coins >= juulcost) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You have bought the finale, the ripper, the one the only, MEGAJUUL!");
                System.out.println(" -1000 coins");
                damage =  r.nextInt(101) + 200;
                ability = r.nextInt(101) + 200;
                hp = 1000;
                item = "MEGA JUUL";
                coins -= juulcost;
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You don't have enough coins, or you misspelled.");
            }

        } while (!buy.equals("e"));

    }

    public void shadeStore() {
        System.out.println("-------------------------------------------------------");
        System.out.println("HALLWAY");
        System.out.println("______    _______");
        System.out.println("|    \\   /      |              current item: " + item);
        System.out.println("|               |              hp: " + hp);
        System.out.println("|               |              damage: " + damage);
        System.out.println("|               |              coins: " + coins);
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               | ");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|       *       |");
        System.out.println("|_____/  \\______|");
        System.out.println("");
        System.out.println("Choices: shop, north");
        String move = input.next();
        if (move.equals("north")) {
            inHallway();
        } else if (move.equals("shop")) {
            shop();
        } else {
            shadeStore();
        }

    }

    public void inBathroom() {
        System.out.println("-------------------------------------------------------");
        System.out.println("BATHROOM");
        System.out.println("    __________|    |________");
        System.out.println("    |        \\  *     |  & |              current item: " + item);
        System.out.println("    |                 |_&__|              hp: " + hp);
        System.out.println("    |                \\     |              damage: " + damage);
        System.out.println("    |                 |____|              coins: " + coins);
        System.out.println("    |  _   _   _     \\     | ");
        System.out.println("    |_[_]_[_]_[_]_____|____|");
        System.out.println("");
        System.out.println("Choices: north");
        String move = input.next();
        if (move.equals("north")) {
            bathroom();
        } else {
            inBathroom();
        }
    }

    public void inHallway() {
        System.out.println("-------------------------------------------------------");
        System.out.println("HALLWAY");
        System.out.println("______    _______");
        System.out.println("|    \\   /      |              current item: " + item);
        System.out.println("|       *       |              hp: " + hp);
        System.out.println("|               |              damage: " + damage);
        System.out.println("|               |              coins: " + coins);
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               | ");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|_____/  \\______|");
        System.out.println("");
        System.out.println("Choices: south, back");
        String move = input.next();
        if (move.equals("back")) {
            hallway();
        } else if (move.equals("south")) {
            shadeStore();
        } else {
            inHallway();
        }
    }

    public void beatDwellers() {
        System.out.println("-------------------------------------------------------");
        System.out.println("BATHROOM");
        System.out.println("    __________|    |________");
        System.out.println("    |        \\  *     |  & |              current item: " + item);
        System.out.println("    |                 |_&__|              hp: " + hp);
        System.out.println("    |                \\     |              damage: " + damage);
        System.out.println("    |                 |____|              coins: " + coins);
        System.out.println("    |  _   _   _     \\     | ");
        System.out.println("    |_[_]_[_]_[_]_____|____|");
        System.out.println("");
        System.out.println(name + ": Damn I'm not gonna lie those juuls were pretty fire.");
        System.out.println("");
        System.out.println("text from Claire: Good job you beat those nasty dwellers! I recommend you fight");
        System.out.println("the hoopers in the gym next, they'll give you lots of coins...");
        System.out.println("");
        System.out.println("Choices: north");
        String move = input.next();
        if (move.equals("north")) {
            bathroom();
        } else {
            beatDwellers();
        }
    }

    public void beatSoiBois() {
        System.out.println("-------------------------------------------------------");
        System.out.println("HALLWAY");
        System.out.println("______    _______");
        System.out.println("|    \\   /      |              current item: " + item);
        System.out.println("|               |              hp: " + hp);
        System.out.println("|               |              damage: " + damage);
        System.out.println("|               |              coins: " + coins);
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|       *       |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               | ");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|_____/  \\______|");
        System.out.println(name + ": EZ dubs.");
        System.out.println("");
        System.out.println("text from Claire: 'Hey " + name + ", good job on beating the SoiBois! now that you have some");
        System.out.println("coins, go buy some better items in the shade store. After that, keep fighting enemies so");
        System.out.println("you can get better items! you can also get foods that will heal you in the cafetera.");
        System.out.println("");
        System.out.println("Choices: south, north");
        String move = input.next();
        if (move.equals("north")) {
            inHallway();
        } else if (move.equals("south")) {
            shadeStore();
        } else {
            beatSoiBois();
        }
    }

    public void fightHoopers() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("GYM");
        System.out.println("   _____       |__                                                   __|              current item: " + item);
        System.out.println("	|     /vv`                                                  vv`\\              hp: " + hp);
        System.out.println("	|     |                                                        |              damage: " + damage);
        System.out.println("	|     |                                                        |              coins: " + coins);
        System.out.println("	|     |                                                        |");
        System.out.println("        |     |                         >         >                    |");
        System.out.println("	/_____|____________________*__>_>______>_______________________|");
        System.out.println(name + ": ok buddy I'm finna sauce you wnba kids real good...");
        System.out.println("");
        int health = hp, hoopersHp = 75, cdFood, cdAbility = 1;
        if (!food.equals("")) {
            cdFood = 1;
        } else {
            cdFood = 0;
        }
        do {
            System.out.println("Your health: " + health);
            System.out.println("Hoopers Health: " + hoopersHp);
            System.out.println("What would you like to do?");
            if (cdFood > 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability, food");
            } else if (cdFood == 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability");
            } else if (cdFood > 0 && cdAbility == 0) {
                System.out.println("Choices: attack, food");
            } else {
                System.out.println("Choices: attack");
            }
            String choice = input.next();
            if (choice.equals("attack")) {
                hoopersHp -= damage;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your " + item + " and dealt " + damage + " damage.");
                System.out.println("");
            } else if (choice.equals("food") && !food.equals("") && cdFood > 0) {
                health += foodHeal;
                cdFood -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You ate your " + food + " and healed " + foodHeal + " hp.");
                System.out.println("");
            } else if (choice.equals("ability") && cdAbility > 0) {
                hoopersHp -= ability;
                cdAbility -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your ability and dealt " + ability + " damage.");
                System.out.println("");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You messed up and missed your turn!");
                System.out.println("");
            }
            if (hoopersHp <= 0) {
                coins += 450;
                wins += 1;
                System.out.println("You won.");
                System.out.println("You gained 450 coins.");
                System.out.println("");
                System.out.println("Choices: back");
                choice = input.next();
                beatHoopers();
            } else if (hoopersHp > 0) {
                int hoopersDamage = r.nextInt(26) + 45;
                System.out.println("The Hoopers crossed your ankles up and dealt " + hoopersDamage + " damage to you!");
                System.out.println("");
                health -= hoopersDamage;
            }
            if (health <= 0) {
                System.out.println("The Hoopers swag was to much...");
                System.out.println("You died.");
                System.out.println("");
                System.out.println("Would you like to play again?");
                String Choice = input.next();
                if (Choice.equals("yes")) {
                    start();
                }
            }
        } while (hoopersHp > 0 &&  health > 0);
    }

    public void hoopers() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("GYM");
        System.out.println("   _____       |__                                                   __|              current item: " + item);
        System.out.println("	|     /vv`                                                  vv`\\              hp: " + hp);
        System.out.println("	|     |                                                        |              damage: " + damage);
        System.out.println("	|     |                                                        |              coins: " + coins);
        System.out.println("	|     |                                                        |");
        System.out.println("        |     |                         >         >                    |");
        System.out.println("	/_____|____________________*__>_>______>_______________________|");
        System.out.println("Hooper1: Yo watch me do this 360 self alley oop behind the back windmill dunk rn!");
        System.out.println("Fails*");
        System.out.println("Hooper2: This dude can't jump if his life depended on it, garbage! lmoa.");
        System.out.println("Hooper3: Ayee is this kid a new challenger or something? No way you could beat us.");
        System.out.println("");
        System.out.println("Choices: fight, flee");
        String move = input.next();
        if (move.equals("fight")) {
            fightHoopers();
        } else if (move.equals("flee")) {
            enterGym();
        } else {
            hoopers();
        }
    }

    public void fightBathroom() {
        System.out.println("-------------------------------------------------------");
        System.out.println("BATHROOM");
        System.out.println("    __________|    |________");
        System.out.println("    |        \\  *     |  & |              current item: " + item);
        System.out.println("    |                 |_&__|              hp: " + hp);
        System.out.println("    |      & &       \\     |              damage: " + damage);
        System.out.println("    |    & &  &       |____|              coins: " + coins);
        System.out.println("    |  _   _   _     \\     | ");
        System.out.println("    |_[_]_[_]_[_]_____|____|");
        System.out.println("");
        System.out.println(name + ": Yikes. Looks like I got some cleaning to do in this bathroom!");
        System.out.println("");
        int health = hp, dwellersHp = 150, cdFood, cdAbility = 1;
        if (!food.equals("")) {
            cdFood = 1;
        } else {
            cdFood = 0;
        }
        do {
            System.out.println("Your health: " + health);
            System.out.println("Dwellers Health: " + dwellersHp);
            System.out.println("What would you like to do?");
            if (cdFood > 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability, food");
            } else if (cdFood == 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability");
            } else if (cdFood > 0 && cdAbility == 0) {
                System.out.println("Choices: attack, food");
            } else {
                System.out.println("Choices: attack");
            }
            String choice = input.next();
            if (choice.equals("attack")) {
                dwellersHp -= damage;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your " + item + " and dealt " + damage + " damage.");
                System.out.println("");
            } else if (choice.equals("food") && !food.equals("") && cdFood > 0) {
                health += foodHeal;
                cdFood -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You ate your " + food + " and healed " + foodHeal + " hp.");
                System.out.println("");
            } else if (choice.equals("ability") && cdAbility > 0) {
                dwellersHp -= ability;
                cdAbility -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your ability and dealt " + ability + " damage.");
                System.out.println("");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You messed up and missed your turn!");
                System.out.println("");
            }

            if (dwellersHp <= 0) {
                wins += 1;
                coins += 300;
                System.out.println("You won.");
                System.out.println("You gained 200 coins.");
                System.out.println("");
                System.out.println("Choices: back");
                choice = input.next();
                beatDwellers();
            } else if (dwellersHp > 0) {
                int soiBoiDamage = r.nextInt(11) + 20;
                System.out.println("The Bathroom dwellers used their 'fire' juuls and dealt " + soiBoiDamage + " damage to you.");
                System.out.println("");
                health -= soiBoiDamage;
            }
            if (health <= 0) {
                System.out.println("The Bathroom Dweller's vape gas was too strong...");
                System.out.println("You died.");
                System.out.println("");
                System.out.println("Would you like to play again?");
                String yeah = input.next();
                if (yeah.equals("yes")) {
                    start();
                }

            }
        } while (dwellersHp > 0 &&  health > 0);

    }

    public void fightSoiBois() {
        System.out.println("-------------------------------------------------------");
        System.out.println("HALLWAY");
        System.out.println("______    _______");
        System.out.println("|    \\   /      |              current item: " + item);
        System.out.println("|               |              hp: " + hp);
        System.out.println("|               |              damage: " + damage);
        System.out.println("|               |              coins: " + coins);
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|        *      |");
        System.out.println("|          @    |");
        System.out.println("|    @ @    @   |");
        System.out.println("|       @       |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               | ");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|_____/  \\______|");
        System.out.println(name +": Fine by me, I can take on an army of you perm loving, oversized shirt wearing, math failing kids anyday.");
        System.out.println("");
        int health = hp, soiBoiHp = 100, cdFood, cdAbility = 1;
        if (!food.equals("")) {
            cdFood = 1;
        } else {
            cdFood = 0;
        }
        do {
            System.out.println("Your health: " + health);
            System.out.println("SoiBoi Health: " + soiBoiHp);
            System.out.println("What would you like to do?");
            if (cdFood > 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability, food");
            } else if (cdFood == 0 && cdAbility > 0) {
                System.out.println("Choices: attack, ability");
            } else if (cdFood > 0 && cdAbility == 0) {
                System.out.println("Choices: attack, food");
            } else {
                System.out.println("Choices: attack");
            }
            String choice = input.next();
            if (choice.equals("attack")) {
                soiBoiHp -= damage;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your " + item + " and dealt " + damage + " damage.");
                System.out.println("");
            } else if (choice.equals("food") && !food.equals("") && cdFood > 0) {
                health += foodHeal;
                cdFood -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You ate your " + food + " and healed " + foodHeal + " hp.");
                System.out.println("");
            } else if (choice.equals("ability") && cdAbility > 0) {
                soiBoiHp -= ability;
                cdAbility -= 1;
                System.out.println("-------------------------------------------------------");
                System.out.println("You used your ability and dealt " + ability + " damage.");
                System.out.println("");
            } else {
                System.out.println("-------------------------------------------------------");
                System.out.println("You messed up and missed your turn!");
                System.out.println("");
            }

            if (soiBoiHp <= 0) {
                coins += 100;
                wins += 1;
                System.out.println("You won.");
                System.out.println("You gained 100 coins.");
                System.out.println("");
                System.out.println("Choices: back");
                choice = input.next();
                beatSoiBois();
            } else if (soiBoiHp > 0) {
                int soiBoiDamage = r.nextInt(21) + 10;
                System.out.println("The SoiBois dealt " + soiBoiDamage + " damage to you.");
                System.out.println("");
                health -= soiBoiDamage;
            }
            if (health <= 0) {
                System.out.println("The SoiBois were too strong...");
                System.out.println("You died.");
                System.out.println("");
                System.out.println("Would you like to play again?");
                String Choice = input.next();
                if (Choice.equals("yes")) {
                    start();
                }
            }
        } while (soiBoiHp > 0 &&  health > 0);
    }

    public void soiBois() {
        System.out.println("-------------------------------------------------------");
        System.out.println("HALLWAY");
        System.out.println("______    _______");
        System.out.println("|    \\   /      |              current item: " + item);
        System.out.println("|               |              hp: " + hp);
        System.out.println("|               |              damage: " + damage);
        System.out.println("|               |              coins: " + coins);
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|        *      |");
        System.out.println("|          @    |");
        System.out.println("|    @ @    @   |");
        System.out.println("|       @       |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               | ");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|_____/  \\______|");
        System.out.println("Soiboi leader: woah woah, where does this KID think he's going.");
        System.out.println("Soiboi1: Yea bro no cap, that was disrespectful how he didn't give us lunch money aha.");
        System.out.println("Soiboi2: You got to get passed us if you wanna get to the shade store in the back of the school!");
        System.out.println("");
        System.out.println("Choices: fight, flee");
        String move = input.next();
        if (move.equals("fight")) {
            fightSoiBois();
        } else if (move.equals("flee")) {
            System.out.println(name + ": Alright, I'm not looking for any trouble atm.");
            enterHallway();
        } else {
            soiBois();
        }
    }

    public void enterOffice() {
        System.out.println("-------------------------------------------------------");
        System.out.println("OFFICE");
        System.out.println("                 ____________________________");
        System.out.println("                 |               |          |              current item: " + item);
        System.out.println("_________________|               |          |\\             hp: " + hp);
        System.out.println("/                                |    %       |            damage: " + damage);
        System.out.println(" *                      $        |   %?%      |            coins: " + coins);
        System.out.println("\\________________                |    %     |/");
        System.out.println("                  |              |          |           ");
        System.out.println("                  |______________|__________|");
        System.out.println("");
        System.out.println("Choices: east, back");
        String move = input.next();
        if (move.equals("east")) {
            teacher();
        } else if (move.equals("back")) {
            office();
        } else {
            enterOffice();
        }
    }

    public void enterGym() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("GYM");
        System.out.println("   _____       |__                                                   __|              current item: " + item);
        System.out.println("	|     /vv`                                                  vv`\\              hp: " + hp);
        System.out.println("	|     |                                                        |              damage: " + damage);
        System.out.println("	|     |                                                        |              coins: \" + coins");
        System.out.println("	|     |                                                        |");
        System.out.println("        |     |                         >         >                    |");
        System.out.println("	/_*___|_______________________>_>______>_______________________|");
        System.out.println("");
        System.out.println("Choices: east, back");
        String move = input.next();
        if (move.equals("east")) {
            hoopers();
        } else if (move.equals("back")) {
            gym();
        } else {
            enterGym();
        }
    }

    public void enterBathroom() {
        System.out.println("-------------------------------------------------------");
        System.out.println("BATHROOM");
        System.out.println("    __________|    |________");
        System.out.println("    |        \\  *     |  & |              current item: " + item);
        System.out.println("    |                 |_&__|              hp: " + hp);
        System.out.println("    |      & &       \\     |              damage: " + damage);
        System.out.println("    |    & &  &       |____|              coins: " + coins);
        System.out.println("    |  _   _   _     \\     | ");
        System.out.println("    |_[_]_[_]_[_]_____|____|");
        System.out.println("");
        System.out.println("Dweller1: Yo bro check out this mad litty fire mod I just got for my pod aha.");
        System.out.println("Dweller2: Bro thats sick... how much that thing hold??!");
        System.out.println("Dweller1: I don't know man, enough to make my parents even more disapointed aha");
        System.out.println("Dweller3: Slurps vape* Hey bois seems like we got some company... kid, you should know this is our turf to skip on.");
        System.out.println("");
        System.out.println("Choices: fight, flee");
        String move = input.next();
        if (move.equals("fight")) {
            fightBathroom();
        } else if (move.equals("flee")) {
            System.out.println(name + ": Nevermind I'll just find another washroom I guess");
            bathroom();
        } else {
            enterBathroom();
        }
    }

    public void enterHallway() {
        System.out.println("-------------------------------------------------------");
        System.out.println("HALLWAY");
        System.out.println("______    _______");
        System.out.println("|    \\   /      |              current item: " + item);
        System.out.println("|               |              hp: " + hp);
        System.out.println("|       *       |              damage: " + damage);
        System.out.println("|               |              coins: " + coins);
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|          @    |");
        System.out.println("|    @ @    @   |");
        System.out.println("|       @       |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               | ");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|               |");
        System.out.println("|_____/  \\______|");
        System.out.println("");
        System.out.println("Choices: south, back");
        String move = input.next();
        if (move.equals("back")) {
            hallway();
        } else if (move.equals("south")) {
            soiBois();
        } else {
            enterHallway();
        }
    }

    public void cornerCommons() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage : " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |              coins: " + coins);
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                          *      |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: bathroom, north, west");
        String move = input.next();
        if (move.equals("bathroom")) {
            bathroom();
        } else if (move.equals("north")) {
            office();
        } else if (move.equals("west")) {
            downCommons();
        } else {
            cornerCommons();
        }
    }

    public void bathroom() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                          *              |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: enter, north");
        String move = input.next();
        if (move.equals("enter") && wins <= 1) {
            enterBathroom();
        } else if (move.equals("enter") && wins >= 2) {
            inBathroom();
        } else if (move.equals("north")) {
            downCommons();
        } else {
            bathroom();
        }
    }

    public void hallway() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|           *                             |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: enter, north");
        String move = input.next();
        if (move.equals("enter") && wins == 0) {
            enterHallway();
        } else if (move.equals("enter") && wins > 0) {
            inHallway();
        } else if (move.equals("north")) {
            downCommons();
        } else {
            hallway();
        }
    }

    public void locked() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                 * ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println(name + ": It's locked. I need  key to get in");
        System.out.println("");
        System.out.println("Choices: enter, west, south, north");
        String move = input.next();
        if (move.equals("enter") && key.equals("key")) {
            enterOffice();
        } else if (move.equals("enter") &&!key.equals("key")) {
            locked();
        } else if (move.equals("west")) {
            centerCommons();
        } else if (move.equals("south")) {
            cornerCommons();
        } else if (move.equals("north")) {
            gym();
        } else {
            office();
        }
    }

    public void office() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                 * ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: enter, west, south, north");
        String move = input.next();
        if (move.equals("enter") && key.equals("key") && wins <= 4) {
            enterOffice();
        } else if (move.equals("enter") && key.equals("key") && wins >= 5) {
            inOffice();
        } else if (move.equals("enter")) {
            locked();
        } else if (move.equals("west")) {
            centerCommons();
        } else if (move.equals("south")) {
            cornerCommons();
        } else if (move.equals("north")) {
            gym();
        } else {
            office();
        }
    }

    public void downCommons() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &          *                      |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: hallway, bathroom, north, west, east");
        String move = input.next();
        if (move.equals("hallway")) {
            hallway();
        } else if (move.equals("bathroom")) {
            bathroom();
        } else if (move.equals("north")) {
            centerCommons();
        } else if (move.equals("west")) {
            southCommons();
        } else if (move.equals("east")) {
            cornerCommons();
        } else {
            downCommons();
        }
    }

    public void gym() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\       * /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: enter, west, south");
        String move = input.next();
        if (move.equals("enter") && wins <= 2) {
            enterGym();
        }else if (move.equals("enter") && wins >= 3) {
            beatHoopers();
        } else if (move.equals("west")) {
            cafeteria();
        } else if (move.equals("south")) {
            office();
        } else {
            gym();
        }

    }

    public void cafeteria() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                     *                   |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: enter, east, south, west");
        String move = input.next();
        if (move.equals("enter")) {
            enterCafe();
        } else if (move.equals("east")) {
            gym();
        } else if (move.equals("south")) {
            centerCommons();
        } else if (move.equals("west")) {
            northCommons();
        } else {
            cafeteria();
        }

    }

    public void centerCommons() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                     *                   /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: north, south, east, west");
        String move = input.next();
        if (move.equals("north")) {
            cafeteria();
        } else if (move.equals("west")) {
            enterCommons();
        } else if (move.equals("east")) {
            office();
        } else if (move.equals("south")) {
            downCommons();
        } else {
            centerCommons();
        }
    }

    public void southCommons() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|   *   &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: janitor, east, north");
        String move = input.next();
        if (move.equals("janitor")) {
            janitor();
        } else if (move.equals("east")) {
            downCommons();
        } else if (move.equals("north")) {
            enterCommons();
        } else {
            southCommons();
        }
    }

    public void doorTeacher() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/ *                                       |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("Teacher: Shouldn't you be in class right now?");
        System.out.println("");
        System.out.println("Choices: east, south");
        String move = input.next();
        if (move.equals("door")) {
            doorTeacher();
        } else if (move.equals("east")) {
            cafeteria();
        } else if (move.equals("south")) {
            enterCommons();
        } else {
            northCommons();
        }
    }

    public void northCommons() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/ *                                       |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                   ====                    ?");
        System.out.println("                                          \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        System.out.println("");
        System.out.println("Choices: door, east, south");
        String move = input.next();
        if (move.equals("door")) {
            doorTeacher();
        } else if (move.equals("east")) {
            cafeteria();
        } else if (move.equals("south")) {
            enterCommons();
        } else {
            northCommons();
        }
    }

    public void enterCommons() {
        System.out.println("-------------------------------------------------------");
        System.out.println("COMMONS");
        System.out.println("___________________________________________");
        System.out.println("|           ____(CAFETERIA)______         |              current item: " + item);
        System.out.println("|          |[------------------]|         |              hp: " + hp);
        System.out.println("|          {|!!!!!!!!!!!!!!!!!!|}         |              damage: " + damage);
        System.out.println("I #        /|------------------|\\         /              coins: " + coins);
        System.out.println("/                                         |");
        System.out.println("I                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         I");
        System.out.println("I                                         /");
        System.out.println("                    ====                   ?");
        System.out.println("  *                                       \\");
        System.out.println("I                                         I");
        System.out.println("|                                         |");
        System.out.println("|           ====           ====           |");
        System.out.println("|                                         |");
        System.out.println("|       &                                 |");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("|_________/ ? \\__________/ ? \\____________|");
        if (damage == 20) {
            System.out.println(name + ": Claire told me to go to the hallway towards the south, I should get there right now.");
        }
        System.out.println("");
        System.out.println("Choices: north, south, east, back");
        String move = input.next();
        if (move.equals("north")) {
            northCommons();
        } else if (move.equals("south")) {
            southCommons();
        } else if (move.equals("east")) {
            centerCommons();
        } else if (move.equals("back") && damage > 6) {
            back1();
        } else if (move.equals("back") && damage < 6) {
            back();
        } else {
            enterCommons();
        }
    }

    public void back1() {
        System.out.println("-------------------------------------------------------");
        System.out.println(" ______________");
        System.out.println("|              |              current item: " + item);
        System.out.println("/      ^                      hp: " + hp);
        System.out.println("|      *       |              damage: " + damage);
        System.out.println("|______________|              coins: " + coins);
        System.out.println("");
        System.out.println("Choices: talk, east");
        String move = input.next();
        if (move.equals("talk")) {
            secondTalk();
        } else if (move.equals("east")) {
            enterCommons();
        } else {
            back1();
        }
    }

    public void openFirstDoor() {
        damage = 20;
        item = "Meter Stick";
        System.out.println("-------------------------------------------------------");
        System.out.println("_________________ ");
        System.out.println("| STARTING ITEM  |              current item: " + item);
        System.out.println("| ____________   |              hp: " + hp);
        System.out.println("| |=|==||==|=|   |              damage: " + damage);
        System.out.println("|                |              coins: " + coins);
        System.out.println("|        *       / ");
        System.out.println("|________________|");
        System.out.println("");
        System.out.println("You gained your first item, the meter stick");
        System.out.println("+ 15 damage");
        System.out.println("");
        System.out.println("Choices: back");
        String move = input.next();
        if (move.equals("back")) {
            gotItem();
        } else {
            openFirstDoor();
        }
    }

    public void gotItem() {
        System.out.println("-------------------------------------------------------");
        System.out.println(" ______________");
        System.out.println("|              |");
        System.out.println("/      ^         ");
        System.out.println("|      *       |");
        System.out.println("|______________|");
        System.out.println("Claire: Nice! now you have something to protect yourself. But it's not strong enough to  ");
        System.out.println("get yourself out of the school. Go to the hallway in the south of the commons, there");
        System.out.println("you'll find better weapons/items.");
        System.out.println("");
        System.out.println("Choices: talk, east");
        String move = input.next();
        if (move.equals("talk")) {
            secondTalk();
        } else if (move.equals("east")) {
            enterCommons();
        } else {
            back1();
        }
    }

    public void secondTalk() {
        System.out.println("-------------------------------------------------------");
        System.out.println(" ______________");
        System.out.println("|              |");
        System.out.println("/      ^         ");
        System.out.println("|      *       |");
        System.out.println("|______________|");
        System.out.println("Claire: Didn't I already tell you what to do?");
        System.out.println("");
        System.out.println("Choices: talk, east");
        String move = input.next();
        if (move.equals("talk")) {
            secondTalk();
        } else if (move.equals("east")) {
            enterCommons();
        } else {
            back1();
        }
    }

    public void firstTalk() {
        System.out.println("-------------------------------------------------------");
        System.out.println(" ______________");
        System.out.println("|              |");
        System.out.println("/      ^         ");
        System.out.println("|      *       |");
        System.out.println("|______________|");
        System.out.println("Claire: Wassup " + name + "? Heard you wanted to escape the school XD. I'm going to help you but it's not");
        System.out.println("going to be easy with all these greasy teachers guarding the exit. Go get an item in that");
        System.out.println("room to the left, it will help you a lot.");
        System.out.println("");
        System.out.println("Choices: talk, door, east");
        String move = input.next();
        if (move.equals("door")) {
            firstDoor();
        } else if (move.equals("talk")) {
            firstTalk();
        } else if (move.equals("east")) {
            enterCommons();
        } else {
            back();
        }
    }

    public void back() {
        System.out.println("-------------------------------------------------------");
        System.out.println(" ______________");
        System.out.println("|              |              current item: " + item);
        System.out.println("/      ^                      hp: " + hp);
        System.out.println("|      *       |              damage: " + damage);
        System.out.println("|______________|              coins: " + coins);
        System.out.println("");
        System.out.println("Choices: talk, door, east");
        String move = input.next();
        if (move.equals("door")) {
            firstDoor();
        } else if (move.equals("talk") && damage > 6) {
            secondTalk();
        } else if (move.equals("talk") && damage < 6) {
            firstTalk();
        } else if (move.equals("east")) {
            enterCommons();
        } else {
            back();
        }
    }

    public void firstDoor() {
        System.out.println("-------------------------------------------------------");
        System.out.println(" ______________");
        System.out.println("|              |              current item: " + item);
        System.out.println("/*     ^                      hp: " + hp);
        System.out.println("|              |              damage: " + damage);
        System.out.println("|______________|              coins: " + coins);
        System.out.println("");
        System.out.println("Choices: open, back");
        String move = input.next();
        if (move.equals("back")) {
            back();
        } else if (move.equals("open")) {
            openFirstDoor();
        } else {
            firstDoor();
        }
    }

    public void start() {
        damage = 5;
        hp = 100;
        coins = 50;
        foodHeal = 0;
        ability = r.nextInt(11) + 20;
        wins = 0;
        item = "fist";
        food = "";
        key = "";
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("The bell rings and you're walking to your block B Computer Programming class.");
        System.out.println("You suddenly get a text from your good friend  (who you've secretly liked since grade 9 PE dance unit)");
        System.out.println("She texts; 'Hey good luck on your big CP test today! Hope you studied.'");
        System.out.println("'Wait what! I had a Cp test?? I totally forgot!! What do I do?'");
        System.out.println("'Chill out dude, I was planning on skipping the day anyway, if you want to join me...'");
        System.out.println("'That's a great idea, but this is Terry fox we're talking about, we need alot of elbow grease to make it out of here in one peice.'");
        System.out.println("'Well what are you still typing for dude? Meet me at our secret room in 2 minutes'");
        System.out.println("'oh boy...'");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println("You two meet at the 'secret room' to plan out your escape.");
        System.out.println("");
        System.out.println("Legends:");
        System.out.println("Player = *    Claire = ^");
        System.out.println("Wall = |    Door = /");
        System.out.println("SCHOOL MAP");
        System.out.println(" ______________");
        System.out.println("|              |              current item: " + item);
        System.out.println("/      ^                      hp: " + hp);
        System.out.println("|      *       |              damage: " + damage);
        System.out.println("|______________|              coins: " + coins);
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println("Choices: talk, door, east ");
        String choice = input.next();
        if (choice.equals("door")) {
            firstDoor();
        } else if (choice.equals("talk")) {
            firstTalk();
        } else if (choice.equals("east")) {
            enterCommons();
        } else {
            back();
        }
    }

    public void intro() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("You are an average student of Terry Fox. Today, you have forgotten to study for a big CP test, ");
        System.out.println("and you know you are going to fail if you take it. Your goal is to escape from the school safely, and without getting caught");
        System.out.println("by your teachers. Through you venture, you will fight enemies and gain coins that will help you along the way.");
        System.out.println("");
        System.out.println("While you are playing, you will be given choices of action.");
        System.out.println("To select the action that you desire, you will have to type that choice.");
        System.out.println("For example: To move north, type 'north', to open door, type 'open', etc.");
        System.out.println("");
        System.out.println("To play, enter your name.");
        System.out.println("What is your name?");
        name = input.next();
        start();
        input.close();
    }

    public void game() {
        System.out.println("Juul or Skool - by Daniel and Kasra");
        System.out.println("Press any key to play, press Q to quit");
        String play = input.next();

        if (!play.equals("q")) {
            intro();
        } else {
            System.out.println(":(");
        }
        input.close();
    }

    public static void main(String[] args) {
        TextBasedRPG game;
        game = new TextBasedRPG();
        game.game();
    }
} 