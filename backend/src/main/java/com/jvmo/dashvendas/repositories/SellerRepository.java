package com.jvmo.dashvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvmo.dashvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}