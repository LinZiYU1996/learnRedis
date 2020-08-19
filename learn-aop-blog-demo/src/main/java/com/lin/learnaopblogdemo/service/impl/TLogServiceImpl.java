package com.lin.learnaopblogdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.learnaopblogdemo.entity.TLog;
import com.lin.learnaopblogdemo.mapper.TLogMapper;
import com.lin.learnaopblogdemo.service.ITLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-08-18
 */
@Service
public class TLogServiceImpl extends ServiceImpl<TLogMapper, TLog> implements ITLogService {

}
