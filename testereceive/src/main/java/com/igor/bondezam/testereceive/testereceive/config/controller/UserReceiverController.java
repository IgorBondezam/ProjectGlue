package com.igor.bondezam.testereceive.testereceive.config.controller;

import com.igor.bondezam.testereceive.testereceive.config.domain.UserReceiver;
import com.igor.bondezam.testereceive.testereceive.config.service.UserReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("receiver")
public class UserReceiverController {

    @Autowired
    private UserReceiverService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserReceiver> getFakeUserReceiver(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getReceiver(id));
    }
}