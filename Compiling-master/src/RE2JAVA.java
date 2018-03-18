import java.io.*;
import java.util.ArrayList;

/**
 * Created by st0001 on 2016/10/25.
 */
public class RE2JAVA {

    private LexicalAnalyse lex;
    private ArrayList<String> RE_List;
    private ArrayList<String> RE_addPoint_List;
    private ArrayList<String> RE_postFix_List;
    private ArrayList<Graph> NFA_List;
    private Graph mergedNFA;
    private Graph DFA;
    private ArrayList<State> finalState;
    private ArrayList<Character> trans_List;
    private ArrayList<ArrayList<Integer>> I;


    public RE2JAVA() {
        lex = new LexicalAnalyse();
        RE_List = new ArrayList();
        RE_addPoint_List = new ArrayList();
        RE_postFix_List = new ArrayList();
        NFA_List = new ArrayList();
        trans_List =new ArrayList();

        //read the file lexical.l
        readFile();

        //initialize the transfer char
        init_trans_List();

        //add point
        for (String s : RE_List) {
            RE_addPoint_List.add(lex.addPoint(s));
        }

        //infix -> postfix
        for (String s : RE_addPoint_List) {
            RE_postFix_List.add(lex.inFix2postFix(s));
        }

        //RE->NFA
        for (String s : RE_postFix_List) {
            NFA_List.add(lex.re2nfa(s));
        }
        for (int i = 0; i < NFA_List.size(); i++) {
            System.out.println("------------------" + "第" + (i + 1) + "个RE->NFA---------------------------");
            printNFA(NFA_List.get(i));
        }

        //NFAs->merge NFA
        mergedNFA = lex.mergeNFA(NFA_List);
        System.out.println("---------------------------merged NFAs---------------------------");
        printNFA(mergedNFA);

        //merge NFA -> DFA
        DFA = lex.mergeNFA2DFA(mergedNFA);
        printDFA(DFA);

        this.finalState=lex.getEndStateList();
        this.I=lex.getI();

        //generate java code
        writeFile();
    }

    private void readFile() {
        File file = new File("file/lexical.l");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                RE_List.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init_trans_List(){
        for(String s:RE_List){
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch!='.'&&ch!='|'&&ch!='*'&&!trans_List.contains(ch)) {
                    trans_List.add(ch);
                }
            }
        }
    }

    private void writeFile() {

        String code="import java.io.BufferedReader;\n" +
                "import java.io.IOException;\n" +
                "import java.io.InputStreamReader;\n" +
                "import java.util.ArrayList;\n" +
                "public class GenerateCode {\n" +
                "\n" +
                "    public static void main(String[] arg){\n" +
                "\n" +
                "        ArrayList<String> input=new ArrayList();\n" +
                "        String str=\"\";\n" +
                "        System.out.println(\"请输入串（允许多个串以空格隔开）：\");\n" +
                "        try {\n" +
                "            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));\n" +
                "            str = bufferedReader.readLine();\n" +
                "        } catch (IOException e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "        for(String s:str.split(\"\\\\s+\")){\n" +
                "            input.add(s);\n" +
                "        }\n\n";

        code+="for(String s:input)\n{\n" +
                "int state=0;\n" +
                "OneString:for(int i=0;i<s.length();i++)\n{\n" +
                "char ch=s.charAt(i);\n" +
                "switch (state)\n{\n";
        ArrayList<Edge> edge_List=DFA.getEdgeList();
        int state=-1;
        for(int i=0;i<lex.getNumOfIi();i++){
            code+="case "+i+":\n";
            for(int j = 0; j< trans_List.size(); j++){
                if(j==0){
                    code+="if ";
                }else{
                    code+="else if";
                }
                code+="(ch == '"+ trans_List.get(j)+"')";
                boolean isFind=false;
                for(Edge e:edge_List){
                    if(((DFAState)(e.getStartState())).getDFA_index() ==i
                            &&e.getTransChar()==trans_List.get(j)){
                        state=((DFAState)(e.getEndState())).getDFA_index();
                        isFind=true;
                        break;
                    }
                }
                if(isFind){
                    code+="\n{\nstate="+state+";break;\n}\n";
                }else{
                    code+="\n{\nSystem.out.println(s+\" 未能匹配！\");\n" +
                            "state=-1;\n" +
                            "break OneString;" +
                            "\n}\n" ;
                }
            }
            code+="\nelse\n{\n" +
                    "System.out.println(s+\"出现正则表达式里未出现的连接符！\");\n" +
                    "state=-1;\n" +
                    "break OneString;" +
                    "\n}\n";

        }

        code+="default:\n" +
                "System.out.println(\"状态信息出错!\");\n" +
                "state=-1;\n" +
                "break OneString;";

        code+="\n}\n\n}\n";

        for(int i=0;i<I.size();i++){
            code+="if(state == "+ i+")\n" +
                    "\n{\n" +
                    "System.out.println(s+\"  RE"+findIi(i)+"\");\n" +
                    "\n}\n";
        }

        code+="\n}\n";

        code+="\n}\n" +
                "\n}\n";
        try
        {
            File file = new File("src/GenerateCode.java");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(code);
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void printDFA(Graph g){
        System.out.println("----------------------DFA---------------------------------");
        int index=0;
        for(Edge edge:DFA.getEdgeList()){
            index++;
            System.out.print(index+"." );

            DFAState start=(DFAState) edge.getStartState();
            ArrayList<Integer> startOldState=start.getdfaStateList();
            System.out.print("  开始原状态集:");
            for(Integer i:startOldState){
                System.out.print(i+" ");
            }
            System.out.print("现状态:I"+start.getDFA_index());
            System.out.print(";");

            DFAState end=(DFAState) edge.getEndState();
            ArrayList<Integer> endOldState=end.getdfaStateList();
            System.out.print("  终止原状态集:");
            for(Integer i:endOldState){
                System.out.print(i+" ");
            }
            System.out.print("现状态:I"+end.getDFA_index());
            System.out.print(";");

            System.out.println("  连接符："+edge.getTransChar());
        }
    }

    private  void printNFA(Graph g){
        int index=0;
        for(Edge edge:g.getEdgeList()){
            index++;
            System.out.println("边"+(index)+" startState:"+edge.getStartState().getCurrentIndex()
                    +" endState:"+edge.getEndState().getCurrentIndex()+" 连接符："+edge.getTransChar());
        }
    }

    //input为dfa下的状态编号，返回nfa状态下的终结点编号
    private int findIi(int input){
        int result=-1;
        ArrayList<Integer> finalNum=new ArrayList();
        for(State s:finalState){
            finalNum.add(s.getCurrentIndex());
        }

        ArrayList<Integer> target=I.get(input);
        for(int k=0;k<target.size();k++){
          if(finalNum.contains(target.get(k))){
              return finalNum.indexOf(target.get(k));
          }
        }

        return result;
    }

}
