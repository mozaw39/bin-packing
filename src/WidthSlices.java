import java.util.HashMap;
import java.util.Map;

public class WidthSlices {
    private HeightSlice heightSlice;
    private Map<Integer, HeightSlice> l;
    private static int count = 0;

    public WidthSlices() {
        l = new HashMap<>();
    }
    public void addHeightSlice(int height, int width){
        l.put(count++, new HeightSlice(height, width));
    }
    public int getHeight(int key){
        return l.get(key).getWidth();
    }
    public int getWidth(int key){
        return l.get(key).getRemainingHeight();
    }
    public void setRemainingWidth(int key, int remainingWidth){
        l.get(key).setRemainingHeight(remainingWidth);
    }
    public int getSize(){
        return count;
    }

    @Override
    public String toString() {
        return l.toString();
    }
}

class HeightSlice {
    private Integer width;
    private int remainingHeight;

    public HeightSlice(int height, int remainingHeight) {
        this.remainingHeight = remainingHeight;
        this.width = height;
    }

    public Integer getWidth() {
        return width;
    }

    public int getRemainingHeight() {
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