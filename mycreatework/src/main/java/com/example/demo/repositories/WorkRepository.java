package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MyWorkModel;

@Repository
public interface WorkRepository extends JpaRepository<MyWorkModel, Integer> {
	public Optional<MyWorkModel> findById(int id);

}
