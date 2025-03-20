package Spring_boot1.project_boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import Spring_boot1.project_boot.dto.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
