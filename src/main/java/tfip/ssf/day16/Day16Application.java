package tfip.ssf.day16;

import java.io.Reader;
import java.io.StringReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@SpringBootApplication
public class Day16Application{
// public class Day16Application implements CommandLineRunner {
	public static void main(String[] args) {
		
		SpringApplication.run(Day16Application.class, args);
	}

	// @Override
	// public void run(String... args){
	//  	// {"name": "fred", "email":"fred@k.com"}
	//  	JsonObject json = Json.createObjectBuilder()
	//  		.add("name", "fred").add("email", "fred@gmail.com")
	//  		.build();

	//  	System.out.printf("json: %s\n", json.toString());
		
	//  	JsonArray array = Json.createArrayBuilder()
	//  		.add(json)
	//  		.add(json)
	//  		.build();
		
	//  	System.out.printf("array: %s\n", array.toString());

	
	//  	String jsonStr = """
	//  			{
	//  				"orderID": 1234, "address": "10 Bedrok Ave",
	//  				"lineItems" : [
	//  					{"name" : "apple", "quantity": 10},
	//  					{"name" : "orange", "quantity": 10}
	//  				]
	//  			}
	//  			""";

		
	//  	System.out.printf(">>>> jsonStr: \n%s\n", jsonStr);

						
	//  	 Reader reader = new StringReader(jsonStr);
	//  	 JsonReader jsonReader = Json.createReader(reader);
	//  	 json = jsonReader.readObject();

	//  	System.out.printf("orderID: %d\n", json.getInt("orderID"));
	//  	System.out.printf("orderID: %s\n", json.getString("address"));
	//  	array = json.getJsonArray("lineItems");
	//  	 for (int i = 0; i < array.size(); i++){
	//  	 	json = array.getJsonObject(i);
	//  	 	System.out.printf("\tname: %s, quantity: %d\n", json.getString("name"), json.getInt("quantity"));

	//  	 }
	// }
 

}