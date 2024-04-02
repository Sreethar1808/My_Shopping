package com.My_Shopping.My_Shopping.Repository;

import com.My_Shopping.My_Shopping.models.OrderTable;
import org.hibernate.boot.model.source.spi.Orderable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<OrderTable, UUID>{

}

