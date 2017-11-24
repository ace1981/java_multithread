# java_multithread

java 多线程学习

1 使用ScheduledExecutorService构建定时执行任务

```//初始化计划执行器服务对象
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
```
