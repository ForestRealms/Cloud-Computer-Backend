
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
import org.openstack4j.model.compute.Server;

import javax.annotation.Nullable;


public abstract class AbstractCloudDesktopService implements Manageable<Server>, Networkable{
    /**
     * 启动一个云电脑
     * @param instance 要启动的云电脑实例
     */
    public abstract void start(Server instance);



    /**
     * 停止一个云电脑
     * @param instance 要停止的云电脑实例
     */
    public abstract void stop(Server instance);

    /**
     * 重新启动一个云电脑
     * @param instance 要重启的云电脑
     */
    public abstract void reboot(Server instance);

    /**
     * 挂起一台云电脑
     * @param instance 要挂起的云电脑
     */
    public abstract void suspend(Server instance);

    /**
     * 从挂起状态恢复一台云电脑
     * @param instance 要恢复状态的云电脑
     */
    public abstract void resume(Server instance);

    /**
     * 对一台已存在的云电脑重选规格
     * @param instance 要重选规格的云电脑
     * @param flavor 新的规格
     */
    public abstract void resize(Server instance, Flavor flavor);

    /**
     * 根据ID获取云电脑实例
     * @param Id 要找的云电脑实例的ID号
     * @return 云电脑实例
     * @apiNote 如果找不到，则返回<code>null</code>
     */
    @Nullable
    protected abstract Server getServerById(String Id);

    /**
     * 根据实例名称获取云电脑实例
     * @param InstanceName 实例名称
     * @return 云电脑实例
     * @apiNote 如果找不到，则返回<code>null</code>
     */
    @Nullable
    protected abstract Server getServerByInstanceName(String InstanceName);
}
