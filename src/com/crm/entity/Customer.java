package com.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 王炳智 on 2017/9/29.
 */
public class Customer {
    private Integer cid;
    private String custName;
    private String custLevel;
    private String custSource;
    private String custPhone;
    private String custMobile;
    //表示所有的联系人
    private Set<LinkMan> setlinkman = new HashSet<LinkMan>();

    public Set<LinkMan> getSetlinkman() {
        return setlinkman;
    }

    public void setSetlinkman(Set<LinkMan> setlinkman) {
        this.setlinkman = setlinkman;
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }
}
