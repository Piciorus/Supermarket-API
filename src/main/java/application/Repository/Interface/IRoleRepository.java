package application.Repository.Interface;

import application.Model.Role;

import java.util.Set;

public interface IRoleRepository {
    Set<Role> findByRole(String role);
}
