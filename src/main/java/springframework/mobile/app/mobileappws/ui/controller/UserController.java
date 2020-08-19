package springframework.mobile.app.mobileappws.ui.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springframework.mobile.app.mobileappws.ui.model.request.UpdateUserDetailRequestModel;
import springframework.mobile.app.mobileappws.ui.model.request.UserDetailRequestModel;
import springframework.mobile.app.mobileappws.ui.model.response.UserRest;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;
    @GetMapping
    public String getUserParam(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "limit", defaultValue = "50") int limit){
        return "string " + page + limit;
    }

    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUserId(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetailRequestModel){
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetailRequestModel.getEmail());
        userRest.setFirstName(userDetailRequestModel.getFirstName());
        userRest.setLastName(userDetailRequestModel.getLastName());
        String userId = UUID.randomUUID().toString();
        userRest.setUserId(userId);
        if(users==null){
            users = new HashMap<>();
        }
        users.put(userId,userRest);
        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }


    @PutMapping(path = "/{userId}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                ,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest updateUser(@PathVariable String userId,@Valid @RequestBody UpdateUserDetailRequestModel UpdateuserDetailRequestModel){
        UserRest sotreUserDatail=users.get(userId);
        sotreUserDatail.setFirstName(UpdateuserDetailRequestModel.getFirstName());
        sotreUserDatail.setLastName(UpdateuserDetailRequestModel.getLastName());
        users.put(userId, sotreUserDatail);
        return sotreUserDatail;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
