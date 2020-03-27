package finalproject;
import java.io.*;
import java.text.*;
import org.json.JSONObject;
public class Battery {
		public static void main(String[] args)throws Exception 
		  { 
			String string1="Uid u0a202";
			String string2="Foreground activities";
			float Battery_percentage=0,Battery_drain=0;
			File file = new File("C:\\Users\\mbala\\Documents\\Battery.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			DecimalFormat df= new DecimalFormat("#0.000");
			String st1,st2,st3,Foreground=""; 
			while ((st1 = br.readLine()) != null) 
			{
				st2=st1;
				String[] array = st2.split(":");
				if(array.length>1)
				{ 
					array[0]=array[0].trim();
					if(array[0].equals(string1))
					{
						st3=array[1];
						String[] array1 = st3.split("\\(");
						Battery_drain=Float.parseFloat(array1[0]); 
					}
					if(array[0].equals(string2))
					{
						st3=array[1];
						String[] array1 = st3.split("\\(r");
						Foreground=array1[0].trim();
					} 
				}
		    }
			Battery_percentage=(Battery_drain/1000);
			JSONObject obj=new JSONObject();
			obj.put("Foreground_time",Foreground);
			obj.put("Battery_drain" ,df.format(Battery_drain));
			obj.put("Battery_percentage" ,df.format(Battery_percentage));
			FileWriter file1=new FileWriter("C:\\Users\\mbala\\Documents\\file.json");
			file1.write(obj.toString());
			file1.flush();
			file1.close();
			System.out.println(obj);
          }
		}



