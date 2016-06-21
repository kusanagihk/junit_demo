package com.janegl.junit.demo.service;

import com.janegl.junit.demo.dao.ICabDao;
import com.janegl.junit.demo.model.CabUnit;

import java.util.List;

/**
 * Created by jl on 19/6/16.
 */
public class CabQueryService {

    ICabDao cabDao;

    public void setCabDao(ICabDao dao) {
        this.cabDao = dao;
    }


    public List<CabUnit> queryCabList() {
        return this.cabDao.queryAll();
    }

    public List<CabUnit> queryCabListByPosition(String clause, boolean isExactMatch) {
        List<CabUnit> lst = this.cabDao.queryAll();

        for (int idx = lst.size() - 1; idx >= 0; idx--) {
            CabUnit unit = lst.get(idx);

            if (unit.cabLocation == null || unit.cabLocation.isEmpty()) {
                continue;
            }

            if (isExactMatch) {
                if (!unit.cabLocation.equalsIgnoreCase(clause)) {
                    lst.remove(idx);
                }
            } else {
                if (unit.cabLocation.toLowerCase().indexOf(clause.toLowerCase()) == -1) {
                    lst.remove(idx);
                }
            }   // end -- if (exactMatch?)
        }
        return lst;
    }

}
