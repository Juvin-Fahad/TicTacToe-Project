import java.util.*;
public class Main {
    public static void main(String[] args) {
        int choice;
        boolean startgame = false;
        Scanner sc = new Scanner(System.in);
        Game g = new Game();
        User u1 = new User();
        System.out.println("Welcome to the TicTacToe game!");
        System.out.println("1.Login\n2.Register\n3.Exit");
        System.out.println("{Please register if you are not registered.}");
        System.out.print("Choice: ");
        choice = sc.nextInt();
        if (choice == 3) System.exit(0);
        if (choice == 1) {
            boolean v;
            v = u1.verify();
            if (v) {
                System.out.println("Starting new game!");
                startgame = true;
            }
        }
        if (choice == 2) {
            u1.input();
            char c;
            System.out.println("Do you want to play now?(y/n): ");
            c = sc.next().charAt(0);
            if(c=='y' || c == 'Y') startgame = true;
        }
        while (startgame) {
            g.start();
            System.out.println("Do you want to play again?(y/n): ");
            char ch = sc.next().charAt(0);
            if(ch=='n' || ch == 'N') startgame = false;
        }
    }
}