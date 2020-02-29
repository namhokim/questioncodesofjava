package com.example.springboot.sandbox.naver.juin483.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Order {
	@Id
	private Long id;

	private String item;
}
