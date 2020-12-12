import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;


public class Box implements Comparator {
    private Integer height;
    private Integer width;
    private boolean renversable = true;

    public Box(int width, int height) {
        if(renversable && width < height){
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


    @Override
    public int compare(Object box1, Object box2) {
        return ((Box)box2).getWidth().compareTo(((Box)box1).getWidth());
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
