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

import javax.annotation.Nullable;

/**
 * @author 等陌上花开
 */
public interface Flavorable extends Manageable<Flavor>{

    @Nullable
    Flavor getFlavorById(String FlavorId);

}
