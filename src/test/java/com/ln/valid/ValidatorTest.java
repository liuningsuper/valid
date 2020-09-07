package com.ln.valid;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ValidatorTest {
    @Autowired
    private Validator validator;

    public class Order {
        @NotEmpty
        private String orderName;

        @NotNull
        @Valid //这个注解可以让 关联的对象内的属性在检验Order时 也被检验
        private OrderItem orderItem;

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

        public OrderItem getOrderItem() {
            return orderItem;
        }

        public void setOrderItem(OrderItem orderItem) {
            this.orderItem = orderItem;
        }
    }


    public class OrderItem {
        @NotEmpty
        private String itemName;

        @NotEmpty
        @Pattern(regexp="\\d+")
        private String itemCode;

        @NotEmpty
        @Email(message = "后端的东西真多")
        private String email;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    @Test
    public void contextLoads(){

        validator = Validation.byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();
        Order order = new Order();
        OrderItem item = new OrderItem();
        item.setEmail("12345@");
        item.setItemCode("123456");
        item.setItemCode("123456");
        item.setItemName("love");
        order.setOrderItem(item);
        Set<ConstraintViolation<Order>> result = validator.validate(order);
        if (result.size()>0)
        {
            Iterator<ConstraintViolation<Order>> it = result.iterator();
            while(it.hasNext()){
                ConstraintViolation<Order> str = it.next();
                System.out.println(str.getMessage()+"\n");
            }
        }
    }
}

