package com.pengo.concurrency.exercise03;

import java.io.File;

public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s： The search has been interrupted", Thread.currentThread().getName());
            }
        }
    }

    //获取指定文件夹下的子文件和子文件夹
    private void directoryProcess(File file) throws InterruptedException {
//        System.out.printf("===>" + file.getName());
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    //搜索文件是否同名
    private void fileProcess(File file) throws InterruptedException {
//        System.out.println("--->"+file.getName());
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
