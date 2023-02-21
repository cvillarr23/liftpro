package com.cvillarreal.liftpro

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping


@RestController
@RequestMapping("api/status")
class StatusController {

    @GetMapping
    fun getStatus(): String = "LiftPro API is currently running!"
}