package secondProject.secondProject.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.service.RoleService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
@Validated
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<?> roleCreate(@Valid @RequestBody Role role){
        var name = role.getName();
        var RoleExists = roleService.getByRoleName(name);
        if (RoleExists.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(name + " already exists");

        }

        roleService.roleCreate(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(name + " Successfully created") ;

    }

    @DeleteMapping("/delete/{id}")
    public void roleDelete(@PathVariable Long id){
        roleService.roleDelete(id);
    }

    @GetMapping("/list")
    public List<Role> roleList(){
        return roleService.roleList();
    }




}
