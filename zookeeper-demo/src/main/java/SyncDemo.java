import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 同步方式zookeeper的demo
 * Created by Rogear on 2020/5/19
 **/
public class SyncDemo implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String ADDRESS = "192.168.1.80,192.168.1.86,192.168.1.87";
    private static int TIMEOUT = 5000;
    private static String NODE_PATH = "/node_path";
    private static String NODE_VALUE = "node_value";

    public void process(WatchedEvent watchedEvent) {
        System.out.println("事件：" + watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws KeeperException, IOException, InterruptedException {
        //获取连接
        ZooKeeper zooKeeper = new ZooKeeper(ADDRESS, TIMEOUT, new SyncDemo());
        System.out.println("连接状态：" + zooKeeper.getState());
        countDownLatch.await();
        System.out.println("连接状态：" + zooKeeper.getState());
        //节点是否存在
        Stat stat =zooKeeper.exists(NODE_PATH,true);
        if (null == stat){
            //同步新建一个持久性的节点
            zooKeeper.create(NODE_PATH,NODE_VALUE.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("新建节点：" + NODE_PATH);
        } else {
            System.out.println("节点已存在");
        }
        //获取节点
        byte [] value = zooKeeper.getData(NODE_PATH,new SyncDemo(),new Stat());
        System.out.println("节点的值为：" + new String(value));

        //修改节点的值
        zooKeeper.setData(NODE_PATH,(NODE_VALUE+"_2").getBytes(),-1);
        byte [] value2 = zooKeeper.getData(NODE_PATH,new SyncDemo(),new Stat());
        System.out.println("修改后节点的值为：" + new String(value2));

        //删除节点
        zooKeeper.delete(NODE_PATH,-1);
        //节点是否存在
        stat =zooKeeper.exists(NODE_PATH,true);
        if (null == stat){
            System.out.println("节点已删除");
        }
    }
}
