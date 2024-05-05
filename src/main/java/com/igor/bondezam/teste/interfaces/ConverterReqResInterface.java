package com.igor.bondezam.teste.interfaces;

public interface ConverterReqResInterface<E, REQ, RES> {

    E reqToEntity(REQ req);
    E resToEntity(RES res);
    REQ entityToReq(E entity);
    RES entityToRes(E entity);
}
