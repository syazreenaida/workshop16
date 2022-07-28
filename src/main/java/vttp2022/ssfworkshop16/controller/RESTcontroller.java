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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2022.ssfworkshop16.model.Welcome4;
import vttp2022.ssfworkshop16.services.redisService;

@RestController
@RequestMapping(path = "/", produces="checkers/json")
public class RESTcontroller {

    @Autowired
    redisService service;

    @GetMapping("/api/boardgame/{boardGame}")
    public ResponseEntity<Welcome4> getBoardGame(@PathVariable(value="boardGame") String boardGame){
        Welcome4 w4 = service.BoardGame(boardGame);
        // JsonObject resp = Json.createObjectBuilder()
        //                         .add("name", user.getName())
        //                         .build();
        return ResponseEntity.ok(w4);
    }

    @PostMapping(path="/api/boardgame", consumes="checkers/json")
    public ResponseEntity<Welcome4> createBoardGameSession(@RequestBody Welcome4 welcome4) {
        try (InputStream is = new ByteArrayInputStream(((Welcome4) welcome4).getPieces())) {
            JsonObject body;
            JsonReader reader = Json.createReader(is);
            body = reader.readObject();
            JsonObject response = Json.createObjectBuilder()
                                        .add("insert_count",1).build();
                                        // .add("id",<Redis Key>).build();
            return ResponseEntity.ok(welcome4);

        } catch (Exception e) {
            System.out.println(e); 
            
        }
        return null;
    }

    @PutMapping(path = "/{boardGame}")
    public ResponseEntity<JsonObject> updateGameBoard(@RequestBody JsonObject welcome4, @PathVariable JsonObject boardGame) {
        int w4Result = service.update(welcome4);
        if (w4Result > 0) ((Welcome4) welcome4).setUpdateCount(w4Result);
        return ResponseEntity.ok(welcome4);
    }
}  



    // // TODO PutMapping 
    // @PutMapping("/api/boardgame/{boardGame}")
    // public ResponseEntity<Welcome4> updateBoardGameSession(@PathVariable(value="boardGame") @RequestBody Welcome4 welcome4){
    //     JsonObject body;
    //     Boolean upsert = false;
    //     if (!upsert){
    //         try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
    //             JsonReader reader = Json.createReader(is);
    //             body = reader.readObject();
    //             JsonObject response = Json.createObjectBuilder()
    //                                         .add("update_count",1).build();
    //                                         // .add("id",<Redis Key>).build();
    //             return ResponseEntity.created(null).body(response.toString() + " 200 file successfully updated");
    
    //         } catch (Exception e) {
    //             body = Json.createObjectBuilder()
    //                         .add("400 file not found", e.getMessage()).build();
    //         return ResponseEntity.internalServerError().body(body.toString());
    
    //         }
    //     }
    //     return null;  //TODO method
    // }


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


