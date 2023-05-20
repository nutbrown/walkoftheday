package com.ssafy.osan.global.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.ssafy.osan.domain.user.dao", "com.ssafy.osan.domain.review.dao", "com.ssafy.osan.domain.route.dao", "com.ssafy.osan.domain.spot.dao", "com.ssafy.osan.domain.talk.dao" })
public class DBConfig {

}
