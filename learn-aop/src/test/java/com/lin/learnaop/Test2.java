package com.lin.learnaop;

import com.lin.learnaop.demo_3.entity.Person;
import com.lin.learnaop.demo_3.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 11:08
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test2 {


    @Autowired
    private IPersonService personService;


    @Test
    public void t1() {

        Person person = new Person();

        person.setAge(155);

        person.setName("aa");


        personService.insertPerson(person);


    }



}
