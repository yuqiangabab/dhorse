package org.dhorse.rest.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.dhorse.infrastructure.repository.po.LogRecordPO;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketCache {

	private static final Map<WebSocketSession, LogRecordPO> SESSION_KEY_CACHE = new ConcurrentHashMap<>();
	
	private static final Map<String, WebSocketSession> BIZ_ID_KEY_CACHE = new ConcurrentHashMap<>();
	
	public static void put(WebSocketSession session, LogRecordPO lastRecordPO) {
		SESSION_KEY_CACHE.put(session, lastRecordPO);
		BIZ_ID_KEY_CACHE.put(lastRecordPO.getBizId() + lastRecordPO.getLogType(), session);
	}
	
	public static WebSocketSession get(String bizId) {
		return BIZ_ID_KEY_CACHE.get(bizId);
	}
	
	public static void remove(WebSocketSession session) {
		LogRecordPO lastRecord = SESSION_KEY_CACHE.remove(session);
		if(lastRecord == null) {
			return;
		}
		BIZ_ID_KEY_CACHE.remove(lastRecord.getBizId() + lastRecord.getLogType());
		lastRecord = null;
		try {
			session.close();
			session = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeExpired() {
		for(Entry<WebSocketSession, LogRecordPO> entity : SESSION_KEY_CACHE.entrySet()) {
			if(entity.getValue() == null) {
				remove(entity.getKey());
			}
			//如果在120s内没有新日志写入，则认为以后就不会有日志输出了，同时关闭socket
			if(System.currentTimeMillis() - entity.getValue().getCreationTime().getTime() > 120 * 1000) {
				remove(entity.getKey());
			}
		}
	}
}
