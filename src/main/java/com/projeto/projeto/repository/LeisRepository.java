package com.projeto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.projeto.model.*;

@Repository
public interface LeisRepository extends JpaRepository<LeisModel,Long>{

}
