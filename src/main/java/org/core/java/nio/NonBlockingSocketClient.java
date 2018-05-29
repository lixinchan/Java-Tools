package org.core.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author clx 2018/5/29.
 */
public class NonBlockingSocketClient {

	public static void main(String[] args) {
		String data = "Hello,nio!";
		client(data);
	}

	private static void client(String data) {
		try {
			SocketChannel sc = SocketChannel.open();
			sc.configureBlocking(false);
			sc.connect(new InetSocketAddress("127.0.0.1", 9999));
			while (!sc.finishConnect()) {
				System.out.println("Establish connect from server. time:" + System.currentTimeMillis());
				Thread.sleep(10);
			}
			System.out.println("Connection established.");
			ByteBuffer buffer = ByteBuffer.allocate(data.length());
			buffer.put(data.getBytes());
			buffer.flip();
			sc.write(buffer);
			buffer.clear();
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
