package com.infoplus.hopital.repository.specifications.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
public class Filter<F> implements Serializable {

    private static  final long serialVersionUID =1L;
    private F equals;
    private F like;
    private F notEquals;
    private List<F> in;
    private List<F> notIn;
}
