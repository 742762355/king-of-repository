package com.lixin.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author lixin@tongbaninfo.com
 */
@Document
public class TestDate {

    @Id
    private String id;

    private Date createDate;
}
