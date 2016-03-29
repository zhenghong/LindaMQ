package com.lm.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
	
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/random").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	
    	registry.enableStompBrokerRelay("/queue/","/topic/")
        .setRelayHost("100.100.11.188").setRelayPort(61613)
        .setSystemHeartbeatReceiveInterval(2000)
        .setSystemHeartbeatSendInterval(2000); // 设置broker的地址及端口号
    }

	@Override
	public void configureClientInboundChannel(ChannelRegistration registry) {	
		
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration registry) {

	}

}
