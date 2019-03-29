package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import entities.Dept;

@Repository
@RestResource(path="/dept")
public interface DeptRepository extends JpaRepository<Dept, Integer > 
{
		public List<Dept> findByLoc(String loc);
}
