package secondProject.secondProject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.entity.User;
import secondProject.secondProject.dto.UserDto;
import secondProject.secondProject.repository.RoleRepository;
import secondProject.secondProject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;

    public User userCreate(UserDto userDto){

        User newUser = new User();

        var name = userDto.getName();
        newUser.setName(name);

        var lastName = userDto.getLastName();
        newUser.setLastName(lastName);

        var role_id = userDto.getRole_id();
        Optional<Role> role = roleService.getById(role_id);

        if(role.isEmpty()){

        }

        newUser.setRole(role.get());

        return userRepository.save(newUser);
    }

    public void userDelete(Long id){
        userRepository.deleteById(id);
    }

    public List<User> userList(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }
    public List<User> findByRoleName(String name){
        return userRepository.findByRoleName(name);
    }

    public User updateUser(Long id, UserDto userDto){
        Optional<User> user = userRepository.findById(id);

        if(!user.isEmpty()){
            var name = userDto.getName();

            var lastName = userDto.getLastName();

            var role_id = userDto.getRole_id();
            Optional<Role> role = roleService.getById(role_id);

            if(!role.isEmpty()){
                user.get().setRole(role.get());
            }

            if(name != null && !name.equals(""))
                user.get().setName(name);

            if(lastName != null && !lastName.equals(""))
                user.get().setLastName(lastName);


        }

        return userRepository.save(user.get());
    }


}
