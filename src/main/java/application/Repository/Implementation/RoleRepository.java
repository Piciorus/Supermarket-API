package application.Repository.Implementation;

import application.Model.Role;
import application.Repository.Interface.IRoleRepository;

import java.util.Set;

public class RoleRepository implements IRoleRepository {
    private final IRoleRepository roleRepository;

    public RoleRepository(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Set<Role> findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
