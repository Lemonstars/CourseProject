/**
 * Created by LiuXing on 2016/10/24.
 */
public class State {
    private static int numOfState=0;

    private int currentIndex;

    public State(){
        currentIndex=numOfState;
        numOfState++;
    }

    public int getCurrentIndex(){
        return currentIndex;
    }


}
