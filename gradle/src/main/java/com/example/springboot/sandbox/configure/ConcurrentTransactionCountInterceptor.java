package com.example.springboot.sandbox.configure;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.BaseUnits;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class ConcurrentTransactionCountInterceptor extends HandlerInterceptorAdapter {
	private final Counter counter;

	/**
	 * see
	 * io.micrometer.core.instrument.Counter.Builder#register(io.micrometer.core.instrument.MeterRegistry)
	 * io.micrometer.core.instrument.binder.jvm.JvmGcMetrics#bindTo(io.micrometer.core.instrument.MeterRegistry)
	 */
	public ConcurrentTransactionCountInterceptor(MeterRegistry meterRegistry) {
//		this.counter = meterRegistry.counter("transaction.current.count");
		this.counter = Counter.builder("transaction.current.count")
			.tags(Collections.emptyList())
			.baseUnit(BaseUnits.OPERATIONS)
			.description("Count of positive increases in the before request")
			.register(meterRegistry);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		counter.increment();
		return true;
	}

}
