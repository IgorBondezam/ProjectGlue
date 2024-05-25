package com.igor.bondezam.teste.interfaces;

import java.io.Serializable;

public interface SaveEntity<ID> extends Serializable {

    ID getId();
    void setId(ID id);
}
