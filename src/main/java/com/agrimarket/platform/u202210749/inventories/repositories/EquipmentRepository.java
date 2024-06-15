package com.agrimarket.platform.u202210749.inventories.repositories;

import com.agrimarket.platform.u202210749.inventories.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsByName_Name(String name);
}
