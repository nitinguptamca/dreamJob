package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch08RecursionandDynamicProgramming.Q8_13_Stack_of_Boxes;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }
}
