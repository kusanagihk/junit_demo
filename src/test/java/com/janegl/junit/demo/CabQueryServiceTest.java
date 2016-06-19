package com.janegl.junit.demo;

import com.janegl.junit.demo.dao.ICabDao;
import com.janegl.junit.demo.model.CabUnit;
import com.janegl.junit.demo.service.CabQueryService;
import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jl on 19/6/16.
 */
public class CabQueryServiceTest extends AbstractJUnitTest {

    static Logger log = Logger.getLogger(CabQueryServiceTest.class);

    /**
     * mock the ICabDao instance
     */
    @Mock
    ICabDao cabDao;
    /**
     * a rule for mockito to init in this junit
     */
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Before
    public void prepareMocks() {
        List<CabUnit> cabUnits = new ArrayList<CabUnit>();

        cabUnits.add(new CabUnit("cab_111", "johnny deepe", "abc1234", 5, "Abbey Road 12"));
        cabUnits.add(new CabUnit("cab_234", "tony stark", "28948da", 3, "Omni Bay, 15th"));
        cabUnits.add(new CabUnit("cab_961", "elize", "jfujj111", 4, "Granny's cottage, 27th, avenue 1"));

        // defining what to return when the queryAll method is invoked
        Mockito.when(cabDao.queryAll()).thenReturn(cabUnits);
    }

    @Test
    public void queryCabList() {
        this.logMethodStart(log, "queryCabList");
        List<CabUnit> cabList;
        CabQueryService cabService = new CabQueryService();

        cabService.setCabDao(this.cabDao);

        cabList = cabService.queryCabList();
        Assert.assertThat("cabList should be non null", cabList, CoreMatchers.notNullValue());
        Assert.assertThat("cabList should have values", cabList.isEmpty(), CoreMatchers.is(false));
        for (CabUnit unit : cabList) {
            log.info(unit);
        }
        // verfiy if the queryAll method has been called instead
        Mockito.verify(cabDao).queryAll();

        this.logMethodEnd(log, "queryCabList");
    }

    @Test
    public void queryCabListByPosition() {
        this.logMethodStart(log, "queryCabListWithFilters");
        List<CabUnit> cabList;
        CabQueryService cabService = new CabQueryService();

        cabService.setCabDao(this.cabDao);
        cabList = cabService.queryCabListByPosition("avenue", false);
        Assert.assertThat("cab list should have entries based on position filter", cabList, CoreMatchers.notNullValue());
        Assert.assertThat("cab list should have entries based on position filter", cabList.isEmpty(), CoreMatchers.is(false));
        for (CabUnit unit : cabList) {
            log.info(unit);
        }
        // verfiy if the queryAll method has been called instead
        Mockito.verify(cabDao).queryAll();

        this.logMethodEnd(log, "queryCabListWithFilters");
    }

}
