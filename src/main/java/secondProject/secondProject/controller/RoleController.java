package secondProject.secondProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.service.RoleService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/roleCreate")
    public Role roleCreate(@RequestBody Role role){
        return roleService.roleCreate(role);
    }

    @DeleteMapping("/roleDelete/{id}")
    public void roleDelete(@PathVariable Long id){
        roleService.roleDelete(id);
    }

    @GetMapping("/roleList")
    public List<Role> roleList(){
        return roleService.roleList();
    }



}
