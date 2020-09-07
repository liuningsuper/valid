package com.ln.valid;

import org.hibernate.validator.HibernateValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;

import javax.validation.Validation;
import javax.validation.Validator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GroupTest {

    @Autowired
    private Validator validator;

    @Test
    public void test(){
        validator = Validation.byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();
        SegmentVo vo = new SegmentVo();
        //AvailableFlightGroup
        vo.setDeptCity("");
        //DestinationFlightGroup
        vo.setArrCity("");
        //Default
        vo.setDeptDate("20141026");
        vo.setArrDate("123456");
        vo.setEmail("12345");
        vo.setFlag(true);
        Set<ConstraintViolation<SegmentVo>> result = new HashSet<ConstraintViolation<SegmentVo>>();
//        result.addAll(validator.validate(vo, DestinationFlightGroup.class));
//        result.addAll(validator.validate(vo, AvailableFlightGroup.class));
        result.addAll(validator.validate(vo));
        if (result.size()>0)
        {
            Iterator<ConstraintViolation<SegmentVo>> it = result.iterator();
            while(it.hasNext()){
                ConstraintViolation<SegmentVo> str = it.next();
                System.out.println(str.getMessage()+"\n");
            }
        }
    }
}
