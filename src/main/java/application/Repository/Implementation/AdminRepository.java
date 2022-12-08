package application.Repository.Implementation;

import application.Model.Admin;
import application.Repository.Interface.IAdminRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdminRepository implements IAdminRepository {
    private List<Admin> adminList;

    public AdminRepository(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @Override
    public void add(Admin admin) {
        adminList.add(admin);
    }

    @Override
    public void deleteById(int id) {
        adminList.remove(id);
    }

    @Override
    public void getById(int id) {
        adminList.get(id);
    }

    @Override
    public List<Admin> getAll() {
        return adminList;
    }
}
