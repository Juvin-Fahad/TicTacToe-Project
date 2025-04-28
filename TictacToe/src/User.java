import java.util.*;
public class User {
        String name,mail=null;
        char gender;
        int psd=0,age;
        Scanner sc = new Scanner(System.in);
        void input() {
                System.out.println("Enter your name: ");
                name = sc.nextLine();
                System.out.println("Enter your age: ");
                age = sc.nextInt();
                System.out.println("Enter your gender(m or f): ");
                gender = sc.next().charAt(0);
                sc.nextLine();
                System.out.println("Enter your E-mail : ");
                mail = sc.nextLine();
                System.out.println("Enter your Password : ");
                psd = sc.nextInt();
                System.out.println("Congratulations! Successfully  registered..");
        }
        void info(){
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
            System.out.println("E-mail address : "+mail);
        }
        boolean verify(){
            System.out.println("Enter Email : ");
            String gm;
            int gpsd;
            gm = sc.nextLine();
            System.out.println("Password : ");
            gpsd = sc.nextInt();
            if(mail.equals(gm) && psd == gpsd) {
                    System.out.println("Successfully logged in!");
                    return true;
            }else{
                    System.out.println("You have entered the wrong password or username.");
                    return false;
            }
    }
}