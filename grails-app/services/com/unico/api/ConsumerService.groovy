package com.unico.api

import grails.transaction.Transactional

@Transactional
class ConsumerService {

    static  rabbitQueue = 'gcdQueue'


    void handleMessage(message) {

        Item item=new Item(i1: message.get("i1"),i2: message.get("i2"))
        if(item.validate()){
            item.save()
        }

    }
}
