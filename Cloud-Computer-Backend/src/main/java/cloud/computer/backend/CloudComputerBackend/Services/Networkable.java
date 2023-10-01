package cloud.computer.backend.CloudComputerBackend.Services;

import org.openstack4j.model.compute.Server;

import java.net.Inet4Address;

/**
 * 表示可以接入网络
 */
public interface Networkable {
    Inet4Address getIPv4Address(Server instance);
}
