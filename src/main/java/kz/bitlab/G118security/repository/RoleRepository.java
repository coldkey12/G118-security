package kz.bitlab.G118security.repository;

import kz.bitlab.G118security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r where r.name='ROLE_USER'")
    Role findUserRole();
}
