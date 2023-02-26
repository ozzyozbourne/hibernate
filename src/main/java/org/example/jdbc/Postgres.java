package org.example.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Postgres {

   public static final HikariConfig config = new HikariConfig();
   public final static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:postgresql://172.17.0.2:5432/jpa" );
        config.setUsername( "ozzyoz" );
        config.setPassword( "qwerty" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }
   public static void initDataSource(){

   }

}
