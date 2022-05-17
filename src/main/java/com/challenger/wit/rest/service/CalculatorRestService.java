package com.challenger.wit.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenger.wit.rest.consumer.CalculatorRabbitMQConsumer;
import com.challenger.wit.rest.dto.InputsCalculator;

import constants.RabbitMQConstants;
import dto.ResultCalculator;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/api")
public class CalculatorRestService {

	@Autowired
	private RabbitMQSendMessage rabbitMQSendMessage;

	@Autowired
	private CalculatorRabbitMQConsumer calculatorRabbitMQConsumer;

	@GetMapping("")
	public String working() {
		return "It's Working!";
	}
	
	@GetMapping("/sum")
	public ResultCalculator sumValues(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b) throws InterruptedException {
		InputsCalculator inputsCalculator = new InputsCalculator();
		ResultCalculator resultCalculator = new ResultCalculator();
		inputsCalculator.setA(a);
		inputsCalculator.setB(b);
		this.rabbitMQSendMessage.sendMessage(RabbitMQConstants.SUM_QUEUE, inputsCalculator);
		resultCalculator.result = this.calculatorRabbitMQConsumer.getData();
		return resultCalculator;
	}

	@GetMapping("/sub")
	public ResultCalculator subValues(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b) throws InterruptedException {
		InputsCalculator inputsCalculator = new InputsCalculator();
		ResultCalculator resultCalculator = new ResultCalculator();
		inputsCalculator.setA(a);
		inputsCalculator.setB(b);
		this.rabbitMQSendMessage.sendMessage(RabbitMQConstants.SUB_QUEUE, inputsCalculator);
		resultCalculator.result = this.calculatorRabbitMQConsumer.getData();
		return resultCalculator;
	}

	@GetMapping("/mult")
	public ResultCalculator multValues(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b) throws InterruptedException {
		InputsCalculator inputsCalculator = new InputsCalculator();
		ResultCalculator resultCalculator = new ResultCalculator();
		inputsCalculator.setA(a);
		inputsCalculator.setB(b);
		this.rabbitMQSendMessage.sendMessage(RabbitMQConstants.MULT_QUEUE, inputsCalculator);
		resultCalculator.result = this.calculatorRabbitMQConsumer.getData();
		return resultCalculator;
	}

	@GetMapping("/div")
	public ResultCalculator divValues(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b) throws InterruptedException {
		InputsCalculator inputsCalculator = new InputsCalculator();
		ResultCalculator resultCalculator = new ResultCalculator();
		inputsCalculator.setA(a);
		inputsCalculator.setB(b);
		this.rabbitMQSendMessage.sendMessage(RabbitMQConstants.DIV_QUEUE, inputsCalculator);
		resultCalculator.result = this.calculatorRabbitMQConsumer.getData();
		return resultCalculator;
	}

}
