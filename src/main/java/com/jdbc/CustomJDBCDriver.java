package com.jdbc;

import com.jdbc.core.CustomConnection;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @ClassName CustomJDBCDriver
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/29 20:34
 * @Version 0.0.1
 **/
public class CustomJDBCDriver implements Driver  {
    private Channel channel; // 用于与服务器通信的Netty通道
    private final String host = "localhost"; // 服务器地址
    private final int port = 8080; // 服务器端口

    static {
        try {
            DriverManager.registerDriver(new CustomJDBCDriver());
        } catch (SQLException e) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (!acceptsURL(url)) {
            return null;
        }
        return new CustomConnection(url, info);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url != null && url.startsWith("jdbc:custom://");
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    private void initNettyConnection() {
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                            // 你可以添加更多的处理器，例如用于处理数据库协议的处理器
                        }
                    });

            // 连接到服务器
            channel = bootstrap.connect(host, port).sync().channel();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 当你完成后，关闭group
            // group.shutdownGracefully();
        }
    }
}
