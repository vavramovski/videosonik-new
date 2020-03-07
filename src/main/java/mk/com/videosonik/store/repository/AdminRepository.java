package mk.com.videosonik.store.repository;

import mk.com.videosonik.store.model.Admin;
import mk.com.videosonik.store.model.Privileges;

public interface AdminRepository {

    void addAdmin(Admin admin);

    void removeAdmin(Admin admin);

    void removeAdminById(String username);

    void changePrivileges(Admin admin, Privileges privileges);

}
