package com.hitest.app.controllers;

import com.hitest.app.entities.Card;
import com.hitest.app.enums.StatusAction;
import com.hitest.app.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/status")
public class CardController {
    @Autowired
    CardService service;

    @RequestMapping(
            path = "/change/{status}",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity changeStatus(@RequestBody Card card, @PathVariable Integer status) {
        ResponseEntity responseEntity;
        service.changeStatus(card, status);
        responseEntity = new ResponseEntity(card, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity listCards() {
        List<Card> cards = service.listCards();
        ResponseEntity responseEntity = new ResponseEntity(cards, HttpStatus.OK);
        return responseEntity;
    }

}
