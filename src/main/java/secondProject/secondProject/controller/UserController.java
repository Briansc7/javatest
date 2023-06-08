package secondProject.secondProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secondProject.secondProject.dto.UserDto;
import secondProject.secondProject.entity.User;
import secondProject.secondProject.service.UserService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public User userCreate(@RequestBody UserDto userDto){
        return  userService.userCreate(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> userDelete(@PathVariable Long id){
        Optional<User> userToDelete = userService.getById(id);
        if(userToDelete.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User of id: "+id+" to delete not found");
        }

        userService.userDelete(id);

        return ResponseEntity.status(HttpStatus.OK).body("User of id: "+id+" deleted");
    }

    @GetMapping("/list")
    public List<User> userList(){
        return userService.userList();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        return userService.updateUser(id, userDto);
    }


}
