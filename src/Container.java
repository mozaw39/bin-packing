import java.util.*;

//First-Fit Decreasing (FFD) algorithm which packs an item to the first bin that it fits or start a new bin otherwise.
// Time complexity: O(n·log n).
public class Container {
    private int height;
    private int width;
    private BoxesList boxes;
    //private Map<Integer, Integer> heightSlices; // {heightLevel, remainingWidth}
    private int remainingHeight;
    private WidthSlices widthSlices;

    public Container(int height, int width) {
        this.height = height;
        this.width = width;
        boxes = new BoxesList();
        widthSlices = new WidthSlices();
        remainingHeight = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //First Fit
    public void addBoxes(List<Box> addedBoxes) {
        Box box = null;
        Collections.sort(addedBoxes, new Box(0, 0));
        widthSlices.addHeightSlice(addedBoxes.get(0).getWidth(), height);
        for (int i = 0; i < widthSlices.getSize(); i++) {
            Integer remainingHeight = widthSlices.getRemainingHeight(i);
            for (int j = 0; j < addedBoxes.size(); j++) {
                box = addedBoxes.get(j);
                if (remainingHeight - box.getHeight() >= 0) {
                    boxes.addBox(i, box);
                    remainingHeight -= box.getHeight();
                    widthSlices.setRemainingHeight(i, remainingHeight);
                    addedBoxes.remove(box);
                    j--;
                }
            }
            if(!addedBoxes.isEmpty()) {
                widthSlices.addHeightSlice(addedBoxes.get(0).getWidth(), height);
            }
        }
        System.out.println(boxes.toString());
        System.out.println(widthSlices);
    }

    public void draw() {
        int sliceHeight = 0;
        final String[] drawing = {""};

        for (int k = 0; k < widthSlices.getSize(); k++) {
            sliceHeight = widthSlices.getRemainingHeight(k);
            for (int i = 0; i <= sliceHeight; i++) {
                drawing[0] += "|";
                for (int j = 0; j <= width; j++) {
                    if (i == 0 || i == height) drawing[0] += "__";
                    else drawing[0] += "  ";
                }
                drawing[0] += "\n";
                int finalI = i;
                for (Box box : boxes.getBoxes(k)) {
                    drawing[0] += box.drawLine(finalI);
                }
            }
            drawing[0] += "\n";
        }
        System.out.println(drawing[0]);
        //box.draw();
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
        container.addBoxes(boxes);
    }
}
