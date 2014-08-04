import java.text.NumberFormat;
import java.text.ParseException;
public class Demo {
	public int count_tilings ( int N,int M ) {
	    int count = 1;
	    count += count2(N,M);
	    return count;
	  }
	  
	  private int count2(int N, int M){
	    int count=0;
	    int num=1;
	    while(true){
	      int cutN = N - (2*num-1);
	      int cutM = M - (2*num-1);
	      if(cutN<=0 && cutM<=0)
	        break;
	      if(cutN>0){
	    	  count += (Math.pow((M-1),num))*cutN;
	      }
	      if(cutM>0){
	    	  count += (Math.pow((N-1),num))*cutM;
	      }
	      num ++;
	      
	    }
	    return count;
	    
	  }
	  public static void main(String[] args){
		  Demo d = new Demo();
		  int t=d.count2(4, 3);
		  
		  NumberFormat format = NumberFormat.getIntegerInstance();
		  try {
			System.err.println(format.parse("3, 234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
