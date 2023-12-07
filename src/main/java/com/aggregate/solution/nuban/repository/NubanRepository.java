package com.aggregate.solution.nuban.repository;

import com.aggregate.solution.nuban.entity.Nuban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 1:28:23 PM
 */
@Repository
public interface NubanRepository extends JpaRepository<Nuban, Integer>
{

}
