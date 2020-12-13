import java.util.*;


public class Box implements Comparator {
    private Integer height;
    private Integer width;
    private Integer depth;
    private boolean renversable = true;

    public Box() {
    }

    public Box(int width, int depth, int height) {
        List<Integer> sortedEntries =  null;
        if(renversable) {
            sortedEntries = sortEntries(width, height, depth);
            this.width = sortedEntries.get(0);
            this.height = sortedEntries.get(1);
            this.depth  = sortedEntries.get(2);
        }else{
            this.width = width;
            this.depth = depth;
            this.height = height;
        }
    }

    public List<Integer> sortEntries(int width, int depth, int height){
        List<Integer> sortedEntries = Arrays.asList(width, height, depth);
        Collections.sort(sortedEntries, Collections.reverseOrder());
        return sortedEntries;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getDepth() {
        return depth;
    }


    @Override
    public int compare(Object box1, Object box2) {
        return ((Box)box2).getWidth().compareTo(((Box)box1).getWidth());
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", depth=" + depth +
                ", height=" + height +
                '}';
    }
}
