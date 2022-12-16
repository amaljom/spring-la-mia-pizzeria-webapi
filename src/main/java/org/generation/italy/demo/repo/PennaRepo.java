package org.generation.italy.demo.repo;

import org.generation.italy.demo.pojo.Penna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PennaRepo extends JpaRepository<Penna, Integer>{

}
