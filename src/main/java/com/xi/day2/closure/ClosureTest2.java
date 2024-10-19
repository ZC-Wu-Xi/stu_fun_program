package com.xi.day2.closure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClosureTest2 {

    // 闭包作用：给函数对象提供参数以外的数据
    public static void main(String[] args) throws IOException {
        // 创建 10 个任务对象，并且每个任务对象给一个任务编号
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int k = i + 1; // 任务编号
            Runnable task = () -> System.out.println(Thread.currentThread()+":执行任务" + k);
            list.add(task);
        }

        // 创建线程池
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        for (Runnable task : list) {
            service.submit(task); // 执行任务
        }
        System.in.read();// 使主线程等待用户输入，防止程序在提交所有任务后立即退出。
        /*
        System.in.read() 作用：
            等待任务完成：在没有这行代码的情况下，主线程在提交所有任务后可能会立即结束，导致程序在所有任务完成之前就退出。这会导致任务可能未能执行或输出被截断。
            保持程序运行：System.in.read(); 会阻塞主线程，直到用户在控制台输入内容并按下 Enter 键。这使得程序保持运行状态，允许异步提交的任务正常执行并输出结果。
            调试和观察输出：在开发和调试阶段，使用这种方式可以让开发者观察到任务的输出，确保所有任务都被正确执行。
         */
    }
}
