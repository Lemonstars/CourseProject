import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class GenerateCode {

    public static void main(String[] arg){

        ArrayList<String> input=new ArrayList();
        String str="";
        System.out.println("请输入串（允许多个串以空格隔开）：");
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String s:str.split("\\s+")){
            input.add(s);
        }

for(String s:input)
{
int state=0;
OneString:for(int i=0;i<s.length();i++)
{
char ch=s.charAt(i);
switch (state)
{
case 0:
if (ch == 'p')
{
state=1;break;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
state=2;break;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
state=3;break;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 1:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
state=4;break;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 2:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
state=5;break;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 3:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
state=6;break;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 4:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
state=7;break;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 5:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
state=8;break;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 6:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
state=9;break;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 7:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
state=10;break;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 8:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
state=11;break;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 9:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
state=12;break;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 10:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
state=13;break;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 11:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
state=14;break;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 12:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 13:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
state=15;break;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 14:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
state=16;break;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 15:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
case 16:
if (ch == 'p')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'u')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'b')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'l')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'i')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'c')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 's')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 't')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'a')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'v')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'o')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}
else if(ch == 'd')
{
System.out.println(s+" 未能匹配！");
state=-1;
break OneString;
}

else
{
System.out.println(s+"出现正则表达式里未出现的连接符！");
state=-1;
break OneString;
}
default:
System.out.println("状态信息出错!");
state=-1;
break OneString;
}

}
if(state == 0)

{
System.out.println(s+"  RE-1");

}
if(state == 1)

{
System.out.println(s+"  RE-1");

}
if(state == 2)

{
System.out.println(s+"  RE-1");

}
if(state == 3)

{
System.out.println(s+"  RE-1");

}
if(state == 4)

{
System.out.println(s+"  RE-1");

}
if(state == 5)

{
System.out.println(s+"  RE-1");

}
if(state == 6)

{
System.out.println(s+"  RE-1");

}
if(state == 7)

{
System.out.println(s+"  RE-1");

}
if(state == 8)

{
System.out.println(s+"  RE-1");

}
if(state == 9)

{
System.out.println(s+"  RE-1");

}
if(state == 10)

{
System.out.println(s+"  RE-1");

}
if(state == 11)

{
System.out.println(s+"  RE-1");

}
if(state == 12)

{
System.out.println(s+"  RE0");

}
if(state == 13)

{
System.out.println(s+"  RE-1");

}
if(state == 14)

{
System.out.println(s+"  RE-1");

}
if(state == 15)

{
System.out.println(s+"  RE0");

}
if(state == 16)

{
System.out.println(s+"  RE0");

}

}

}

}
