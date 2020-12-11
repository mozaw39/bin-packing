import java.util.*;

//First-Fit Decreasing (FFD) algorithm which packs an item to the first bin that it fits or start a new bin otherwise.
// Time complexity: O(n·log n).
public class Container {
    private int height;
    private int width;
    private BoxesList boxes;
    //private Map<Integer, Integer> heightSlices; // {heightLevel, remainingWidth}
    private int remainingHeight;
    private HeightSlices heightSlices;

    public Container(int height, int width) {
        this.height = height;
        this.width = width;
        boxes = new BoxesList();
        heightSlices = new HeightSlices();
        remainingHeight = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //First Fit
    public void addBox(List<Box> addedBoxes) {
        Box box = null;
        Collections.sort(addedBoxes, new Box(0, 0));
        heightSlices.addHeightSlice(addedBoxes.get(0).getHeight(), width);
        for (int i = 0; i < heightSlices.getSize(); i++) {
            Integer remainingWidth = heightSlices.getWidth(i);
            for (int j = 0; j < addedBoxes.size(); j++) {
                box = addedBoxes.get(j);
                if (remainingWidth - box.getWidth() >= 0) {
                    boxes.addBox(i, box);
                    remainingWidth -= box.getWidth();
                    addedBoxes.remove(box);
                    j--;
                }
            }
            if(!addedBoxes.isEmpty())
            heightSlices.addHeightSlice(addedBoxes.get(0).getHeight(), width);
        }
        System.out.println(boxes.toString());
        System.out.println(heightSlices);
    }

    public void draw() {
        int sliceHeight = 0;
        final String[] drawing = {""};

        for (int k = 0; k < heightSlices.getSize(); k++) {
            sliceHeight = heightSlices.getHeight(k);
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
        Container container = new Container(20, 10);
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(7, 4));
        boxes.add(new Box(4, 4));
        boxes.add(new Box(6, 2));
        boxes.add(new Box(1, 8));
        boxes.add(new Box(5, 5));
        boxes.add(new Box(9, 1));
        boxes.add(new Box(6, 3));
        container.addBox(boxes);
        container.draw();
    }
}
