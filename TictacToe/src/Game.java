import java.util.*;

public class Game {
    char[][] c = { { '.', '.', '.' }, { '.', '.', '.' }, { '.', '.', '.' } };
    int i, j;
    int f = 0,cnt =1;
    char ch;
    Scanner sc = new Scanner(System.in);
    void show() {
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(c[i][j] + " ");
                if (j != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != 2) {
                System.out.println("--------");
            }
        }
    }

    void input(char ch) {
        int a, b;
        a = sc.nextInt();
        a -= 1;
        b = sc.nextInt();
        b -= 1;
        if (c[a][b] == '.') {
            c[a][b] = ch;
        } else {
            System.out.println("You can not enter here.");
        }
    }

    int check() {

        for (i = 0; i < 3; i++) {
            if (c[i][0] == c[i][1] && c[i][1] == c[i][2] && c[i][0] != '.') {
                if (c[i][0] == 'O') {
                    System.out.println("Player 1 wins!");
                } else {
                    System.out.println("Player 2 wins!");
                }
                return 1;
            }
        }
        for (i = 0; i < 3; i++) {
            if (c[0][i] == c[1][i] && c[2][i] == c[1][i] && c[0][i] != '.') {
                if (c[0][i] == 'O') {
                    System.out.println("Player 1 wins!");
                } else {
                    System.out.println("Player 2 wins!");
                }
                return 1;
            }
        }
        if (c[0][0] == c[1][1] && c[1][1] == c[2][2] && c[0][0] != '.') {
            if (c[0][0] == 'O') {
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("Player 2 wins!");
            }
            return 1;
        } else if (c[0][2] == c[1][1] && c[1][1] == c[2][0] && c[0][2] != '.') {
            if (c[2][0] == 'O') {
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("Player 2 wins!");
            }
            return 1;
        }
        return 0;
    }
    void start(){
        System.out.println("Enter number for row & column(Must be 1-3)");
        show();
        while (f == 0) {
            System.out.print("Enter for player - 1(row,column): ");
            ch = 'O';
            input(ch);
            cnt++;
            if(cnt ==9){
                System.out.println("Match Draw :(");
                break;
            }
            show();
            f = check();
            if (f == 1) {
                break;
            }
            System.out.print("Enter for player - 2(row,column): ");
            ch = 'X';
            input(ch);
            cnt++;
            show();
            if(cnt ==9){
                System.out.println("Match Draw :(");
                break;
            }
            f = check();
        }
    }
}
