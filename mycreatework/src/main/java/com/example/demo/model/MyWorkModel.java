package com.example.demo.model;

import com.example.demo.data.MyWorkDataInterface;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "log")
public class MyWorkModel implements MyWorkDataInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String formula;

	//getterやsetter達
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
}