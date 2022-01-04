import java.util.*;
import java.io.*;
import java.util.ArrayList;
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
                        String ch = sc.next().toUpperCase();
                        if (ch.equals("ADD")) {
                            // Add item - admin must enter all information of game DVD
                            System.out.println("Fill game details below:");
                            // Choose platform
                            System.out.println("Enter platform :\nP - PlayStation \nX - Xbox \nN - Nintendo Switch");
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
                        } else if (ch.equals("REMOVE")) {
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

    }

    boolean checkAdmin() {

        File f = new File("admin.csv");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = sc.next();
        try {
            /*File inputFile = new File("admin.csv");
            Scanner reader = new Scanner(inputFile);*/
            BufferedReader br = new BufferedReader(new FileReader("admin.csv"));
            String line = "";
            String username = null;
            String passwd = null;
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] record = line.split(",");    // use comma as separator
                username = record[0];
                passwd = record[1];
                if (id.equals(username)){
                    return new Mall().password(passwd);
                }
            }
            return false;


        } catch (IOException e) {
            System.out.println("Errrr");
        }
        return false;

    }

    /*public boolean password(String pass) {
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
    }*/
    // Because IDE run console always null, we cannot run with console.readPassword
    public boolean password(String pass){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Password: ");
        String passwordA = scanner.nextLine();
        return passwordA.equals(pass);
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    }

