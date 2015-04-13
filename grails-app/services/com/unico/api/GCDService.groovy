package com.unico.api

import grails.transaction.Transactional

@Transactional
class GCDService {

    static expose = ['cxf']

    def rabbitTemplate

    GCD gcd() {
        Item item=Item.last()
        GCD gcd=null
        if(item) {
            gcd = new GCD(i1: item.i1, i2: item.i2, gcd: calculateGcd(item.i1, item.i2))
            item.delete()
        }
        return gcd
    }

    private int calculateGcd(int i1,int i2){
        if(i2==0){
            return i1
        }

        return calculateGcd(i2,i1%i2)
    }

    GCDS gcdList(){
        List<Item> items=Item.findAll()
        GCDS gcds= new GCDS();
        items.each {Item item->
            GCD gcd = new GCD(i1: item.i1, i2: item.i2, gcd: calculateGcd(item.i1, item.i2))
            gcds.gcds.add(gcd)
        }
        return gcds
    }

    int gcdSum(){
        return gcdList().gcds.gcd.sum()
    }

    boolean push(int i1,int i2){
        try {
            rabbitTemplate.convertAndSend('gcdQueue', [i1: i1, i2: i2])
            return true
        }
        catch (Exception e){
            return false
        }
    }

}
