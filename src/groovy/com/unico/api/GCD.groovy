package com.unico.api

import grails.validation.Validateable

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * Created by haiderali on 11/4/15.
 */

@Validateable
@XmlAccessorType(XmlAccessType.NONE)

@XmlRootElement(name = "GCD")
class GCD{
    @XmlElement
    Integer i1;
    @XmlElement
    Integer i2;
    @XmlElement
    Integer gcd;
}
