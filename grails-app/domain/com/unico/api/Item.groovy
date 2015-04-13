package com.unico.api


import grails.rest.Resource

@Resource(uri = "/api/integerPair", formats = ['json', 'xml'])
class Item {

    Integer i1;
    Integer i2;

    static constraints = {
    }
}
