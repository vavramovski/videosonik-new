package mk.com.videosonik.store.service;

import mk.com.videosonik.store.model.Admin;
import mk.com.videosonik.store.model.Privileges;

import java.util.List;

public interface AdminRepository {
    void addAdmin(Admin admin);

    void deleteAdmin(Admin admin);

    void deleteAdminById(String username);

    void editPrivileges(Admin admin, Privileges privileges);

    List<Admin> getAllAdmin();
}
