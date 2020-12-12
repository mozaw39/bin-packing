import java.util.*;

public class BoxesList{
    private Map<Integer, List<Box>> boxesList; //<Level, List of boxes in that level>
    private Map<Integer, BoxesLevel> boxes;
    private int size;

    public BoxesList() {
        boxes = new HashMap<>();
        boxes.put(0, new BoxesLevel(10)); //initially we have one level
        size++;
    }
    public boolean addBox(Box box){
        for (int i = 0; i < size; i++) {
            if(boxes.get(i).addBoxLevel(box))
                return true;
        }{
        }
        if(getTotalWidth() + box.getWidth() > 20)
            return false;
        BoxesLevel boxesLevel = new BoxesLevel(10);
        if(boxesLevel.addBoxLevel(box)) {
            boxes.put(size++, boxesLevel);
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getTotalWidth(){
        final int[] totalWidth = {0};
        boxes.forEach( (key, boxesLevel) -> totalWidth[0] += boxesLevel.getMaxWidth() );
        return  totalWidth[0];
    }

    @Override
    public String toString(){
        final String[] returnValue = {""};
        boxes.forEach( (key, value) -> returnValue[0] += "{level" + key + ": " + value.toString() + "}\n" );
        return returnValue[0];
    }
    public List<Box> getBoxes(int i){
        return boxesList.get(i);
    }
}

class BoxesLevel {
    List<Box> boxes;
    int remainingHeight;
    int maxWidth; // width of the level
    int maxDepth; // Depth of the level

    public BoxesLevel(int height) {
        boxes = new ArrayList<>();
        remainingHeight = height;
    }
    public boolean addBoxLevel(Box box){
        int boxHeight = box.getHeight();
        if(boxHeight <= remainingHeight) {
            boxes.add(box);
            //setMaxDepth(box.getDepth());
            setMaxWidth(box.getWidth());
            remainingHeight -= boxHeight;
            return true;
        }
        return false;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    private void setMaxWidth(int width) {
        if(width > maxWidth)
        this.maxWidth = width;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int depth) {
        if(depth > maxDepth)
        this.maxDepth = depth;
    }

    @Override
    public String toString() {
        return "BoxesLevel{" +
                "boxes=" + boxes +
                '}';
    }
}
