package com.shopping.portal.util;

import com.shopping.portal.service.adminbaseservice.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConfigurationUtil {

    @Autowired
    ConfigurationService configService;

    public static Map<String, String> constants = new HashMap<>();

    public String getMessage(String code){

        if(CommandUtil.isNotNull(constants.get(code))){
            return constants.get(code);

        }else if(CommandUtil.isNotNull(configService.findConstantsByCode(code))){

            constants = configService.updateConstants();
            System.out.println("Updating Constants");
            return configService.findConstantsByCode(code).getMessageEnglish();

        }

        return null;
    }

    public void updateConstants(){

        System.out.println("Updating Constants");
        constants = configService.updateConstants();
    }




}

