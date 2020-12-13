import java.util.*;

//First-Fit Decreasing (FFD) algorithm which packs an item to the first bin that it fits or start a new bin otherwise.
// Time complexity: O(n·log n).
public class Container {
    private int height;
    private int width;
    //private BoxesList boxesList;
    private List<Box> addedBoxes;
    private BoxesMatrice boxesMatrice;

    public Container(int height, int width) {
        this.height = height;
        this.width = width;
        //boxesList = new BoxesList();
        boxesMatrice = new BoxesMatrice();
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

    public List<Integer> getRemainingHeights(){
        return boxesMatrice.getRemainingHeights();
    }

    //First Fit
    public void solve(){
        Box box = null;
        if(addedBoxes.size() != 0)
        Collections.sort(addedBoxes, new Box());
        for(int i = 0; i< boxesMatrice.getSize(); i++){
            for (int j = 0; j < addedBoxes.size(); j++) {
                box = addedBoxes.get(j);
                if(boxesMatrice.addBox(box)) {
                    addedBoxes.remove(box);
                    j--;
                }
            }
        }
        System.out.println(boxesMatrice.toString());
    }

    public static void main(String[] args) {
        Container container = new Container(10, 20);
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(7, 4, 4));
        boxes.add(new Box(4, 4, 2));
        boxes.add(new Box(6, 2, 11));
        boxes.add(new Box(1, 8, 4));
        boxes.add(new Box(5, 5, 3));
        boxes.add(new Box(9, 1, 2));
        boxes.add(new Box(6, 3, 6));
        boxes.add(new Box(3, 2, 9));
        boxes.add(new Box(3, 2, 5));
        boxes.add(new Box(4, 4, 10));
        boxes.add(new Box(4, 3, 3));
        container.setBoxes(boxes);
        container.solve();
        System.out.println(container.getRemainingHeights());
    }
}
