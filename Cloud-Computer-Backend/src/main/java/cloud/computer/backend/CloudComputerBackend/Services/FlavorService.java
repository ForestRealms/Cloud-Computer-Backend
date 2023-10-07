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

import org.openstack4j.api.OSClient;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.compute.Flavor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 该服务是用于提供云电脑实例规格的服务。所有的云电脑创建都需要请求此
 * 服务下的函数和方法，因为这些方法能够直接向OpenStack发起请求，以
 * 创建、删除或者编辑实例规格。为了降低耦合性，请勿自行直接调用OpenStack，
 * 如果您需要对目前您所持有的OpenStack上的规格类型进行增删改查，请回调此服务。
 *
 * @author 等陌上花开
 * @see cloud.computer.backend.CloudComputerBackend.Services.Manageable
 * @since 1.0.0.0
 */
@Service
public class FlavorService extends AbstractFlavorService {

    private final OSClient.OSClientV3 client;
    private final org.openstack4j.api.compute.FlavorService flavorService;

    private FlavorService(OSClient.OSClientV3 client) {
        this.client = client;
        this.flavorService = this.client.compute().flavors();
    }

    @Override
    public Flavor getFlavorById(String FlavorId) {
        for (Flavor flavor : this.flavorService.list()) {
            if (flavor.getId().equals(FlavorId)) return flavor;

        }
        return null;
    }

    /**
     * 创建一种实例规格
     *
     * @param model {@code Flavor}类型对象。这里虽然接收的是{@code ModelEntity}
     *              但是这个实体必须可以被强制转换成{@code Flavor}
     * @see Manageable
     * @see ModelEntity
     * @see Flavor
     * @since 1.0.0.0
     */
    @Override
    public void create(ModelEntity model) {
        this.flavorService.create((Flavor) model);
    }

    /**
     * 删除一种实例规格
     *
     * @param Id 实例规格的ID号
     */
    @Override
    public void delete(String Id) {
        this.flavorService.delete(Id);
    }

    @Override
    public List<? extends Flavor> list() {
        return this.flavorService.list();
    }

    @Override
    public int getVcpus(Flavor flavor) {
        return flavor.getVcpus();
    }

    @Override
    public int getRam(Flavor flavor) {
        return flavor.getRam();
    }

    @Override
    public int getDisk(Flavor flavor) {
        return flavor.getDisk();
    }

    @Override
    public boolean isPublic(Flavor flavor) {
        return flavor.isPublic();
    }

    @Override
    public boolean isDisabled(Flavor flavor) {
        return flavor.isDisabled();
    }
}
