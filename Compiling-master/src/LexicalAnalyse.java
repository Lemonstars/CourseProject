import java.util.ArrayList;
import java.util.Stack;

public class LexicalAnalyse {

    //用于存储多个正则表达式的nfa终态
    private ArrayList<State> endStateList;
    //表格驱动法下的Ii的个数
    private int numOfIi=-1;
    //
    private ArrayList<ArrayList<Integer>> I;

    //构造函数
    public LexicalAnalyse(){
        endStateList=new ArrayList();
    }

    //预处理，加连接符
    public String addPoint(String input) {
        String result = "";
        for (int i = 0; i < input.length() - 1; i++) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            result += c1;
            if ((c1 != '.' && c1 != '|' && c1 != '(')
                    && (c2 != '.' && c2 != '|' && c2 != ')' && c2 != '*')) {
                result += '.';
            }
        }
        result += input.charAt(input.length() - 1);
        return result;
    }

    //运算符优先级设置
    private int getPriority(char ch) {
        switch (ch) {
            case '*':
                return 4;
            case '.':
                return 3;
            case '|':
                return 2;
            case '(':
                return 1;
            default:
                return 5;
        }
    }

    //中缀转后缀
    public String inFix2postFix(String input) {
        String result = "";
        Stack<Character> myStack = new Stack<Character>();
        char ch;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch == '(') {
                myStack.push(ch);
            } else if (ch == ')') {
                while (myStack.peek() != '(') {
                    result += myStack.pop();
                }
                myStack.pop();
            } else {
                while (!myStack.isEmpty()) {
                    char top = myStack.peek();
                    int topPriority = this.getPriority(top);
                    int thisPriority = this.getPriority(ch);
                    if (topPriority >= thisPriority) {
                        result += myStack.pop();
                    } else {
                        break;
                    }
                }
                myStack.push(ch);
            }
        }

        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }

        return result;
    }

    //正则表达式转NFA
    public Graph re2nfa(String input) {
        char ch;
        Stack<Graph> myStack = new Stack();
        Graph graph, left, right;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            switch (ch) {
                case '.':
                    right = myStack.pop();
                    left = myStack.pop();
                    graph = join_graph(left, right);
                    myStack.push(graph);
                    break;
                case '|':
                    right = myStack.pop();
                    left = myStack.pop();
                    graph = or_gragh(left, right);
                    myStack.push(graph);
                    break;
                case '*':
                    right = myStack.pop();
                    graph = star_graph(right);
                    myStack.push(graph);
                    break;
                default:
                    graph = make_graph(ch);
                    myStack.push(graph);
            }
        }

        return myStack.pop();
    }

    //处理a|b
    private Graph or_gragh(Graph left, Graph right) {
        //新增开始结束状态
        State startState = new State();
        State endState = new State();

        //新增四条边
        Edge edge1 = new Edge(startState, left.getGraghStart(), '#');
        Edge edge2 = new Edge(startState, right.getGraghStart(), '#');
        Edge edge3 = new Edge(left.getGraghEnd(), endState, '#');
        Edge edge4 = new Edge(right.getGraghEnd(), endState, '#');

        //构造新增边后的图
        Graph newGraph = new Graph();
        newGraph.addEdge(edge1);
        newGraph.addEdge(edge2);
        for (Edge edge : left.getEdgeList()) {
            newGraph.addEdge(edge);
        }
        for (Edge edge : right.getEdgeList()) {
            newGraph.addEdge(edge);
        }
        newGraph.addEdge(edge3);
        newGraph.addEdge(edge4);
        //设置开始和结束状态
        newGraph.setGraghStart(startState);
        newGraph.setGraghEnd(endState);

        return newGraph;
    }

    //处理a.b
    private Graph join_graph(Graph left, Graph right) {
        //新建开始结束状态
        State startState = new State();
        State endState = new State();

        //构造新的边
        Edge edge1 = new Edge(startState, left.getGraghStart(), '#');
        Edge edge2 = new Edge(right.getGraghEnd(), endState, '#');
        Edge edge3 = new Edge(left.getGraghEnd(), right.getGraghStart(), '#');
        //加入新的图
        Graph newGraph = new Graph();
        newGraph.addEdge(edge1);
        for (Edge edge : left.getEdgeList()) {
            newGraph.addEdge(edge);
        }
        newGraph.addEdge(edge2);
        for (Edge edge : right.getEdgeList()) {
            newGraph.addEdge(edge);
        }
        newGraph.addEdge(edge3);
        //设置开始结束状态
        newGraph.setGraghStart(startState);
        newGraph.setGraghEnd(endState);

        return newGraph;
    }

    //处理a*
    private Graph star_graph(Graph graph) {
        //新建开始结束状态
        State startState = new State();
        State endState = new State();

        //新增的边
        Edge edge1 = new Edge(startState, graph.getGraghStart(), '#');
        Edge edge2 = new Edge(graph.getGraghEnd(), endState, '#');
        Edge edge3 = new Edge(graph.getGraghEnd(), graph.getGraghStart(), '#');
        Edge edge4 = new Edge(startState, endState, '#');

        //构造新图
        Graph newGraph = new Graph();
        newGraph.addEdge(edge1);
        newGraph.addEdge(edge2);
        newGraph.addEdge(edge3);
        newGraph.addEdge(edge4);
        for (Edge edge : graph.getEdgeList()) {
            newGraph.addEdge(edge);
        }
        //设置开始结束状态
        newGraph.setGraghStart(startState);
        newGraph.setGraghEnd(endState);

        return newGraph;
    }

    //生成最小单元图a
    private Graph make_graph(char ch) {
        State startState = new State();
        State endState = new State();
        Edge newEdge = new Edge(startState, endState, ch);
        Graph newGraph = new Graph();
        newGraph.addEdge(newEdge);
        newGraph.setGraghStart(startState);
        newGraph.setGraghEnd(endState);

        return newGraph;
    }

    //多个nfa合成一个nfa
    public Graph mergeNFA(ArrayList<Graph> arrayOfGraph) {

        //先保存终态
        for(Graph g:arrayOfGraph){
            this.endStateList.add(g.getGraghEnd());
        }

        //两两合并
        Stack<Graph> myStack = new Stack();
        for (Graph g : arrayOfGraph) {
            myStack.add(g);
        }
        while (myStack.size() != 1) {
            Graph newGraph = new Graph();
            //新建一个开始节点
            State startState = new State();
            //新增边
            Graph right = myStack.pop();
            Graph left = myStack.pop();
            Edge edge1 = new Edge(startState, right.getGraghStart(), '#');
            Edge edge2 = new Edge(startState, left.getGraghStart(), '#');
            //构建新图
            for (Edge edge : right.getEdgeList()) {
                newGraph.addEdge(edge);
            }
            for (Edge edge : left.getEdgeList()) {
                newGraph.addEdge(edge);
            }
            newGraph.setGraghStart(startState);
            newGraph.addEdge(edge1);
            newGraph.addEdge(edge2);
            //压栈（每次只merge两个nfa）
            myStack.push(newGraph);
        }

        return myStack.pop();
    }

    //merge后的nfa转化成dfa
    public Graph mergeNFA2DFA(Graph mergeNFA) {
        Graph dfa = new Graph();

        //获得所有边的符号
        ArrayList<Character> edgeCharList = new ArrayList();
        ArrayList<Character> symbolCharList = new ArrayList();
        symbolCharList.add('(');
        symbolCharList.add(')');
        symbolCharList.add('.');
        symbolCharList.add('|');
        symbolCharList.add('*');
        symbolCharList.add('#');//表示epsilon
        for (Edge e : mergeNFA.getEdgeList()) {
            char ch = e.getTransChar();
            if ( !symbolCharList.contains(ch) && !edgeCharList.contains(ch)) {
                edgeCharList.add(ch);
            }
        }

        //构造Ii
          //初始化Ii集合
        ArrayList<ArrayList<Integer>> Ii=new ArrayList();
        ArrayList<DFAState> stateOfIi=new ArrayList();
        ArrayList<Integer> I0=this.get_epsilon_closure(mergeNFA,mergeNFA.getGraghStart().getCurrentIndex());
        Ii.add(I0);
          //设置初始状态
        DFAState dfaStartState=new DFAState(I0);
        stateOfIi.add(dfaStartState);
        dfa.setGraghStart(dfaStartState);
          //计算中间转化过程
        ArrayList<Edge> edgeList=mergeNFA.getEdgeList();
        int newLength=Ii.size();
        int indexOfIi=0;
        while(indexOfIi<newLength){
            DFAState startState=stateOfIi.get(indexOfIi);
            ArrayList<Integer> thisIi = startState.getdfaStateList();
            for(char ch : edgeCharList) {
                ArrayList<Integer> ch_end_list=new ArrayList();
                //连接运算符
                for (Integer ch_start:thisIi) {
                    for (Edge e : edgeList) {
                        int ch_end=e.getEndState().getCurrentIndex();
                        if ( e.getStartState().getCurrentIndex()==ch_start && e.getTransChar()==ch
                                && !ch_end_list.contains(ch_end )) {
                            ch_end_list.add(ch_end);
                        }
                    }
                }

                //求epsilon闭包
                ArrayList<Integer> ch_end_closure_list=new ArrayList();
                for(Integer i:ch_end_list){
                    ArrayList<Integer> temp=this.get_epsilon_closure(mergeNFA,i);
                    for(Integer k:temp){
                        if(!ch_end_closure_list.contains(k)){
                            ch_end_closure_list.add(k);
                        }
                    }
                }
                //检查ch_end_closure_list是否已经出现在Ii集合中
                boolean isSame=false;
                int targetIndex=-1;
                for(int k=0;k<Ii.size();k++){
                    if( this.compareIi(Ii.get(k) ,ch_end_closure_list)){
                        isSame=true;
                        targetIndex=k;
                        break;
                    }
                }
                if( !ch_end_closure_list.isEmpty()){
                    DFAState endState;
                    if(!isSame) {
                        Ii.add(ch_end_closure_list);
                        endState=new DFAState(ch_end_closure_list);
                    }else{
                        endState=stateOfIi.get(targetIndex);
                    }
                    stateOfIi.add(endState);
                    Edge dfaEdge=new Edge(startState ,endState,ch);
                    dfa.addEdge(dfaEdge);

                }
            }
            newLength=Ii.size();
            indexOfIi++;
        }

        this.I=Ii;
        this.numOfIi=Ii.size();

        return dfa;
    }

    //表格驱动法下，两个Ii的是否包含相同元素的比较
    private boolean compareIi(ArrayList<Integer> first,ArrayList<Integer> second){
        boolean result=true;
        for(Integer i:first){
            if( !second.contains(i)){
                return false;
            }
        }
        for(Integer i:second){
            if( !first.contains(i)){
                return false;
            }
        }

        return result;
    }

    //求解epsilon闭包
    private ArrayList<Integer> get_epsilon_closure(Graph mergeNFA, Integer target) {
        ArrayList<Integer> result = new ArrayList();
        ArrayList<Edge> edgeList = mergeNFA.getEdgeList();

        //广度遍历，每次便利一层
        //第一次遍历
        result.add(target);
        int oldLength = result.size();
        for (Edge e : edgeList) {
            int ensState = e.getEndState().getCurrentIndex();
            int startState = e.getStartState().getCurrentIndex();
            if (target == startState && e.getTransChar() == '#' && !result.contains(ensState)) {
                result.add(ensState);
            }
        }
        int newLength = result.size();
        //当结果集大小发生变化时，说明有新的元素加入，需要检查是否可以通过epsilon连接其他状态
        while (oldLength != newLength) {
            for (int i = oldLength; i < newLength; i++) {
                int goal = result.get(i);
                for (Edge e : edgeList) {
                    int startNum = e.getStartState().getCurrentIndex();
                    int endNum = e.getEndState().getCurrentIndex();
                    if (goal == startNum && e.getTransChar() == '#' && !result.contains(endNum)) {
                        result.add(endNum);
                    }
                }
            }
            oldLength = newLength;
            newLength = result.size();
        }

        return result;
    }

    //获取终止符
    public ArrayList<State> getEndStateList() {
        return endStateList;
    }

    //获取Ii个数
    public int getNumOfIi(){
        return numOfIi;
    }

    //获取Ii
    public ArrayList<ArrayList<Integer>> getI(){
        return I;
    }
}
