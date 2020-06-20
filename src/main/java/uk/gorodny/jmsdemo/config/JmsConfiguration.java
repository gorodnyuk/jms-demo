package uk.gorodny.jmsdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import uk.gorodny.jmsdemo.model.User;

@Configuration
public class JmsConfiguration {

    //////////////////////
    /// JSON converter ///
    //////////////////////

    //    @Bean
    //    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
    //        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    //        converter.setTypeIdPropertyName("content-type");
    //        converter.setTypeIdMappings(Collections.singletonMap("user", User.class));
    //        return converter;
    //    }

    //////////////////////
    /// XML converter ////
    //////////////////////

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(new Class[]{User.class});
        return marshaller;
    }

    @Bean
    MessageConverter messageConverter(Jaxb2Marshaller marshaller) {
        MarshallingMessageConverter converter = new MarshallingMessageConverter();
        converter.setMarshaller(marshaller);
        converter.setUnmarshaller(marshaller);
        return converter;
    }
}
