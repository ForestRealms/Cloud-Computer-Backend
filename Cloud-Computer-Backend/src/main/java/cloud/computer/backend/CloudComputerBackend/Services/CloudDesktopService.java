package cloud.computer.backend.CloudComputerBackend.Services;

import org.jetbrains.annotations.Nullable;
import org.openstack4j.common.Buildable;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Server;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.List;

@Service
public class CloudDesktopService extends AbstractCloudDesktopService{

    /**
     * 启动一个云电脑
     *
     * @param instance 要启动的云电脑实例
     */
    @Override
    public void start(Server instance) {

    }

    /**
     * 停止一个云电脑
     *
     * @param instance 要停止的云电脑实例
     */
    @Override
    public void stop(Server instance) {

    }

    /**
     * 重新启动一个云电脑
     *
     * @param instance 要重启的云电脑
     */
    @Override
    public void reboot(Server instance) {

    }

    /**
     * 挂起一台云电脑
     *
     * @param instance 要挂起的云电脑
     */
    @Override
    public void suspend(Server instance) {

    }

    /**
     * 从挂起状态恢复一台云电脑
     *
     * @param instance 要恢复状态的云电脑
     */
    @Override
    public void resume(Server instance) {

    }

    /**
     * 对一台已存在的云电脑重选规格
     *
     * @param instance 要重选规格的云电脑
     * @param flavor   新的规格
     */
    @Override
    public void resize(Server instance, Flavor flavor) {

    }

    /**
     * 根据ID获取云电脑实例
     *
     * @param Id 要找的云电脑实例的ID号
     * @return 云电脑实例
     * @apiNote 如果找不到，则返回<code>null</code>
     */
    @Nullable
    @Override
    protected Server getServerById(String Id) {
        return null;
    }

    /**
     * 根据实例名称获取云电脑实例
     *
     * @param InstanceName 实例名称
     * @return 云电脑实例
     * @apiNote 如果找不到，则返回<code>null</code>
     */
    @Nullable
    @Override
    protected Server getServerByInstanceName(String InstanceName) {
        return null;
    }

    /**
     * 创建被管理的类型的对象
     * 例如：如果泛型<code>T</code>表示Server，则此函数应当
     * 实现对于Server对象在OpenStack中创建的过程
     *
     * @param build 可构建的对象
     */
    @Override
    public void create(Buildable<Server> build) {

    }

    /**
     * 删除被管理的类型的对象
     *
     * @param Id 对象的ID
     */
    @Override
    public void delete(String Id) {

    }

    @Override
    public List<Server> list() {
        return null;
    }

    @Override
    public Inet4Address getIPv4Address(Server instance) {
        return null;
    }
}
