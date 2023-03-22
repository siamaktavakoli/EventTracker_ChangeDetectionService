package edu.miu.saproject.storage;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Kuylim TITH
 * Date: 3/20/2023
 */
public class InMemoryStorage {
    public static final Queue<Long> VALUE_HOLDING = new LinkedList<>();
    public static Double PREVIOUS_SD = 0D;

    private InMemoryStorage(){}

}
