import java.io.*;
import java.util.*;

class Obj{

	public Map instance;

	public Obj(){
		this.instance = readLineFile();
	}

	public Object get(String key){
		return this.instance.get(key);
	} 

	public void set(String key, String val){
		this.instance.put(key,val);
		this.writeLineFile(this.instance);
	}

	public void del(String key){
		this.instance.put(key,null);
		this.writeLineFile(this.instance);
	}

	public void writeByFileReader(String data) 
	{

		try 
		{
			File file = new File("app.txt");

			if (!file.exists()) {

				file.createNewFile();

			}

			FileWriter fileWritter = new FileWriter(file.getName());

			fileWritter.write(data);

			fileWritter.close();

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	public void writeLineFile(Map input){
		Set keySet = input.keySet();
		Iterator it = keySet.iterator();

		String data="";
		while(it.hasNext()){
			Object key =it.next();
			Object value = input.get(key);
			if(value != null && !value.equals("")){
				data += key+":"+value+"\n";	
			}

			
		}
		writeByFileReader(data);
	}

	public Map readLineFile(){
		Map result  = new HashMap();
		try {
			FileInputStream in = new FileInputStream("app.txt");
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			String line = null;
			int i = 1;

			
			while((line = bufReader.readLine()) != null){
				String[] arr = line.split("[:]");
				for (int j = 0; j < arr.length; j++) {
					String key = arr[0];
					String value = arr[1];
					result.put(key,value);
				}
				i++;
			}
			bufReader.close();
			inReader.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

class App{

	public static void main(String[] args)
	{
		Obj obj = new Obj();

		obj.del("a2");
		// System.out.println(obj.get("a1"));
		// Map result= new HashMap();
		// result.put("a1","b1");
		// result.put("a2","b2");
		// result.put("a3","b3");

		// obj.writeLineFile(result);
		
	}
}

