package repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entities.Dept;

@Repository
public interface DeptRepository extends CrudRepository<Dept, Integer > 
{

}
