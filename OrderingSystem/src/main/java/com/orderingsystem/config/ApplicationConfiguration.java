package com.orderingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.orderingsystem")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	};
	
	/*
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	 }

	 @Bean
	 RedisTemplate< String, Object > redisTemplate() {
		 final RedisTemplate< String, Object > template =  new RedisTemplate< String, Object >();
		 template.setConnectionFactory( jedisConnectionFactory() );
		 template.setKeySerializer( new StringRedisSerializer() );
		 template.setHashValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
		 template.setValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );
		 return template;
	 }
	 */
}
