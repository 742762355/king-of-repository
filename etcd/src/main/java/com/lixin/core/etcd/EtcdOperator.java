package com.lixin.core.etcd;

import com.google.protobuf.ByteString;
import com.ibm.etcd.api.KeyValue;
import com.ibm.etcd.api.RangeResponse;
import com.ibm.etcd.client.EtcdClient;
import com.ibm.etcd.client.kv.KvClient;
import com.ibm.etcd.client.lease.LeaseClient;
import java.util.List;
import org.springframework.util.CollectionUtils;

/**
 * @author lixin@tongbaninfo.com
 */
public class EtcdOperator {

    private final KvClient kvClient;
    private final LeaseClient leaseClient;

    public EtcdOperator(EtcdClient client) {
        this.kvClient = client.getKvClient();
        this.leaseClient = client.getLeaseClient();
    }

    public void put(String key, String value) {
        kvClient.put(ByteString.copyFromUtf8(key), ByteString.copyFromUtf8(value)).sync();

    }

    public String get(String key) {
        RangeResponse rangeResponse = kvClient.get(ByteString.copyFromUtf8(key)).sync();
        List<KeyValue> keyValues = rangeResponse.getKvsList();

        if (CollectionUtils.isEmpty(keyValues)) {
            return null;
        }
        return keyValues.get(0).getValue().toStringUtf8();
    }
}
