import java.util.ArrayList;

/**
 * Created by LiuXing on 2016/10/24.
 */
public class Graph {

    private State graghStart;
    private State graghEnd;
    private ArrayList<Edge> edgeList;

    public Graph(){
        edgeList=new ArrayList();
    }

    public void addEdge(Edge edge){
        this.edgeList.add(edge);
    }

    public void setGraghStart(State start){
        this.graghStart=start;
    }

    public void setGraghEnd(State end){
        this.graghEnd=end;
    }

    public State getGraghStart() {
        return graghStart;
    }

    public State getGraghEnd() {
        return graghEnd;
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }
}
