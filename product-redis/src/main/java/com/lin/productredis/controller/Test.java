package com.lin.productredis.controller;

import com.lin.productredis.service.ITPurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/16
 * \* Time: 20:01
 * \* Description:
 * \
 */

@RestController
public class Test {

    @Autowired
    private ITPurchaseRecordService purchaseRecordService;

    @PostMapping("/t")
    public R p(Integer uid, Integer proid, Integer quantity){

        boolean succ = purchaseRecordService.purchase(uid, proid, quantity);

        String m = succ ? "成功" : "失败";

        R r = new R(succ, m);
        return  r;

    }

    @PostMapping("/t1")
    public R p1(Integer uid, Integer proid, Integer quantity){

        boolean succ = purchaseRecordService.purchaseOptimstic(uid, proid, quantity);

        String m = succ ? "成功" : "失败";

        R r = new R(succ, m);
        return  r;

    }




    class R {
        private boolean succ = false;

        private String Msg = null;

        public R() {
        }

        public R(boolean succ, String msg) {
            this.succ = succ;
            Msg = msg;
        }

        public String getMsg() {
            return Msg;
        }

        public void setMsg(String msg) {
            Msg = msg;
        }

        public boolean isSucc() {
            return succ;
        }

        public void setSucc(boolean succ) {
            this.succ = succ;
        }
    }
}
