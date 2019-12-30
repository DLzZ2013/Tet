package cn.edu.global.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 19:58 2019/11/28
 * @Modified By:
 */
@ConfigurationProperties(prefix = "request")
@Data
@Component
public class RequestProperties {
    private String style;
    private String htmlUrl;
    private String successStyle;
}
