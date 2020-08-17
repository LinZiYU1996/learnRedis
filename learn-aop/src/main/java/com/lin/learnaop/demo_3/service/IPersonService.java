package com.lin.learnaop.demo_3.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.learnaop.demo_3.entity.Person;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lin
 * @since 2020-08-16
 */
public interface IPersonService extends IService<Person> {


    int insertPerson(Person person);

}
