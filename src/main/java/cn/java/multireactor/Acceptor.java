package cn.java.multireactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 作者: Jiang
 * 创建时间: 2021-07-28 20:47
 * 描述:
 */
public class Acceptor implements Runnable {

    final  Selector sel;
    final ServerSocketChannel serverSocketChannel;

    private final int POOL_SIZE= Runtime.getRuntime().availableProcessors();
    private int handleNext = 0;
    private Executor subReactorExecutor = Executors.newFixedThreadPool(POOL_SIZE);

    private Reactor[] subReactors = new Reactor[POOL_SIZE];

    public Acceptor(Selector sel, int port) throws IOException {
        this.sel = sel;
        this.serverSocketChannel = ServerSocketChannel.open();
        this.serverSocketChannel.socket().bind(new InetSocketAddress(port));
        this.serverSocketChannel.configureBlocking(false);
        this.serverSocketChannel.register(this.sel, SelectionKey.OP_ACCEPT,this);
    }


    private void init(){
        for (int i = 0; i < subReactors.length; i++) {
            subReactors[i] = new Reactor(sel);
            subReactorExecutor.execute(subReactors[i]);
        }
    }

    @Override
    public void run() {
        //负责处理
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel!=null){
                socketChannel.write(ByteBuffer.wrap("Myltiply Reactor Patterm\r\nreactor> ".getBytes()));
                System.out.println(Thread.currentThread().getName()+" Main-Reactor-Acceptor"+ socketChannel.getLocalAddress());
                Reactor subReactor = subReactors[handleNext];
                if(++handleNext == subReactors.length){
                    handleNext = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
