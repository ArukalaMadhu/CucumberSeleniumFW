package commonutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GenericMethods {
	
	public static String getCurrentDateTime(String timeZone, String date_time_format){
		
		TimeZone tz = TimeZone.getTimeZone(timeZone);
	    DateFormat df = new SimpleDateFormat(date_time_format);
	    df.setTimeZone(tz);
	    String nowAsISO = df.format(new Date());
	    System.out.println(nowAsISO);	    
		return nowAsISO;
	}
	
	public static String getJSONData(String JSONString, String key) throws ParseException{		
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(JSONString);        
        JSONObject jsonObject = (JSONObject) obj;        
        return jsonObject.get(key).toString();
	}
	
	public static void main(String[] args) throws ParseException{
		//e.x.,
		getCurrentDateTime("UTC","yyyy-MM-dd'T'HH:mm:ss.SSSX");
		String JSONSTring = "{\n" +
    			"  \"test1\":{\n" +
    			"    \"waitTimeCacheData\": [\n" +
    			"      {\n" +
    			"        \"workGroup\": \"UKServicing\",\n" +
    			"        \"waitTimeValue\": 300\n" +
    			"      }\n" +
    			"    ]\n" +
    			"  },\n" +
    			"  \"test2\":{\n" +
    			"    \"waitTimeCacheData\": [\n" +
    			"      {\n" +
    			"        \"workGroup\": \"UKServicing\",\n" +
    			"        \"waitTimeValue\": 400\n" +
    			"      }\n" +
    			"    ]\n" +
    			"  }\n" +
    			"}";
		System.out.println(getJSONData(JSONSTring,"test1"));
		
		String x = "Thanks for your message! I'll get back to you soon";
		System.out.println(x.contains("'"));
	}

}
