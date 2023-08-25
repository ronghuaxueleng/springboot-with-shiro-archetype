//package com.jzdata.aimedical.config;
//
//import org.apache.ibatis.io.VFS;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * MySQL MyBatis 数据源配置
// * 此 MapperScan 配置的包，已在启动类的 scanBasePackages 中包含。是否需要显示指定 selSessionTemplate
// *
// * @author: caoqiang
// * @create: 2019-04-20 14:19
// **/
//@Configuration
//@MapperScan(basePackages = "com.jzdata.aimedical.dao", sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
//public class DataSourceMysqlConfig {
//  @Bean(name = "mysqlDataSource")
//  @ConfigurationProperties(prefix = "spring.datasource")
//  @Primary
//  public DataSource dataSource() {
//    return DataSourceBuilder.create().build();
//  }
//
//  @Bean(name = "mysqlSqlSessionFactory")
//  @Primary
//  public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
//    // 避免MyBatis出现跨jar引用问题
//    VFS.addImplClass(SpringBootVFS.class);
//    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//    bean.setDataSource(dataSource);
//    bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
//
//    SqlSessionFactory sqlSessionFactory = bean.getObject();
//    // 取得类型转换注册器
//    assert sqlSessionFactory != null;
//    // 注册默认枚举转换器 因为在mybatis-config.xml中已经注册过，所以注释
////    TypeHandlerRegistry typeHandlerRegistry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
////    typeHandlerRegistry.setDefaultEnumTypeHandler(AutoEnumTypeHandler.class);
//
//
//    return sqlSessionFactory;
//  }
//
//  @Bean(name = "mysqlTransactionManager")
//  @Primary
//  public DataSourceTransactionManager transactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
//    return new DataSourceTransactionManager(dataSource);
//  }
//
//  @Bean(name = "mysqlSqlSessionTemplate")
//  @Primary
//  public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//    return new SqlSessionTemplate(sqlSessionFactory);
//  }
//}
