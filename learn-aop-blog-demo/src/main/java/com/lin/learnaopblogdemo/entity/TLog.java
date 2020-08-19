package com.lin.learnaopblogdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lin
 * @since 2020-08-18
 */
public class TLog extends Model<TLog> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接口名称
     */
    private String operationName;

    /**
     * 请求参数
     */
    private String request;

    /**
     * 结果
     */
    private String response;

    /**
     * 是否异常
     */
    private Integer error;

    /**
     * 异常堆栈
     */
    private String stack;

    /**
     * 请求耗时，单位ms
     */
    private Long taketime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Long getTaketime() {
        return taketime;
    }

    public void setTaketime(Long taketime) {
        this.taketime = taketime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TLog{" +
        "id=" + id +
        ", operationName=" + operationName +
        ", request=" + request +
        ", response=" + response +
        ", error=" + error +
        ", stack=" + stack +
        ", taketime=" + taketime +
        ", createTime=" + createTime +
        "}";
    }
}
