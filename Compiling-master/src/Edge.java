/**
 * Created by LiuXing on 2016/10/24.
 */
public class Edge {

    State startState;
    State endState;
    char  transChar;

    public Edge(State start,State end,char ch){
        this.startState=start;
        this.endState=end;
        this.transChar=ch;
    }

    public void setEndState(State endState) {
        this.endState = endState;
    }

    public void setStartState(State startState){
        this.startState=startState;
    }

    public void setTransChar(char transChar){
        this.transChar=transChar;
    }

    public State getStartState() {
        return startState;
    }

    public State getEndState() {
        return endState;
    }

    public char getTransChar() {
        return transChar;
    }
}
