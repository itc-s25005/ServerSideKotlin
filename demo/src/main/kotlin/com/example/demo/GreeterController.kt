package com.example.demo

import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeter")
class GreeterController(
    private val greeter: Greeter,
    private val messageSource: MessageSource
) {
    @GetMapping ("/hello")
    fun hello(@RequestParam name: String): HelloResponse{
        return HelloResponse("Hello $name")
    }

    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable name: String): HelloResponse{
        return HelloResponse("Hello $name")
    }

    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse{
        return HelloResponse("(POST)Hello ${request.name}")
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String): HelloResponse{
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }
}