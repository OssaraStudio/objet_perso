package com.sarus.ojet_perso.Thing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Long> {
}
