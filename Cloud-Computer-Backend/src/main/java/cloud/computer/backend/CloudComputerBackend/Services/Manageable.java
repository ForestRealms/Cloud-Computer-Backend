package cloud.computer.backend.CloudComputerBackend.Services;

import org.openstack4j.common.Buildable;

import java.util.List;

/**
 * 提供可管理功能
 * @param <T> 管理的对象的类型
 */
public interface Manageable<T> {

    /**
     * 创建被管理的类型的对象
     * 例如：如果泛型<code>T</code>表示Server，则此函数应当
     * 实现对于Server对象在OpenStack中创建的过程
     * @param build 可构建的对象
     */
    void create(Buildable<T> build);

    /**
     * 删除被管理的类型的对象
     * @param Id 对象的ID
     */
    void delete(String Id);
    List<T> list();
}
