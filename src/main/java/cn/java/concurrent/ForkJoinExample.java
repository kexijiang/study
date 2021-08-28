package cn.java.concurrent;

import java.util.concurrent.*;

/**
 * 作者: Jiang
 * 时间: 2021/8/1
 * 描述:
 */
public class ForkJoinExample {


    //针对一个数字，做计算
    private static final Integer MAX = 200;
    static class CalcForkJoinTask extends  RecursiveTask<Integer>{
        private final Integer startValue;//子任务的开始计算的值
        private final Integer endValue;//子任务的结束计算的值

        public CalcForkJoinTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            if(endValue-startValue < MAX){
                System.out.println("开始计算：startValue："+startValue+";endValue:"+endValue);
                int totalValue = 0;
                for (int i = this.startValue; i < this.endValue; i++) {
                    totalValue += i;
                }
                return totalValue;
            }
            CalcForkJoinTask subTask = new CalcForkJoinTask(startValue,(startValue+endValue)/2);
            subTask.fork();
            CalcForkJoinTask calcForkJoinTask = new CalcForkJoinTask((startValue+endValue)/2+1,endValue);
            calcForkJoinTask.fork();
            return subTask.join()+ calcForkJoinTask.join();
        }
    }
    public static void main(String[] args) {
        CalcForkJoinTask calcForkJoinTask = new CalcForkJoinTask(1,10000);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(calcForkJoinTask);
        try{
            Integer result = task.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
