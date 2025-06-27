package com.example.ArtWork.model;

import jakarta.persistence.*;

@Entity
@Table(name = "judge")
public class Judge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable=false)
	private String name;

	public Judge() {
		super();
	}

	public Judge(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Judge [Id=" + Id + ", name=" + name + "]";
	}

}
