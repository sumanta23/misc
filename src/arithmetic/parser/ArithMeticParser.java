
package arithmetic.parser;

import java.util.ArrayList;
import java.util.Stack;

public class ArithMeticParser {

	String parse;
	Stack stack=new Stack();
	Stack computestack=new Stack();
	ArrayList postfix=new ArrayList();
	boolean flag=false;
	
	public  ArithMeticParser(String parseit)
	{
		parse=parseit;
		System.out.println(parse);
	}
	
	public int process()
	{
		toPostfix();
		System.out.println(postfix);
		compute();
		return Integer.parseInt(computestack.get(0).toString());
	}
	
	
	
	public void toPostfix()
	{
		for(int i=0;i<parse.length();i++)
		{
			char c=parse.charAt(i);
			if(c=='+'||c=='-'||c=='*'||c=='/')
			{
				if(stack.isEmpty())
				{
					stack.add(c);
				}
				else
				{
					String element=(stack.lastElement()).toString();
					if(!precedence(element,String.valueOf(c)))
					{
						int ss=stack.size();
						postfix.add((stack.get(ss-1)).toString());
						stack.remove(stack.size()-1);
						stack.add(String.valueOf(c));
					}
					else
					{
						stack.add(c);
					}
				}
				flag=false;	
			}
			else if(c=='{'||c=='}'||c=='['||c==']'||c=='('||c==')')
			{
				stack.add(c);
				if(c=='}'||c==']'||c==')')
				{
					while( ((( ((stack.get(stack.size()-3)).equals('{')) && ((stack.get(stack.size()-1)).equals('}')) )) || 
							(( ((stack.get(stack.size()-3)).equals('[')) && ((stack.get(stack.size()-1)).equals(']')) )) ||
							(( ((stack.get(stack.size()-3)).equals('(')) && ((stack.get(stack.size()-1)).equals(')')) )) ))
					{
					postfix.add(stack.get(stack.size()-2));
					stack.set((stack.size()-2),c);
					stack.pop();
					}
					stack.pop();
					stack.pop();
				}
				flag=false;
			}
			else
			{
				if(flag==true)
			    {
			    int pos=postfix.size()-1;
				postfix.set(pos, (postfix.get(pos).toString()+c) );
				flag=true;
			    }
				if(flag==false)
				{
					postfix.add(String.valueOf(c));
					flag=true;
				}
				    
			}
		}
		
		while(!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
	}
	
	
	
	public void  compute() {
		int size=postfix.size();
		for(int index=0;index<=size-1;index++)
		{
			if( !(  (postfix.get(index).toString()).equals("+") ||
					(postfix.get(index).toString()).equals("-") ||
					(postfix.get(index).toString()).equals("*") ||
					(postfix.get(index).toString()).equals("/") 
					))
			{
				computestack.add(postfix.get(index));
			}
			else
			{
				int var1=Integer.parseInt((computestack.get(computestack.size()-2).toString()));
				int var2=Integer.parseInt((computestack.get(computestack.size()-1).toString()));
				computestack.pop();
				computestack.pop();
				if(postfix.get(index).toString().equals("+"))
				    computestack.add(var1+var2);
				if(postfix.get(index).toString().equals("-"))
					computestack.add(var1-var2);
				if(postfix.get(index).toString().equals("*"))
					computestack.add(var1*var2);
				if(postfix.get(index).toString().equals("/"))
					computestack.add(var1/var2);
			}
		
		}
		System.out.println(computestack.get(0));
	}
	
	
	
	public boolean precedence(String element,String c)
	{
		boolean b=false;
		int val1=0;
		int val2=0;
		if(element.equals("+"))
			val1=1;
		if(element.equals("-"))
			val1=1;
		if(element.equals("*"))
			val1=2;
		if(element.equals("/"))
			val1=2;
		if(element.equals("{")||element.equals("(")||element.equals("["))
			val1=0;
		
		if(c.equals("+"))
			val2=1;
		if(c.equals("-"))
			val2=1;
		if(c.equals("*"))
			val2=2;
		if(c.equals("/"))
			val2=2;
		if(element.equals("{")||element.equals("(")||element.equals("["))
			val2=0;
		
		if(val1>val2)
			b=false;
		else
			b=true;
		return b;
	}
	
	
}
