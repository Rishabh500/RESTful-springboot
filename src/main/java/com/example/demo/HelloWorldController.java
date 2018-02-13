package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@SuppressWarnings("unused")
@RestController
public class HelloWorldController {

	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World1";
	}
	
	@GetMapping(path="/hello-world-bean")
	public Object helloWorldBEan() {
		return new HelloWorldBean("helloWorld");
	}
	
	@GetMapping(path = "/hello-world-bean/path/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(name);

	}
}
