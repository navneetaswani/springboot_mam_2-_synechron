package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entities.Emp;
@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> 
{
	List<Emp> findByProject(String project);
	List<Emp> findByProjectAndEname(String project, String ename);
	List<Emp> findByProjectOrEname(String project, String ename);
	List<Emp> findBySalaryBetween(double min, double max);
	@Query(value="select e from  Emp e where e.project = ?1")
	List<Emp> findByProj(String project);
}
