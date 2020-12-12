import java.util.ArrayList;
import java.util.List;

public class BoxesMatrice {
    private List<BoxesList> boxesMatrice;

    public BoxesMatrice() {
        boxesMatrice = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "BoxesMatrice{" +
                "boxesMatrice=" + boxesMatrice +
                '}';
    }
}
