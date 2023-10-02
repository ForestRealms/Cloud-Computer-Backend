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

import org.jetbrains.annotations.Nullable;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.compute.ServerService;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.compute.*;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 具体提供云桌面服务逻辑的类，完全实现 {@link AbstractCloudDesktopService} 的所有方法。
 * @author 等陌上花开
 * @see cloud.computer.backend.CloudComputerBackend.Services.AbstractCloudDesktopService
 * @see cloud.computer.backend.CloudComputerBackend.Services.Manageable
 * @see cloud.computer.backend.CloudComputerBackend.Services.Networkable
 */
@Service
public class CloudDesktopService extends AbstractCloudDesktopService{

    private final OSClient.OSClientV3 client;
    private final ServerService serverService;
    private CloudDesktopService(OSClient.OSClientV3 client) {
        this.client = client;
        this.serverService = this.client.compute().servers();
    }

    /**
     * {@inheritDoc}
     * @param instance 要启动的云电脑实例
     */
    @Override
    public void start(Server instance) {
        this.serverService.action(instance.getId(), Action.START);
    }

    /**
     * {@inheritDoc}
     * @param instance 要停止的云电脑实例
     */
    @Override
    public void stop(Server instance) {
        this.serverService.action(instance.getId(), Action.STOP);
    }

    @Override
    public void reboot(Server instance) {
        this.serverService.reboot(instance.getId(), RebootType.SOFT);
    }

    @Override
    public void forceReboot(Server instance) {
        this.serverService.reboot(instance.getId(), RebootType.HARD);
    }

    @Override
    public void suspend(Server instance) {
        this.serverService.action(instance.getId(), Action.SUSPEND);
    }

    @Override
    public void resume(Server instance) {
        this.serverService.action(instance.getId(), Action.RESUME);
    }

    @Override
    public void resize(Server instance, Flavor flavor) {
        this.serverService.resize(instance.getId(), flavor.getId());
    }

    @Nullable
    @Override
    protected Server getServerById(String Id) {
        for (Server server : this.serverService.list()) {
            if(server.getId().equals(Id)) return server;
        }
        return null;
    }

    @Nullable
    @Override
    protected Server getServerByInstanceName(String InstanceName) {
        for (Server server : this.serverService.list()) {
            if(server.getInstanceName().equals(InstanceName)) return server;
        }
        return null;
    }


    @Override
    public void create(ModelEntity model) {
        this.serverService.boot((ServerCreate) model);
    }

    @Override
    public void delete(String Id) {
        this.serverService.delete(Id);
    }

    @Override
    public List<? extends Server> list() {
        return this.serverService.list(true);
    }

    @Override
    public String  getIPv4Address(ModelEntity entity) {
        return ((Server) entity).getAccessIPv4();
    }
}
