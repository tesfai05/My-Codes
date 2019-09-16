package lecture7_34;

public class MyTable 
{
	private Entry[] entries=new Entry[26];
	
	public String get(char c)
	{
		int index=(int)c-97;
		return entries[index].str;
	} 
	
	public void add(char c, String s) 
	{
		int index=(int)c-97;

		entries[index] = new Entry(c, s);
		
	} 
	
	public String toString() 
	{
		String str1 = "";
		for(int i=0;i<26;i++) {
			if(entries[i] != null) 
			{
				str1 = str1 + entries[i].toString() + '\n';
				 
			}
		}
		return str1;
	}
	private class Entry 
	{
		private char ch;
		String str;
		Entry(char ch, String str){
			this.ch=ch;
			this.str=str;
		}
		public String toString() {
			
			return this.ch+"->"+this.str;
		}
	}
	public static void main(String[] args) {
		MyTable tb=new MyTable();
		tb.add('a', "Andrew");
		tb.add('t',"Tesfai");
		tb.add('w',"Weldu");
		tb.add('z', "Zebib");
		String s1 = tb.get('t');
		System.out.println("tb.get('t')="+s1);
		String s2 = tb.get('w');
		System.out.println("tb.get('w')="+s2);
		String s3 = tb.get('z');
		System.out.println("tb.get('z')="+s3);
		String s4 = tb.get('a');
		System.out.println("tb.get('a')="+s4);
		System.out.println("--------------");
		System.out.println(tb);
		
	}
}


