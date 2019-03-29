package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer > 
{
	List<Dept> findByLoc(String loc);
}
