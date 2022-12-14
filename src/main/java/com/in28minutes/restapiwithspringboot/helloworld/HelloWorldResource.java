package com.in28minutes.restapiwithspringboot.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	@RequestMapping("/hello-world")
	public String helloWorld() {
		return "hello world";
	}
	
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloWorldbean() {
		return new HelloWorldBean("hello world");
	}
	
	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("hello world, " +name);
	}
	
	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean helloWorldPathParam(@PathVariable String name,
			@PathVariable String message) {
		return new HelloWorldBean("hello world, " +name +","+message);
	}
}
