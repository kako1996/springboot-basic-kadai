package com.example.springkadaitodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer Id;

	@Column(name = "title")
	private String Title;

	@Enumerated(EnumType.STRING)
	@Column(name = "priority")
	private Priority Priority;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status Status;
	
	//Enumの定義
	public enum Priority {
		高, 中, 低
	}
	
	public enum Status {
		未着手, 着手中, 完了
	}

}
