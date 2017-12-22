package com.huanggit.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by huang on 2017-12-22-0022.
 */
@Data
@Component
@ConfigurationProperties(prefix = "huangboot.file")
public class FileServerConfig {

    private String serverRoot;

    private String storageRoot;
}
