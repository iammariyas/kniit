package org.kniit.lab_1.task_5;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DetailObject {
    public static BlockingQueue<Detail> detailsForQA = new LinkedBlockingQueue<>();
    public static BlockingQueue<Detail> detailsForCollector = new LinkedBlockingQueue<>();
}
