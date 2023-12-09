package com.beauhinks.example.purejavacomm;

import com.github.snksoft.crc.CRC;
import io.netty.buffer.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.ByteArrayInputStream;
import java.util.HexFormat;


public class PureJavaCommClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf buffer = Unpooled.buffer();
        ByteBufUtil.hexDump(new )
        buffer.writeBytes(HexFormat.of().parseHex("02")); //STX
        buffer.writeBytes(HexFormat.of().parseHex("00")); //Sequence number

        buffer.writeBytes(HexFormat.of().parseHex("03")); //ETX
        CRC.Parameters
        ctx.writeAndFlush(buffer);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        if ("OK".equals(msg)) {
            System.out.println("Serial port responded to AT");
        } else {
            System.out.println("Serial port responded with not-OK: " + msg);
        }
        ctx.close();
    }
}
