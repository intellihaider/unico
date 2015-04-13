package com.unico.api

import grails.converters.JSON

class GCDController {

    def GCDService

    def list() {
        List<Item> item=Item.findAll()
        render text:  item as JSON, contentType: 'application/json'
    }

    def gcd(){
        render text:GCDService.gcd() as JSON, contentType:  'application/json'
    }

    def gcdList(){
        render text:GCDService.gcdList() as JSON, contentType:  'application/json'
    }

    def gcdSum(){
        render text: GCDService.gcdSum(), contentType: 'application/json'
    }

    def push(){
        if(params.i1&&params.i2&&GCDService.push(params.i1.toInteger(),params.i2.toInteger())){
            render "success"
        }
        else {
            render "failure"
        }
    }
}
