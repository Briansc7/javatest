package secondProject.secondProject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import secondProject.secondProject.entity.Role;
import secondProject.secondProject.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role roleCreate(Role role){
        return roleRepository.save(role);
    }

    public void roleDelete(Long id){
        roleRepository.deleteById(id);
    }

    public List<Role> roleList(){
        return roleRepository.findAll();
    }

    public Optional<Role> getById(Long id){
        return roleRepository.findById(id);
    }
}
