package cn.edu.global.common;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 19:44 2019/11/28
 * @Modified By:
 */
public class Constants {

     public interface Request{
         String STYLE = "html";
         String LOGIN_URL ="/login" ;
         String SUCCESS_STYLE = "json";
         String Login_HTML = "/login.html";
         String PHONE_LOGIN_URL = "/login/phone";
         String WEIXIN_LOGIN_URL = "authentication/wx";
     }


    public interface SysUserConstants {
        String ORIGINAL_PASSWORD = "123456";
        String SESSION_LOGIN_KEY = "user";

        String REDIS_NORMAL_USERS_KEY = "REDIS_NORMAL_USERS_KEY";
        String REDIS_FROZEN_USERS_KEY = "REDIS_FROZEN_USERS_KEY";
        String REDIS_DELETED_USERS_KEY = "REDIS_DELETED_USERS_KEY";
        Integer NORMAL_USERS_STATUS = 1;
        Integer FROZEN_USERS_STATUS = 0;
        Integer DELETED_USERS_STATUS = 2;
        String REDIS_USER_ROLE = "REDIS_USER_ROLE";
    }


    public interface SysDeptConstants {
        String REDIS_DEPT_KEY = "REDIS_DEPT_KEY";
        String REDIS_DEPT_CHILD_KEY = "REDIS_DEPT_CHILD_KEY";
        String REDIS_DEPT_ALL_CHILD_KEY = "REDIS_DEPT_ALL_CHILD_KEY";
    }

    public interface SysRoleContants {
        int ROLE_NORMAL= 1;
        String REDIS_ROLE_KEY = "REDIS_ROLE_KEY";
    }

    public interface SysPermissionConstants {
        String REDIS_ACLMODULE_CHILDREN = "REDIS_ACLMODULE_CHILDREN";
        String REDIS_ACLMODULE_KEY = "REDIS_ACLMODULE_KEY";

        String REDIS_ACL_KEY = "REDIS_ACL_KEY";
        Integer ACLMODULE_PARENT = 0;
        String REDIS_ROLE_ACL_KEY ="REDIS_ROLE_ACL_KEY" ;
    }

    public interface User {
        String IP = "ip";

        Integer NORMAL = 1;
    }

    public interface Private {
        String MAIL = "798679633@qq.com";
    }

    public interface Security {
        String CODE_IMAGE_KEY ="image_code_key" ;
        String CODE_IMAGE_KEY_EXPIRE ="image_code_key_expire" ;
        String CHECKTIME_PHONE_CODE = "checkTime_phone_code";
        String CHECKTIME_PHONE = "checkTime_phone";
        String WEIXIN_USER = "weixin_user";
    }

    public interface PROJECT {

        String CTIME_PROJECT_EXPIRE_KEY = "cTime_project_expire_key";
        String CTIME_PROJECT_EXPIRE_VALUE = "cTime_project_expire_value";
        int CTIME_PROJECT_EXPIRE = 10;
    }
}
