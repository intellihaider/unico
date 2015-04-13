import com.unico.api.GCD
import com.unico.api.GCDS
import com.unico.api.Item
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->


        Item.count() == 0 && [[32,4], [21,24], [23,13], [12,16], [14,49]].each {
            println(it)
            Item.findOrSaveWhere(i1: it[0], i2: it[1])

            JSON.registerObjectMarshaller(Item){
                Map item=[:]
                ['i1','i2'].each {name->
                    item.put(name,it[name])
                }
                return item
            }

            JSON.registerObjectMarshaller(GCD){
                Map item=[:]
                ['gcd','i1','i2'].each {name->
                    item.put(name,it[name])
                }
                return item
            }

            JSON.registerObjectMarshaller(GCDS){
                Map item=[:]
                ['gcds'].each {name->
                    item.put(name,it[name])
                }
                return item
            }


        }


    }
    def destroy = {
    }
}
