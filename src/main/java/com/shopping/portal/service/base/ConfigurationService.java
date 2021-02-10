package com.shopping.portal.service.base;


import com.shopping.portal.entity.ConfigurationEntity;

import java.util.Map;

public interface ConfigurationService {
    Map updateConstants();
    ConfigurationEntity findConstantsByCode(String code);
}
