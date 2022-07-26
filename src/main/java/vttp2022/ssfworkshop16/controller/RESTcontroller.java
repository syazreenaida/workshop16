package vttp2022.ssfworkshop16.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller; <---used in SSFworkshop14
// import org.springframework.ui.Model; <---used in SSFworkshop14
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute; <---used in SSFworkshop14
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2022.ssfworkshop16.services.redisService;

@RestController
@RequestMapping(path = "/", produces="checkers/json")
public class RESTcontroller {

    @Autowired
    redisService service;

    @GetMapping("/api/boardgame/{boardGame}")
    public ResponseEntity<String> get(@PathVariable(value="boardGame") String boardGame){
        // User user = userSvc.get(userId);
        // JsonObject resp = Json.createObjectBuilder()
        //                         .add("name", user.getName())
        //                         .build();
        return null;
    }

    @PostMapping(path="/api/boardgame", consumes="checkers/json")
    public ResponseEntity<String> postUser(@RequestBody String payload) {
        JsonObject body;

        try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
            JsonReader reader = Json.createReader(is);
            body = reader.readObject();
            JsonObject response = Json.createObjectBuilder()
                                        .add("insert_count",1).build();
                                        // .add("id",<Redis Key>).build();
            return ResponseEntity.internalServerError().body(response.toString());

        } catch (Exception e) {
            body = Json.createObjectBuilder()
                        .add("404 file not found", e.getMessage()).build();
        return ResponseEntity.internalServerError().body(body.toString());

        }
    }


    // Sample Reference from SSFWorkshop14 //
    // @GetMapping("/")
    // public String showAddressbookForm(Model model){
    //     model.addAttribute("contact", new Contact());
    //     return"addressbook";
    // }
    // @PostMapping("/addressbook")
    // public String saveContact(@ModelAttribute Contact contact, Model model){
    //     Contact c = new Contact(
    //             contact.getName(),
    //             contact.getEmail(),
    //             contact.getPhoneNum());
    //     service.save(c);
    //     model.addAttribute("contact", c);
    //     return "showContact";
    // }

}
