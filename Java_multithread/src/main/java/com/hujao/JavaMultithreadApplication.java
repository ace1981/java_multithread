package com.hujao;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hujao.schedule.TokenWorkerProcess;

@SpringBootApplication
public class JavaMultithreadApplication {
	private static final Logger logger = Logger.getLogger(JavaMultithreadApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaMultithreadApplication.class, args);	
		
//		1、public static ExecutorService newFixedThreadPool(int nThreads)：创建一个可重用的、具有固定线程数的线程池。
//		2、public static ExecutorService newSingleThreadExecutor()：创建一个只有单线程的线程池，它相当于newFixedThreadPool方法是传入的参数为1
//		3、public static ExecutorService newCachedThreadPool()：创建一个具有缓存功能的线程池，系统根据需要创建线程，这些线程将会被缓存在线程池中。
//		4、public static ScheduledExecutorService newSingleThreadScheduledExecutor：创建只有一条线程的线程池，他可以在指定延迟后执行线程任务
//		5、public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)：创建具有指定线程数的线程池，它可以再指定延迟后执行线程任务，corePoolSize指池中所保存的线程数，即使线程是空闲的也被保存在线程池内。
 		//初始化计划执行器服务对象
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//可运行对象
		Runnable runnable = new Runnable() {
			public void run() {
				//任务方法
				TokenWorkerProcess.RefreshToken(); 
			}
		};
		//服务开始时间
		logger.info("\nstart service:" + new Date().toString());
		//第一次任务在2秒后开始
		int first=2;
		//每次任务3秒间隔
		int interval=1;
		//开始服务
		service.scheduleAtFixedRate(runnable, first, interval, TimeUnit.SECONDS);
	}
}
