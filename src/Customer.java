import java.io.*;
import java.util.*;

class Customer {
    File f = null;

    void show(String platform) {
        if (platform.equalsIgnoreCase("P")) {
            f = new File("PSs.txt");

        } else if (platform.equalsIgnoreCase("X")) {
            f = new File("Xboxs.txt");
        } else if (platform.equalsIgnoreCase("N")) {
            f = new File("Nintendos.txt");
        }
        try {

            Scanner sc = new Scanner(f);
            int i = 0;
            System.out.println("*************************");
            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                temp.trim();
                temp = temp + " ";

                String gid = temp.substring(i, temp.indexOf(" "));
                System.out.println("Game id: " + gid);
                temp = temp.substring(temp.indexOf(" ") + 1);
                System.out.println("Title: " + temp.substring(i, temp.indexOf(" ")));
                temp = temp.substring(temp.indexOf(" ") + 1);
                System.out.println("Price: " + temp.substring(i, temp.indexOf(" ")));
                temp = temp.substring(temp.indexOf(" ") + 1);
                System.out.println("Discount: " + temp.substring(i, temp.indexOf(" ")));
                System.out.println("*************************");
            }

            sc.close();
        }

        catch (IOException e) {
            System.out.println(e);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to buy any ? YES/NO");
        if (sc.next().equals("YES")) {
            System.out.println("Enter the game id");
            int gid = sc.nextInt();
            select(gid, platform);
        }
        sc.close();

    }

    static void select(int gid, String platform) {
        if (platform.equalsIgnoreCase("PS")) {
            PS obj = new PS();
            obj.remove(gid);
        } else if (platform.equalsIgnoreCase("Xbox")) {
            Xbox obj1 = new Xbox();
            obj1.remove(gid);
        }

    }
}