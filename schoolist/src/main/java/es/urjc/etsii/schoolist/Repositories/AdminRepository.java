package es.urjc.etsii.schoolist.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{

}
