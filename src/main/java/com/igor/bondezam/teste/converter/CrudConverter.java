package com.igor.bondezam.teste.converter;

public interface CrudConverter<E, REQ, RES> {

    E reqToEntity(REQ req);
    E resToEntity(RES res);
    REQ entityToReq(E entity);
    RES entityToRes(E entity);
}
