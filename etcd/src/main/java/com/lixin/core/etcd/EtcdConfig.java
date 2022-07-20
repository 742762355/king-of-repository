package com.lixin.core.etcd;

import com.ibm.etcd.client.EtcdClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixin@tongbaninfo.com
 */
@Configuration
public class EtcdConfig {

    @Value("${etcd.server:http://127.0.0.1:2379}")
    private String ectdServers;

    @Bean
    public EtcdOperator etcdOperator() {
        EtcdClient etcdClient = EtcdClient.forEndpoints(ectdServers).withPlainText().build();
        return new EtcdOperator(etcdClient);
    }

}
