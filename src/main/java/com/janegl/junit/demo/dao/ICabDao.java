package com.janegl.junit.demo.dao;

import com.janegl.junit.demo.model.CabUnit;

import java.util.List;

/**
 * Created by jl on 19/6/16.
 */
public interface ICabDao {

    List<CabUnit> queryAll();
}
