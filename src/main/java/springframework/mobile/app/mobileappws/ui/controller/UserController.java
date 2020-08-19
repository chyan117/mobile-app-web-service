package springframework.mobile.app.mobileappws.ui.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {


    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public String createUser(){
        return "post user was createsd";
    }

    @PutMapping
    public String updateUser(){
        return "update";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete";
    }
}
