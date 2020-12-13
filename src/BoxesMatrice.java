import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxesMatrice {
    private Map<Integer, BoxesList> boxesMatrice;
    private int size;

    public BoxesMatrice() {
        boxesMatrice = new HashMap<>();
        BoxesList boxesList = new BoxesList();
        boxesMatrice.put(0, boxesList);
        size++;
    }

    public boolean addBox(Box box){
        for (int i = 0; i < size; i++) {
            if(boxesMatrice.get(i).addBox(box))
                return true;
        }
        if(getTotalDepth() + box.getWidth() > 20)
            return false;
        BoxesList boxesList = new BoxesList();
        if(boxesList.addBox(box)) {
            boxesMatrice.put(size++, boxesList);
            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getTotalDepth(){
        final int[] totalDepth = {0};
        boxesMatrice.forEach( (key, boxesList) -> totalDepth[0] += boxesList.getMaxDepth() );
        return  totalDepth[0];
    }

    public List<Integer> getRemainingHeights(){
        List<Integer> remainingHeights = new ArrayList<>();
        boxesMatrice.forEach( (key, element) -> remainingHeights.addAll(element.getRemainingHeights()) );
        return remainingHeights;
    }

    @Override
    public String toString() {
        final String[] returnValue = {""};
        boxesMatrice.forEach( (key, value) -> returnValue[0] += "boxesDepth" + key + ": " + value.toString() + "}\n" );
        return "BoxesMatrice{" +
                 returnValue[0] +
                '}';
    }

}
