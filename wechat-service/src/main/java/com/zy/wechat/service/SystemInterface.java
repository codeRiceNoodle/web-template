package com.zy.wechat.service;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class SystemInterface {
	
	public String exec(String... cmd){
		try {
			Process sub = new ProcessBuilder(cmd).start();
			BufferedInputStream in = new BufferedInputStream(sub.getInputStream());
			byte[] buf = new byte[2048];
			StringBuilder sb = new StringBuilder();
			while(in.read(buf, 0, buf.length)!=-1){
				sb.append(new String(buf));
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
