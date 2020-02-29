package com.example.springboot.sandbox.naver.juin483.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {

	private final EntityManager entityManager;

	@Override
	public void save(Order order) {
		entityManager.persist(order);
	}

	@Override
	public Order findOne(Long id) {
		return entityManager.find(Order.class, id);
	}

}
