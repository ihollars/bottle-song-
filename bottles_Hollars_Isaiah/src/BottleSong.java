/**
 * This class was initially used to create the entire program before the GUI
 * was implemented but it is just used now for its singBottleSong method.
 */

public class BottleSong {

    public static void singBottleSong(int bottles, int countBy){
        while(bottles>=countBy){
            System.out.println();
            System.out.println(bottles+" bottles of Purity on the wall\n"+bottles+" bottles of Purity");
            System.out.println("Take " + countBy+" down, twist the red cap\nDrinkity drink, we got more on tap!\n");
            bottles-=countBy;
        }
        System.out.println("\nSorry, we ran out of Purity. Have a Nice Day");
    }

    }

