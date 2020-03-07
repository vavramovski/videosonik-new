package mk.com.videosonik.store.repository.implementations;

import lombok.AllArgsConstructor;
import mk.com.videosonik.store.model.Admin;
import mk.com.videosonik.store.model.Exceptions.NotFound;
import mk.com.videosonik.store.model.Privileges;
import mk.com.videosonik.store.repository.AdminRepository;
import mk.com.videosonik.store.repository.JPA.AdminRepositoryJPA;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AdminRepositoryImpl implements AdminRepository {
    final AdminRepositoryJPA adminRepositoryJPA;

    @Override
    public void addAdmin(Admin admin) {
        adminRepositoryJPA.save(admin);
    }

    @Override
    public void removeAdmin(Admin admin) {
        adminRepositoryJPA.delete(admin);
    }

    @Override
    public void removeAdminById(String username) {
        adminRepositoryJPA.deleteById(username);
    }

    @Override
    public void changePrivileges(Admin admin, Privileges privileges) {
        Admin old = adminRepositoryJPA.findById(admin.getUsername()).orElseThrow(NotFound::new);

        old.setPrivileges(privileges);
        adminRepositoryJPA.save(old);
    }
}
