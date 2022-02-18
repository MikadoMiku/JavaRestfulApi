package repo.contracts;

import models.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByRoleName(String name);
}
