import java.util.HashMap;
import java.util.Map;

public class HeightSlices {
    private HeightSlice heightSlice;
    private Map<Integer, HeightSlice> l;
    private static int count = 0;

    public HeightSlices() {
        l = new HashMap<>();
    }
    public void addHeightSlice(int height, int width){
        l.put(count++, new HeightSlice(height, width));
    }
    public int getHeight(int key){
        return l.get(key).getHeight();
    }
    public int getWidth(int key){
        return l.get(key).getRemainingWidth();
    }
    public void setRemainingWidth(int key, int remainingWidth){
        l.get(key).setRemainingWidth(remainingWidth);
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
    private Integer height;
    private int remainingWidth;

    public HeightSlice(int height, int remainingWidth) {
        this.remainingWidth = remainingWidth;
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getRemainingWidth() {
        return remainingWidth;
    }

    public void setRemainingWidth(int remainingWidth) {
        this.remainingWidth = remainingWidth;
    }

    @Override
    public String toString() {
        return "HeightSlice{" +
                "height=" + height +
                ", remainingWidth=" + remainingWidth +
                '}';
    }
}