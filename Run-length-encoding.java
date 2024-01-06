class GfG
 {
	String encode(String str)
	{
          //Your code here
          StringBuilder sb = new StringBuilder();
          int count=1;
          int i=1;
          for( i=1; i<str.length();i++){
              if(str.charAt(i)==str.charAt(i-1)){
                  count++;
              }else{
                  sb.append(str.charAt(i-1));
                  sb.append(count);
                  count=1;
              }
          }
          sb.append(str.charAt(i-1));
          sb.append(count);
          
          return sb.toString();
	}
	
 }
