package uk.gorodny.jmsdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/// @XmlRootElement(name = "user"), @XmlElement ///
/// нужны для сериализации в XML //////////////////
/// При сериализации в JSON эти анотации убрать ///

@Getter
@Setter
@ToString
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlElement
    private String name;

    @XmlElement
    private int age;
}
