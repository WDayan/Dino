class MainString{
	public static void main ( String args []){
	String s = new String();
	String aux = new String();
	String done = new String();
	int i,j=0;
	s = "main(){    int a;";
	for(i = 0;i < s.length(); i++){
		char c = s.charAt(i);
		String x = String.valueOf(c);
		if(x.equals("i")){
			c = s.charAt(i+1);
			x = String.valueOf(c);
			if(x.equals("n")){
				i+=2;
				c = s.charAt(i);
				x = String.valueOf(c);
				if(x.equals("t")){
					while(j<3){
						j++;
						c = s.charAt(i);
						x = String.valueOf(c);
						if(x.equals(" ")){
							i=i;
						}
						else if(x.equals("=")){
						}
						else if(x.equals(",")){
							System.out.println("IF ,  \n\n");
						}
						else
					}
				
				}
			}
		}
	}
	
	
	}	
}
