package com.igor.bondezam.teste.converter;

import com.igor.bondezam.teste.interfaces.ConverterReqResInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CrudConverter<E, EREQ, ERES> implements ConverterReqResInterface<E, EREQ, ERES> {

    @Override
    public E reqToEntity(EREQ ereq) {
        E source = (E) new Object();
        EREQ target = (EREQ) new Object();
        BeanUtils.copyProperties(source, target);
        return source;
    }

    @Override
    public E resToEntity(ERES eres) {
        E source = (E) new Object();
        ERES target = (ERES) new Object();
        BeanUtils.copyProperties(source, target);
        return source;
    }

    @Override
    public EREQ entityToReq(E entity) {
        EREQ source = (EREQ) new Object();
        E target = (E) new Object();
        BeanUtils.copyProperties(source, target);
        return source;
    }

    @Override
    public ERES entityToRes(E entity) {
        ERES source = (ERES) new Object();
        E target = (E) new Object();
        BeanUtils.copyProperties(source, target);
        return source;
    }
}
