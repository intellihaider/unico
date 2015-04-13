package com.unico.api

import grails.validation.Validateable

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by haiderali on 13/4/15.
 */
@Validateable

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "GCDS")
class GCDS{

    @XmlElement
    List<GCD> gcds =[];

}
