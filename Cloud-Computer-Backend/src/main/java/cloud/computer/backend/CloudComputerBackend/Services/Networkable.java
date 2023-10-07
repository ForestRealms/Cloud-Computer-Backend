/*
 * Copyright (c) 2023 All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 */

package cloud.computer.backend.CloudComputerBackend.Services;

import org.openstack4j.model.ModelEntity;

/**
 * 任何需要连接网络才可以工作的实体服务应当实现此接口
 *
 * @author 等陌上花开
 * @see Manageable
 * @since 1.0
 */
public interface Networkable {

    /**
     * 获取一个实体的IPv4地址
     *
     * @param entity 要获取IPv4地址的实体
     * @return IPv4地址
     */
    String getIPv4Address(ModelEntity entity);
}
