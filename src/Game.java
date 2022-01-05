/** This is an abstract class which can be extended by any product class  */
import java.util.ArrayList;
abstract class Game
{
    static ArrayList <String> bill =new ArrayList<>();
    private int gameID;
    private String title;
    private double price;
    private String description;
    private String video;
    public char platform;
    private String cover;
    private String image1;
    private String condition;
    private double discount;
    Game()
    {
        gameID = 0;
        title = null;
        price = 0;
        description = null;
        video = null;
        platform = (char) 0;
        cover = null;
        image1 = null;
        condition = null;
        discount = 0;
    }
    Game(int gameID, String title, double price, String description, String video, 
    String cover, String image1, String condition, double discount){
        this.setGameID(gameID);
        this.setTitle(title);
        this.setPrice(price);
        this.setDescription(description);
        this.setVideo(video);
        this.setCover(cover);
        this.setImage1(image1);
        this.setCondition(condition);
        this.setDiscountG(discount);
    }
    Game(int gameID){
        setGameID(gameID);
    }

       // Set and get methods
    public void setGameID(int gameID){
        this.gameID = gameID;
    }
    
    public int getGameID(){
        return gameID;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setPrice(double price) {
        this.price = price;
    } 
    
    public double getPrice() {
        return price;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setVideo(String video) {
        this.video = video;
    }
    
    public String getVideo(){
        return video;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public String getCover() {
        return cover;
    }
    
    public void setImage1(String image1) {
        this.image1 = image1;
    }
    
    public String getImage1() {
        return image1;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDiscountG(double discount) {
        this.discount = discount;
    } 
    
    public double getDiscountG() {
        return discount;
    }

    abstract void add( );
    abstract boolean searchInStock(int n,String purpose );
}