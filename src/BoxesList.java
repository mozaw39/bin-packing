import java.util.*;

public class BoxesList{
    private Map<Integer, List<Box>> boxesList;

    public BoxesList() {
        boxesList = new HashMap<>();
        boxesList.put(0, new ArrayList<Box>());
    }
    public void addBox(int level, Box box){
        List<Box> list =  boxesList.get(level);
        if(list != null)
            boxesList.get(level).add(box);
        else {
            list = new ArrayList<Box>();
            list.add(box);
            boxesList.put(level, list);
        }
    }
    @Override
    public String toString(){
        final String[] returnValue = {""};
        boxesList.forEach( (key, value) -> returnValue[0] += "{level" + key + ": " + value.toString() + "}\n" );
        return returnValue[0];
    }
    public List<Box> getBoxes(int i){
        return boxesList.get(i);
    }
}
