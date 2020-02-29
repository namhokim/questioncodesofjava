package com.example.springboot.sandbox.naver.juin483;

import com.example.springboot.sandbox.naver.juin483.repository.Order;
import com.example.springboot.sandbox.naver.juin483.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;

	public void save(Order order) {
		orderRepository.save(order);
	}

	public Order findOne(Long id) {
		Optional<Order> orderOptional = orderRepository.findById(id);
		return orderOptional.orElseThrow(OrderNotFoundException::new);
	}
}
