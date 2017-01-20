package com.ihs.convergence.conf;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project name is ihs
 *
 * @author pengfei.zhou
 * @date 2017-1/20 
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class DBConfig {
    private String name;
    private String url;
    private String password;
    private String username;
    private String driverClassName;
    private Boolean autoCommit;
    private Integer minimumIdle;
    private Integer maximumPoolSize;
    private String connectionInitSql;
    private Boolean cachePrepStmts;
    private Integer prepStmtCacheSize;
    private Integer prepStmtCacheSqlLimit;
    private Boolean useServerPrepStmts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Boolean getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Integer getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(Integer minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public String getConnectionInitSql() {
        return connectionInitSql;
    }

    public void setConnectionInitSql(String connectionInitSql) {
        this.connectionInitSql = connectionInitSql;
    }

    public Boolean getCachePrepStmts() {
        return cachePrepStmts;
    }

    public void setCachePrepStmts(Boolean cachePrepStmts) {
        this.cachePrepStmts = cachePrepStmts;
    }

    public Integer getPrepStmtCacheSize() {
        return prepStmtCacheSize;
    }

    public void setPrepStmtCacheSize(Integer prepStmtCacheSize) {
        this.prepStmtCacheSize = prepStmtCacheSize;
    }

    public Integer getPrepStmtCacheSqlLimit() {
        return prepStmtCacheSqlLimit;
    }

    public void setPrepStmtCacheSqlLimit(Integer prepStmtCacheSqlLimit) {
        this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
    }

    public Boolean getUseServerPrepStmts() {
        return useServerPrepStmts;
    }

    public void setUseServerPrepStmts(Boolean useServerPrepStmts) {
        this.useServerPrepStmts = useServerPrepStmts;
    }
}
