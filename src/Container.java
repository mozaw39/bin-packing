import java.util.*;

//First-Fit Decreasing (FFD) algorithm which packs an item to the first bin that it fits or start a new bin otherwise.
// Time complexity: O(n·log n).
public class Container {
    private int height;
    private int width;
    private BoxesList boxesList;
    private List<Box> addedBoxes;

    public Container(int height, int width) {
        this.height = height;
        this.width = width;
        boxesList = new BoxesList();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setBoxes(List<Box> addedBoxes) {
        this.addedBoxes = addedBoxes;
    }

    //First Fit
    public void solve(){
        Box box = null;
        if(addedBoxes.size() != 0)
        Collections.sort(addedBoxes, new Box(0, 0));
        for(int i = 0; i< boxesList.getSize(); i++){
            for (int j = 0; j < addedBoxes.size(); j++) {
                box = addedBoxes.get(j);
                if(boxesList.addBox(box)) {
                    addedBoxes.remove(box);
                    j--;
                }
            }
        }
        System.out.println(boxesList.toString());
    }

    public static void main(String[] args) {
        Container container = new Container(10, 20);
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(7, 4));
        boxes.add(new Box(4, 4));
        boxes.add(new Box(6, 2));
        boxes.add(new Box(1, 8));
        boxes.add(new Box(5, 5));
        boxes.add(new Box(9, 1));
        boxes.add(new Box(6, 3));
        boxes.add(new Box(3, 2));
        boxes.add(new Box(3, 2));
        container.setBoxes(boxes);
        container.solve();
    }
}
