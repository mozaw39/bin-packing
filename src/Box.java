import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;


public class Box implements Comparator {
    private Integer height;
    private Integer width;
    private Map<String, String> position;
    private boolean renversable = true;

    public Box(int width, int height) {
        if(renversable && width > height){
            this.height = width;
            this.width = height;
        }
        else {
            this.height = height;
            this.width = width;
        }
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public String[] draw(){
        String[] drawing = new String[height];
        for (int i = 0; i < height; i++) {
            drawing[i] = "";
            drawing[i] += "|";
            for (int j = 0; j < width; j++) {
                if(i ==height - 1 ) drawing[i] += "xx";
                else drawing[i] += "xx";
            }

        }
        //System.out.println(Arrays.toString(drawing));
        return drawing;
    }

    public String drawLine( int index){
        String[] drawing = this.draw();
        int length = drawing.length;
        return (index < length)?drawing[index]:"";

    }

    public static void main(String[] args){
        Box box = new Box(4,4);
        box.draw();
    }


    @Override
    public int compare(Object box1, Object box2) {
        return ((Box)box2).getHeight().compareTo(((Box)box1).getHeight());
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + height +
                ", height=" + width +
                '}';
    }
}
class Position{
    Integer x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}