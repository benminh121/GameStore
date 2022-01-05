import java.util.Scanner;

class Owner {
    Owner(){

    }

    Owner(String ch,char platform,int gameID, String title, double price, String description, String video, 
    String cover, String image1, String condition, double discount)
    {
        if(ch.equals("add"))
        {
            if (platform=='P')
            {
                PS obj = new PS(gameID, title, price, description, video, cover, image1, condition, discount);
                obj.add();
            }
            else if(platform=='X')
            {
                Xbox obj = new Xbox(gameID, title, price, description, video, cover, image1, condition, discount);
                obj.add();
            }
            else if(platform=='N')
            {
                Nintendo obj = new Nintendo(gameID, title, price, description, video, cover, image1, condition, discount);
                obj.add();
            }
        }
        if(ch.equals("remove"))
        {
            Scanner sc=new Scanner(System.in);
            if(platform == 'P')
            {
                System.out.print("Enter the game id: ");
                int n=sc.nextInt();
                PS obj = new PS(n);
                obj.remove(n);
            }
            else if(platform== 'X')
            {
                System.out.println("Enter the game id");
                int n=sc.nextInt();
                Xbox obj = new Xbox(gameID);
                obj.remove(n);
            }
            else if(platform== 'N')
            {
                System.out.println("Enter the game id");
                int n=sc.nextInt();
                Nintendo obj = new Nintendo(gameID);
                obj.remove(n);
            }
            sc.close();
        }

    }

	
}