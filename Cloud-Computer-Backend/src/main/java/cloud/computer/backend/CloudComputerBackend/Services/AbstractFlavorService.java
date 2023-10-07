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

import org.openstack4j.model.compute.Flavor;

/**
 * @author 等陌上花开
 */
public abstract class AbstractFlavorService implements Flavorable, Manageable<Flavor> {

    /**
     * 查询某实例规格的CPU核心数量
     *
     * @param flavor 要查询实例规格的对象实体
     * @return 该实例规格的CPU核心数
     */
    public abstract int getVcpus(Flavor flavor);

    /**
     * 查询某实例规格的运行内存容量
     *
     * @param flavor 要查询的实例规格的对象实体
     * @return 本地磁盘的容量，单位是MB
     */
    public abstract int getRam(Flavor flavor);

    /**
     * 查询某实例规格的硬盘容量
     *
     * @param flavor 要查询的实例规格的对象实体
     * @return 本地磁盘的容量，单位是GB
     */
    public abstract int getDisk(Flavor flavor);

    /**
     * 查询某实例规格是否为公共规格
     *
     * @param flavor 要查询的实例规格的对象实体
     * @return 如果是公共规格，则返回{@code true}，否则返回{@code false}
     */
    public abstract boolean isPublic(Flavor flavor);

    /**
     * 查询某实例规格是否为不可用状态
     *
     * @param flavor 要查询的实例规格的对象实体
     * @return 如果该规格处于不可用状态，则返回{@code true}，否则返回{@code false}
     */
    public abstract boolean isDisabled(Flavor flavor);


}
