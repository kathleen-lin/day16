package tfip.ssf.day16.Controller;

import java.io.Reader;
import java.io.StringReader;
import java.util.logging.*;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path="/rsvp", produces = MediaType.APPLICATION_JSON_VALUE)
public class RSVPController {
    
    private Logger logger = Logger.getLogger(RSVPController.class.getName());

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postAsJson(@RequestBody String payload){
        logger.log(Level.INFO, "payload : %s".formatted(payload));

        // handler to take json string and return json payload
        Reader reader = new StringReader(payload);
        JsonReader jsonReader = Json.createReader(reader);

        
        JsonObject json = jsonReader.readObject();
        String name = json.getString("name");
        Boolean attending = json.getBoolean("attending");

        json = Json.createObjectBuilder().add("name", name).add("attending", attending).build();



        return ResponseEntity.status(201).body(json.toString());
    }



    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postAsForm(
        @RequestBody MultiValueMap<String, String> form)
        {
            String name = form.getFirst("name");
            Boolean attending = Boolean.parseBoolean(form.getFirst("attending"));

            //logger.log(Level.INFO, ">>> name: %s, attending: b%".formatted(name,attending));

            // 201 created
            // Content-type: application/json
            // {"status": "Received <name> RSVP"}

            //return ResponseEntity.ok(payload.toString());
            JsonObject payload = Json.createObjectBuilder().add("message", "Received %s rsvp".formatted(name))
            .add("attending", attending)
            .build();

            
            
        return ResponseEntity.status(201).body(payload.toString());
    }

}
