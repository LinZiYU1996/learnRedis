package com.lin.bootredis.controller;

import com.lin.bootredis.entity.Person;
import com.lin.bootredis.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/11
 * \* Time: 16:09
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private IPersonService personService;
    @GetMapping("/id")
    public String getUser(@Param("id") Long id) {
//        System.out.println(id);
        Person person = personService.getPersonByID(id);
//        log.info(person.toString());
        return "LLL";
    }
//    @PostMapping
//    public ResponseEntity<String> createUser(@RequestBody Person user) {
//        personService.addUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body("SUCCESS");
//    }

    @PutMapping("/update")
    public String updateUser(@Param("id") Long id) {

        Person person = new Person();
        person.setId(1L);
        person.setAge(1526);
        person.setAddress("chinae");
        person.setName("Jav bdjjdi su");
        personService.updatePerosn(person);

        return "aaa";

    }
    @DeleteMapping("/id")
    public String deleteUser(@Param("id") Long id) {
        personService.deleteById(id);
        return "success";
    }





}
