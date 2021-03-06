package com.dianrong.common.uniauth.client.config.configurations;

import com.dianrong.common.uniauth.client.config.Configure;
import com.dianrong.common.uniauth.client.config.UniauthConfigEnvLoadCondition;
import com.dianrong.common.uniauth.client.custom.filter.UniauthJWTLogoutFilter;
import com.dianrong.common.uniauth.client.custom.handler.CompatibleAjaxLoginSuccessHandler;
import com.dianrong.common.uniauth.client.custom.jwt.JWTQuery;
import com.dianrong.common.uniauth.common.client.enums.AuthenticationType;
import com.dianrong.common.uniauth.common.jwt.UniauthJWTSecurity;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 配置一个JWT的登出处理Filter.
 *
 * @author wanglin
 */
@Component
@Conditional(UniauthConfigEnvLoadCondition.class)
public class JWTLogoutFilterConfigure implements Configure<UniauthJWTLogoutFilter> {

  @Resource(name = "uniauthConfig")
  private Map<String, String> uniauthConfig;

  @Autowired
  private UniauthJWTSecurity uniauthJWTSecurity;

  @Resource(name = "securityContextLogoutHandler")
  private LogoutHandler securityContextLogoutHandler;

  @Autowired(required = false)
  private LogoutSuccessHandler logoutSuccessHandler;
  
  @Value("#{domainDefine.authenticationType}")
  private AuthenticationType authenticationType;

  @Autowired
  private JWTQuery jwtQuery;

  @Override
  public UniauthJWTLogoutFilter create(Object... args) {
    if (logoutSuccessHandler == null) {
      CompatibleAjaxLoginSuccessHandler logoutSuccessHandler =
          new CompatibleAjaxLoginSuccessHandler();
      logoutSuccessHandler.setDefaultTargetUrl(getCasLogoutUrl());
      this.logoutSuccessHandler = logoutSuccessHandler;
    }
    UniauthJWTLogoutFilter logoutFilter = new UniauthJWTLogoutFilter(this.uniauthJWTSecurity,
        this.logoutSuccessHandler, this.securityContextLogoutHandler);
    logoutFilter.setJwtQuery(jwtQuery);
    logoutFilter.setAuthenticationType(this.authenticationType);
    return logoutFilter;
  }

  @Override
  public boolean isSupport(Class<?> cls) {
    return UniauthJWTLogoutFilter.class.equals(cls);
  }

  private String getCasLogoutUrl() {
    return uniauthConfig.get("cas_server") + "/logout";
  }
}
