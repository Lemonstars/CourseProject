import java.util.ArrayList;

/**
 * Created by LiuXing on 2016/10/25.
 */
public class DFAState extends  State {

    private ArrayList<Integer> dfaStateList;
    private static int num=0;
    private int DFA_index;

    public DFAState(ArrayList<Integer> dfaStateList){
        this.dfaStateList=dfaStateList;
        this.DFA_index=num;
        num++;
    }

    public ArrayList<Integer> getdfaStateList(){
        return dfaStateList;
    }

    public int getDFA_index(){
        return DFA_index;
    }

}
