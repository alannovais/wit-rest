package com.challenger.wit.rest.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import constants.RabbitMQConstants;

@Component
public class CalculatorRabbitMQConsumer {
	
	public String outputResult;
	
	@RabbitListener(queues = RabbitMQConstants.RESULT_SUM_QUEUE)
	private void consumerSum(String mensagem) throws JsonProcessingException, InterruptedException {
		this.outputResult = mensagem;
	}
	
	@RabbitListener(queues = RabbitMQConstants.RESULT_SUB_QUEUE)
	private void consumerSub(String mensagem) throws JsonProcessingException, InterruptedException {
		this.outputResult = mensagem;
	}
	
	@RabbitListener(queues = RabbitMQConstants.RESULT_MULT_QUEUE)
	private void consumerMult(String mensagem) throws JsonProcessingException, InterruptedException {
		this.outputResult = mensagem;
	}
	
	@RabbitListener(queues = RabbitMQConstants.RESULT_DIV_QUEUE)
	private void consumerDiv(String mensagem) throws JsonProcessingException, InterruptedException {
		this.outputResult = mensagem;
	}
	
	public Integer getData() throws InterruptedException {
		Thread.sleep(200);
		return Integer.parseInt(this.outputResult);
	}
}
