import java.io.*;
import java.util.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.file.*;
public class battery {
	public static void main(String[] args)throws Exception 
	  { 
		String compare1="Uid u0a202";
		String compare2="Foreground activities";
		float Battery_percentage=0,Battery_drain=0;
		File file = new File("C:\\Users\\CBDT\\Desktop\\Hackathon\\Battery.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st,st2,st3,Foreground=""; 
		while ((st = br.readLine()) != null) 
		{
			st2=st;
			String[] array = st2.split(":");
			if(array.length>1)
			{ 
				array[0]=array[0].trim();
				if(array[0].equals(compare1))
				{
		         st3=array[1];
		         String[] array1 = st3.split("\\(");
		         Battery_drain=Float.parseFloat(array1[0]); 
		      		}
				if(array[0].equals(compare2))
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
		obj.put("Battery_drain" ,Battery_drain);
		obj.put("Battery_percentage" ,Battery_percentage);
		FileWriter file1=new FileWriter("C:\\Users\\CBDT\\Desktop\\Hackathon\\Battery_OP.json");
		file1.write(obj.toString());
		file1.flush();
		System.out.println(obj);
		
	  } 
	
}
