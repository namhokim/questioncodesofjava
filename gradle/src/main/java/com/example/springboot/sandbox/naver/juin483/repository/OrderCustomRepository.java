package com.example.springboot.sandbox.naver.juin483.repository;

public interface OrderCustomRepository {
	void save(Order order);

	Order findOne(Long id);
}
