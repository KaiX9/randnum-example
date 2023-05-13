package sg.edu.nus.iss.day35examples.controller;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@Controller
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class RandomNumberController {
    
    private Random rand = new SecureRandom();

    @GetMapping(path="/random")
    @ResponseBody
    public ResponseEntity<String> getRandom(@RequestParam(defaultValue = "1") Integer count) {
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (int i = 0; i < count; i++) {
            arrBuilder.add(rand.nextInt(100) + 1);
        }
        JsonObject resp = Json.createObjectBuilder()
                .add("numbers", arrBuilder.build())
                .add("timestamp", (new Date().toString()))
                .build();

        return ResponseEntity.ok(resp.toString());
    }
}
