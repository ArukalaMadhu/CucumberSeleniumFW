package commonutils;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RESTUtils {
	
		public JsonPath getRESTPOSTResponse(String endPoint, String request){			
			Response response = given().contentType(ContentType.JSON).body(request).
			        when().post(endPoint).then().contentType(ContentType.JSON).extract().response();			
			return response.jsonPath();
		}
		
		public JsonPath getRESTGETResponse(String endPoint, String request){			
			Response response = given().contentType(ContentType.JSON).
			        when().get(endPoint).then().contentType(ContentType.JSON).extract().response();			
			return response.jsonPath();
		}
		
		public static boolean checkElementPathFromJSONPATH(JsonPath jsonPathObj, String elePath){
			List<Map> res = jsonPathObj.get(elePath);	
			System.out.println(res);
			return res.size()>0;
		}
		
		public static boolean isValueExistInJSONPATH(JsonPath jsonPathObj, String path, String expectedValue){
			String res = jsonPathObj.getString(path);
			return res.equalsIgnoreCase(expectedValue);
		}
		
		public static void main(String args[]){
			 
			Response response = given().contentType(ContentType.JSON).body("{\"name\":\"madhu\",\"job\":\"IT\"}").
			        when().post("https://reqres.in/api/users").
			        then().contentType(ContentType.JSON).extract().response();
			//System.out.println(response.getStatusCode());
			 
//			 List<String> jsonResponse = response.jsonPath().getList("$");
//		     System.out.println(jsonResponse);
		     System.out.println(response.body().asString());
		     
		     Map<String, String> company = response.jsonPath().getMap("");
		     System.out.println(company.get("name"));
		     System.out.println(response.jsonPath().getString("name"));
		}
}
