package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
