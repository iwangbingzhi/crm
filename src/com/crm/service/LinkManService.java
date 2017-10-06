package com.crm.service;

import com.crm.dao.LinkManDao;
import com.crm.entity.LinkMan;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LinkManService {
    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    private LinkManDao linkManDao;

    public void addLinkMan(LinkMan linkMan) {
        linkManDao.add(linkMan);
    }
}
