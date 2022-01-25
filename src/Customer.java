import java.io.*;
import java.util.*;
import java.util.ArrayList;

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
                temp = temp + ",";
                String gid = temp.substring(i, temp.indexOf(","));
                System.out.println("Game id: " + gid);
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Title: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Price: " + temp.substring(i, temp.indexOf(",")) + "000 VND");
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Description: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Video: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Cover: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Image: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Condition: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Discount: " + temp.substring(i, temp.indexOf(",")));
                temp = temp.substring(temp.indexOf(",") + 1);
                System.out.println("Stock: " + temp.substring(i, temp.indexOf(",")));
                System.out.println("*************************");
            }
        }

        catch (IOException e) {
            System.out.println(e);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to buy any ? YES/NO");
        String input = sc.next().toUpperCase();
        if (input.equals("YES")) {
            System.out.println("Enter the game id");
            int gid = sc.nextInt();
            select(gid, platform);
        }
        else if (input.equals("S")){
            System.out.println("Enter name: ");
            String search_name = sc.next().toLowerCase();
            search(platform,search_name);
        }


    }

    void search(String platform, String search) {
        ArrayList<String> idArray = new ArrayList<String>();
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
            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                temp.trim();
                temp = temp + ",";
                String id = temp.substring(i, temp.indexOf(","));
                temp = temp.substring(temp.indexOf(",") + 1);
                temp = temp.substring(i, temp.indexOf(",")).toLowerCase();
                if (temp.contains(search)){
                    idArray.add(id);
                }
            }
            show(platform,idArray);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    void show(String platform, ArrayList idA) {
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
                temp = temp + ",";
                String gid = temp.substring(i, temp.indexOf(","));
                if (idA.contains(gid)) {
                    System.out.println("Game id: " + gid);
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Title: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Price: " + temp.substring(i, temp.indexOf(",")) + "000 VND");
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Description: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Video: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Cover: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Image: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Condition: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Discount: " + temp.substring(i, temp.indexOf(",")));
                    temp = temp.substring(temp.indexOf(",") + 1);
                    System.out.println("Stock: " + temp.substring(i, temp.indexOf(",")));
                    System.out.println("*************************");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to buy any ? YES/NO");
        if (sc.next().toUpperCase().equals("YES")) {
            System.out.println("Enter the game id");
            int game_id = sc.nextInt();
            select(game_id, platform);
        }
    }

    static void select(int gid, String platform) {
        if (platform.equalsIgnoreCase("P")) {
            PS obj = new PS(gid);
            obj.remove(gid);
        } else if (platform.equalsIgnoreCase("X")) {
            Xbox obj1 = new Xbox(gid);
            obj1.remove(gid);
        } else if (platform.equalsIgnoreCase("N")) {
            Nintendo obj1 = new Nintendo(gid);
            obj1.remove(gid);
        }
    }
}