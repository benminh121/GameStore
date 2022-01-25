import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

class Bill extends Game {
    // design line ----
    public void lineadder() {
        for (int x = 0; x < 145; x++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    String username;
    String usercontact;
    double totalprice = 0;

    void displayBill() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        username = sc.nextLine();
        System.out.print("Your Phone Number: ");
        usercontact = sc.next();
        System.out.println("\n\nDear " + username + ",");
        System.out.println(usercontact);
        lineadder();
        for (int i = 0; i < 70; i++)
            System.out.print(" ");
        System.out.println("BILL");
        System.out.println("");
        lineadder();
        // Create name of column
        String S = "ID";
        System.out.print(S);
        for (int k = S.length(); k < 30; k++) {
            if (k == 20)
                System.out.print("|");
            System.out.print(" ");
        }
        S = "NAME";
        System.out.print(S);
        for (int k = S.length(); k < 30; k++) {
            if (k == 20)
                System.out.print("|");
            System.out.print(" ");
        }
        S = "MRP";
        System.out.print(S);
        for (int k = S.length(); k < 30; k++) {
            if (k == 20)
                System.out.print("|");
            System.out.print(" ");
        }
        S = "DISCOUNT";
        System.out.print(S);
        for (int k = S.length(); k < 30; k++) {
            if (k == 20)
                System.out.print("|");
            System.out.print(" ");
        }
        S = "COST";
        System.out.print(S);
        for (int k = S.length(); k < 30; k++) {
            if (k == 20)
                System.out.print("|");
            System.out.print(" ");
        }
        System.out.println("");
        lineadder();
        // print information for each row
        for (int counter = 0; counter < bill.size(); counter++) {
            double price = 0;
            int i = 0;
            String temp = bill.get(counter);
            temp.trim();
            temp = temp + " ";
            // Print game id
            String gid = temp.substring(i, temp.indexOf(","));
            System.out.print(gid);
            // Print game id
            for (int k = temp.substring(i, temp.indexOf(",")).length(); k < 30; k++) {
                if (k == 20)
                    System.out.print("|");
                System.out.print(" ");
            }
            // Print name
            temp = temp.substring(temp.indexOf(",") + 1);
            System.out.print(temp.substring(i, temp.indexOf(",")));
            for (int k = temp.substring(i, temp.indexOf(",")).length(); k < 30; k++) {
                if (k == 20)
                    System.out.print("|");
                System.out.print(" ");
            }
            // Print price
            temp = temp.substring(temp.indexOf(",") + 1);
            price = Double.parseDouble(temp.substring(i, temp.indexOf(",")));
            System.out.print(temp.substring(i, temp.indexOf(",")));
            for (int k = temp.substring(i, temp.indexOf(",")).length(); k < 30; k++) {
                if (k == 20)
                    System.out.print("|");
                System.out.print(" ");
            }
            // print discount
            temp = temp.substring(temp.indexOf(",") + 1);
            temp = temp.substring(temp.indexOf(",") + 1);
            temp = temp.substring(temp.indexOf(",") + 1);
            temp = temp.substring(temp.indexOf(",") + 1);
            temp = temp.substring(temp.indexOf(",") + 1);
            temp = temp.substring(temp.indexOf(",") + 1);
            price = price - (price * Double.parseDouble(temp.substring(i, temp.indexOf(","))));
            System.out.print(temp.substring(i, temp.indexOf(",")));
            for (int k = temp.substring(i, temp.indexOf(",")).length(); k < 30; k++) {
                if (k == 20)
                    System.out.print("|");
                System.out.print(" ");
            }
            // Cost
            System.out.print(price);
            for (int k = Double.toString(price).length(); k < 30; k++) {
                if (k == 20)
                    System.out.print("|");
                System.out.print(" ");
            }
            totalprice += price;
            System.out.println();
        }
        lineadder();
        System.out.println();
        System.out.println("Total Cost: " + totalprice);
        System.out.println("Added 10% GST");
        totalprice = totalprice + (0.10 * totalprice);
        System.out.println("Final Price: " + totalprice);
        add();
        bill.clear();
    }

    void add() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        // System.out.println(formatter.format(date));
        try {
            File record = new File("record.txt");
            FileWriter fw = new FileWriter(record, true);
            String str = username + " " + usercontact + " " + Double.toString(totalprice) + " " + formatter.format(date)
                    + "\n";
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    boolean searchInStock(int n, String purpose) {
        return true;
    }
}