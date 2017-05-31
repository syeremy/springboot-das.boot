package com.syeremy.repository;

import com.syeremy.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by syeremy on 5/30/17.
 */
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {
}
