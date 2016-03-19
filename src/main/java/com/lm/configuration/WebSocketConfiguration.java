package com.lm.configuration;

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
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
    	
        registry.addEndpoint("/random").withSockJS();
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
    	
    	registry.enableStompBrokerRelay("/asyncTopic/","/asyncQueue/")
        .setRelayHost("100.100.11.188").setRelayPort(61613); // 设置broker的地址及端口号
    	registry.setApplicationDestinationPrefixes("/ws");
    }

	@Override
	public void configureClientInboundChannel(ChannelRegistration arg0) {
		
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		
	}

}