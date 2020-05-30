package com.hitest.app.services;

import com.hitest.app.entities.Card;
import com.hitest.app.enums.StatusAction;
import com.hitest.app.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository repository;

    public boolean changeStatus(Card card, Integer status){
        if(StatusAction.BLOCK.ordinal() == status) {
            card.setStatusAction(StatusAction.BLOCK);
            card.setText("this card is " +  StatusAction.BLOCK.toString());
        } else if (StatusAction.ACTIVE.ordinal() == status) {
            card.setStatusAction(StatusAction.ACTIVE);
            card.setText("this card is " +  StatusAction.ACTIVE.toString());
        } else if (StatusAction.APPROVED.ordinal() == status) {
            card.setStatusAction(StatusAction.APPROVED);
            card.setText("this card is " +  StatusAction.APPROVED.toString());
        } else if (StatusAction.DISAPPROVED.ordinal() == status) {
            card.setStatusAction(StatusAction.DISAPPROVED);
            card.setText("this card is " +  StatusAction.DISAPPROVED.toString());
        } else {
            card.setStatusAction(StatusAction.GENERAL);
        }
        repository.save(card);
        return true;
    }

    public List<Card> listCards(){
        return repository.findAll();
    }
}
