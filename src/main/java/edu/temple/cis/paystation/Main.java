package edu.temple.cis.paystation;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IllegalCoinException {
        PayStation pay_st = new PayStationImpl();
        Scanner User1 = new Scanner(System.in);
        int num = 10;

        while (num >= 0) {
            int User_Selection = Menu();
            if (User_Selection == 1) {
                System.out.println("How much would you like to deposit?");
                int option = Integer.parseInt(User1.next());
                pay_st.addPayment(option);
            }
            else if (User_Selection == 2) {
                display(pay_st);
            }
            else if (User_Selection == 3) {
                int time = pay_st.readDisplay();
                Receipt receipt = pay_st.buy();
                System.out.println("Receipt: " + pay_st.empty() + " = " + time + " mins");
            }
            else if (User_Selection == 4) {
                Map<Integer, Integer> map = pay_st.cancel();
                System.out.println("Total returned= " + map);
            } else if (User_Selection == 5) {
                admin(pay_st);//displaying the admin menu

            }
            num=num-1;
        }
        User1.close();

    }

    public static PayStation admin(PayStation pay_st) {
        Scanner User1 = new Scanner(System.in);
        System.out.println("\nAdmin Menu\n");
        System.out.println("\nPlease pick an option:\n#1 Empty\n#2 Change rate strategy");
        int user_Input = Integer.parseInt(User1.nextLine());

        if (user_Input == 1) {
            pay_st.empty();

        } else if (user_Input == 2) {
            System.out.println("\nPlease choose a rate strategy to implement\n"
                    + "1- AlphaTown\n"
                    + "2- BetaTown\n"
                    + "3- GammaTown\n"
                    + "4- DeltaTown\n"
                    + "5- OmegaTown\n");
            int user_Input2 = Integer.parseInt(User1.nextLine());
            pay_st.setRateStrategy(user_Input2);
        }
        return pay_st;
    }

    public static int Menu() {
        Scanner User1 = new Scanner(System.in);
        System.out.println("\nPlease pick a number from the following menu\n" +
                "1) Deposit Coins\n" +
                "2) Display\n" +
                "3) Buy Ticket\n" +
                "4) Cancel\n" +
                "5) Change Rate Strategy\n\n" +
                "Choose from the options below: ") ;
        int User_Input = Integer.parseInt(User1.nextLine());
        return User_Input;
    }

    public static void display(PayStation pay_st){
        System.out.println("\n---------------------------------\n " +
                "\t\tRECEIPT\n"+
                " Amount of minutes purchased: " + pay_st.readDisplay()+ " min" +
                "\n----------------------------------\n");
    }


}
