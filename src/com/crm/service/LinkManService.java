package com.crm.service;

import com.crm.dao.LinkManDao;
import com.crm.entity.LinkMan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LinkManService {
    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    private LinkManDao linkManDao;

    public void addLinkMan(LinkMan linkMan) {
        linkManDao.add(linkMan);
    }

    public List<LinkMan> listLinkMan() {
        return linkManDao.list();
    }

    public LinkMan findOne(int linkid) {
        return linkManDao.findOne(linkid);

    }
    //修改联系人操作
    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }
}
