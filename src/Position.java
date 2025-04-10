import java.io.Serializable;

public class Position implements Serializable{
    private int x;
    private int y;

    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}

    @Override
    public String toString() {
        return Integer.toString(x) + Integer.toString(y);
    }
}
