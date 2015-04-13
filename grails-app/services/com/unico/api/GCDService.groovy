package com.unico.api

import grails.transaction.Transactional

@Transactional
class GCDService {

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

    List<GCD> gcdList(){
        List<Item> items=Item.findAll()
        List<GCD> gcdList=[]
        items.each {Item item->
            GCD gcd = new GCD(i1: item.i1, i2: item.i2, gcd: calculateGcd(item.i1, item.i2))
            gcdList.add(gcd)
        }
        return gcdList
    }

    int gcdSum(){
        return gcdList().gcd.sum()
    }

    boolean push(int i1,int i2){
        Item item=new Item(i1: i1,i2: i2)
        if(item.validate()){
            item.save()
            return true
        }
        return false
    }

}
