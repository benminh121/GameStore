
import java.util.*;
import java.io.*;

public class Mall implements Runnable {

    synchronized public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" \t\t\t################# Welcome to Smart Store #################");
        System.out.print("Are you a customer YES/NO: ");
        String cus = sc.next();
        while (true) {
            // Choose customer or admin
            switch (cus.toUpperCase()) {
                case "YES":
                    Customer obj = new Customer();
                    // Choose platform
                    System.out.print("Choose platform game: ");
                    System.out.println("\nP for PS\tX for Xbox\tN for Nintendo Switch");
                    String pf = sc.next();
                    obj.show(pf);
                    break;
                case "NO":
                    boolean isAdmin = checkAdmin();
                    if (isAdmin) {
                        Owner obj1;
                        // Admin can add or remove game in store
                        System.out.println("Do you Want to Add or Remove");
                        String ch = sc.next();
                        if (ch.equals("Add")) {
                            // Add item - admin must enter all information of game DVD
                            System.out.println("Fill game details below:");
                            // Choose platform
                            System.out.println("Enter platform :\nP - Playstaion \nX - Xbox \nN - Nintendo Switch");
                            char platform = sc.next().charAt(0);
                            // Enter game id
                            System.out.println("Enter game id");
                            int gameID = sc.nextInt();
                            // Enter game title
                            System.out.println("Enter game title");
                            String title = sc.next();
                            // Enter game price
                            System.out.println("Enter game price");
                            double price = sc.nextDouble();
                            // Enter game description
                            System.out.println("Enter game description");
                            String description = sc.next();
                            // Enter video
                            System.out.println("Enter game video");
                            String video = sc.next();
                            // Enter cover
                            System.out.println("Enter game cover");
                            String cover = sc.next();
                            // Enter image
                            System.out.println("Enter game image1");
                            String image1 = sc.next();
                            // Enter Available or Unavailable
                            System.out.println("Enter game condition");
                            String condition = sc.next();
                            // Enter Discount
                            System.out.println("Enter game discount");
                            double discount = sc.nextDouble();
                            // Constructor add game in Owner class
                            obj1 = new Owner("add", platform, gameID, title, price, description, video, cover,
                                                image1, condition, discount);
                        // Constructor remove game
                        } else if (ch.equals("Remove")) {
                            System.out.print("Enter platform P X N: ");
                            char platform=sc.next().charAt(0);
                            obj1 = new Owner("remove", platform, 21, "title", 4.3, "description", "video", "cover",
                            "image1", "condition", 2.3); // We enter random to skip constructor
                        }
                    } else {
                        System.out.println("Sorry !Wrong Password or User ID\n Try again");
                    }
                    break;
                default:
                    System.out.println("Wrong choice");
            }
            System.out.println("Do you want to exit the store ? YES / NO");
            if (sc.next().toUpperCase().equals("YES"))
                break;
        }
        if (cus.equals("YES")) {
            Bill obj = new Bill();
            obj.displayBill();
        }
        System.out.println("Thank You , Visit Again");
        sc.close();
    }

    boolean checkAdmin() {

        File f = new File("src/admin.txt");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = sc.next();
        // System.out.println("Enter Password");
        // String password=sc.next();

        // try{
        // FileWriter fw =new FileWriter(f);
        // String str="UserID Pass@##"; //Admin id and password
        // fw.write(str);
        // fw.close();
        // }
        // catch(Exception e)
        // {
        // System.out.println("Error "+e);
        // }
        try {
            File inputFile = new File("src/admin.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String str = reader.readLine();
            // In file admin.txt has format {id pass}
            str.trim();
            int firstgap = str.indexOf(" ");
            if (id.equals(str.substring(0, firstgap))) {

                return new Mall().password(str.substring(firstgap + 1));
            } else
                return false;
        } catch (IOException e) {
            System.out.println("Errrr");
        }
        return false;

    }

    public boolean password(String pass) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        String toch = new String(passwordArray);
        if (toch.equals(pass))
            return true;
        else
            return false;

    }

}