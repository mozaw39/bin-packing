import java.util.HashMap;
import java.util.Map;

public class WidthSlices {
    private Map<Integer, WidthSlice> l;
    private static int count = 0;

    public WidthSlices() {
        l = new HashMap<>();
    }
    public void addHeightSlice(int width, int height){
        l.put(count++, new WidthSlice(width, height));
    }
    public int getWidth(int key){
        return l.get(key).getWidth();
    }
    public Integer getRemainingHeight(int key){
        return l.get(key).getRemainingHeight();
    }
    public int getSize(){
        return count;
    }
    public void setRemainingHeight(int key, int remainingHeight){
        l.get(key).setRemainingHeight(remainingHeight);
    }

    @Override
    public String toString() {
        return l.toString();
    }
}

class WidthSlice {
    private int width;
    private Integer remainingHeight;

    public WidthSlice(int width, int remainingHeight) {
        this.remainingHeight = remainingHeight;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public Integer getRemainingHeight() {
        return remainingHeight;
    }

    public void setRemainingHeight(int remainingWidth) {
        this.remainingHeight = remainingWidth;
    }

    @Override
    public String toString() {
        return "wWdthSlice{" +
                "width=" + width +
                ", remainingHeight=" + remainingHeight +
                '}';
    }
}